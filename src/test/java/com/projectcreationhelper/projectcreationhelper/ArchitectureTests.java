package com.projectcreationhelper.projectcreationhelper;
/*
  @author   Olga Bosovik
  @project   project-creation-helper
  @class  ArchTests
  @version  1.0.0
  @since 11.05.24 - 12.40
*/

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.lang.CompositeArchRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.*;
import static com.tngtech.archunit.library.Architectures.layeredArchitecture;
import static com.tngtech.archunit.library.GeneralCodingRules.*;

@SpringBootTest
class ArchitectureTests {

    private JavaClasses applicationClasses;

    @BeforeEach
     void init() {
        applicationClasses = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_JARS)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .importPackages("edu.pro.spbbase");
    }

    @Test
    void shouldFollowLayerArchitecture() {
        layeredArchitecture()
                .consideringAllDependencies()
                .layer("Controller").definedBy("..controller..")
                .layer("Service").definedBy("..service..")
                .layer("Repository").definedBy("..repository..")
                //
                .whereLayer("Controller").mayNotBeAccessedByAnyLayer()
                .whereLayer("Service").mayOnlyBeAccessedByLayers("Controller","Service")
                .whereLayer("Repository").mayOnlyBeAccessedByLayers("Service")
                //
                .check(applicationClasses);
    }

    @Test
    void servicesShouldNotDependOnController() {
        noClasses()
                .that().resideInAPackage("..service..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..controller..")
                .because("out of arch rules")
                .check(applicationClasses);
    }

    @Test
    void repositoriesShouldNotDependOnController() {
        noClasses()
                .that().resideInAPackage("..repository..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..controller..")
                .because("out of arch rules")
                .check(applicationClasses);
    }

    @Test
    void controllersShouldNotDependOnOtherControllers() {
        noClasses()
                .that().resideInAPackage("..controller..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..controller..")
                .because("out of arch rules")
                .check(applicationClasses);
    }

    @Test
    void repositoriesShouldNotDependOnServices() {
        noClasses()
                .that().resideInAPackage("..repository..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..service..")
                .because("out of arch rules")
                .check(applicationClasses);
    }

    @Test
    void repositoriesShouldNotDependOnServiceAndRepository() {
        noClasses()
                .that().resideInAPackage("..repository..")
                .should()
                .dependOnClassesThat()
                .resideInAPackage("..service..")
                .because("out of arch rules")
                .check(applicationClasses);
    }

    @Test
    void controllerClassesShouldBeNamedXController() {
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .haveSimpleNameEndingWith("Controller")
                .check(applicationClasses);

    }

    @Test
    void repositoryClassesShouldBeNamedXRepository() {
        classes()
                .that().resideInAPackage("..repository..")
                .should()
                .haveSimpleNameEndingWith("Repository")
                .check(applicationClasses);
    }

    @Test
    void serviceClassesShouldBeNamedXServiceImpl() {
        classes()
                .that().resideInAPackage("..service..")
                .should()
                .haveSimpleNameEndingWith("ServiceImpl")
                .check(applicationClasses);
    }

    @Test
    void dtoClassesShouldBeNamedXDto() {
        classes()
                .that().resideInAPackage("..dto..")
                .should()
                .haveSimpleNameEndingWith("Dto")
                .check(applicationClasses);
    }

    @Test
    void exceptionClassesShouldBeNamedXException() {
        classes()
                .that().resideInAPackage("..exception..")
                .should()
                .haveSimpleNameEndingWith("Exception")
                .check(applicationClasses);
    }
    @Test
    void configurationClassesShouldBeNamedXConfig() {
        classes()
                .that().resideInAPackage("..config..")
                .should()
                .haveSimpleNameEndingWith("Config")
                .check(applicationClasses);
    }
    @Test
    void utilityClassesShouldBeNamedXUtils() {
        classes()
                .that().resideInAPackage("..utils..")
                .should()
                .haveSimpleNameEndingWith("Utils")
                .check(applicationClasses);
    }


    @Test
    void controllerClassesShouldBeAnnotatedBy() {
        classes()
                .that().resideInAPackage("..controller..")
                .should()
                .beAnnotatedWith(RestController.class)
                .andShould()
                .beAnnotatedWith(RequestMapping.class)
                .andShould()
                .beAnnotatedWith(CrossOrigin.class)
                .check(applicationClasses);
    }

    @Test
    void shouldNotUseFieldsAutowired() {
        noFields()
                .should()
                .beAnnotatedWith(Autowired.class)
                .check(applicationClasses);
    }

    @Test
    public void classes_should_not_access_standard_streams_defined_by_hand() {
        noClasses().should(ACCESS_STANDARD_STREAMS).check(applicationClasses);
    }

    @Test
    public void classes_should_not_access_standard_streams_from_library() {
        NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS.check(applicationClasses);
    }

    @Test
    public void classes_should_not_throw_generic_exceptions() {
        NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS.check(applicationClasses);
    }

    @Test
    public void classes_should_not_use_java_util_logging() {
        NO_CLASSES_SHOULD_USE_JAVA_UTIL_LOGGING.check(applicationClasses);
    }

    @Test
    public void classes_should_not_use_jodatime() {
        NO_CLASSES_SHOULD_USE_JODATIME.check(applicationClasses);
    }

    @Test
    public void classes_should_not_use_field_injection() {
        NO_CLASSES_SHOULD_USE_FIELD_INJECTION.check(applicationClasses);
    }

    @Test
    public void no_classes_should_access_standard_streams_or_throw_generic_exceptions() {
        CompositeArchRule.of(NO_CLASSES_SHOULD_ACCESS_STANDARD_STREAMS)
                .and(NO_CLASSES_SHOULD_THROW_GENERIC_EXCEPTIONS).check(applicationClasses);
    }

    @Test
    void shouldNotUseNoPrivateFields() {
        fields()
                .that().areDeclaredInClassesThat()
                .resideInAPackage("..model..")
                .should().notBePublic()
                .because("Public fields are not allowed in model classes")
                .check(applicationClasses);
    }

     @Test
    void shouldHaveIdField() {
        fields()
                .that().areDeclaredInClassesThat()
                .resideInAPackage("..model..")
                .and().haveFullName("id")
                .should().bePrivate()
                .check(applicationClasses);
    }


    @Test
    void shouldHaveEnumsInPackage() {
        classes()
                .that()
                .resideInAPackage("..enums..")
                .should().beEnums()
                .check(applicationClasses);
    }

    @Test
    void shouldHaveDocumentAnnotationInPackageModel() {
        classes()
                .that()
                .resideInAPackage("..model..")
                .should().beAnnotatedWith(Document.class)
                .check(applicationClasses);
    }

        @Test
    void shouldBeInterefaces() {
            classes()
                    .that().haveSimpleNameEndingWith("Repository")
                    .should().beInterfaces()
                .check(applicationClasses);
    }


}


