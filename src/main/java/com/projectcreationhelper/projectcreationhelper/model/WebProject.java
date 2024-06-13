package com.projectcreationhelper.projectcreationhelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document
public class WebProject extends Project {
    @Id
    private String id;
    private String name;
    private String description;
    private List<String> designDevelopment;
    private List<String> layout;
    private List<String> webDevelopment;
    private List<String> deployment;
    private List<Item> items;
    private List<String> qa;
    private List<String> frontend;
    private List<String> connectionCMS;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

    public WebProject() {
    }

    public WebProject(String id,
                      User user,
                      LocalDateTime createdAt,
                      LocalDateTime updatedAt,
                      String createdBy,
                      String updatedBy,
                      String name,
                      String description,
                      List<String> designDevelopment,
                      List<String> layout,
                      List<String> webDevelopment,
                      List<String> deployment,
                      List<Item> items,
                      List<String> qa,
                      List<String> frontend,
                      List<String> connectionCMS,
                      LocalDateTime createdAt1,
                      LocalDateTime updatedAt1,
                      String createdBy1,
                      String updatedBy1) {
        super(id, user, createdAt, updatedAt, createdBy, updatedBy);
        this.name = name;
        this.description = description;
        this.designDevelopment = designDevelopment;
        this.layout = layout;
        this.webDevelopment = webDevelopment;
        this.deployment = deployment;
        this.items = items;
        this.qa = qa;
        this.frontend = frontend;
        this.connectionCMS = connectionCMS;
        this.createdAt = createdAt1;
        this.updatedAt = updatedAt1;
        this.createdBy = createdBy1;
        this.updatedBy = updatedBy1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getDesignDevelopment() {
        return designDevelopment;
    }

    public void setDesignDevelopment(List<String> designDevelopment) {
        this.designDevelopment = designDevelopment;
    }

    public List<String> getLayout() {
        return layout;
    }

    public void setLayout(List<String> layout) {
        this.layout = layout;
    }

    public List<String> getWebDevelopment() {
        return webDevelopment;
    }

    public void setWebDevelopment(List<String> webDevelopment) {
        this.webDevelopment = webDevelopment;
    }

    public List<String> getDeployment() {
        return deployment;
    }

    public void setDeployment(List<String> deployment) {
        this.deployment = deployment;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<String> getQa() {
        return qa;
    }

    public void setQa(List<String> qa) {
        this.qa = qa;
    }

    public List<String> getFrontend() {
        return frontend;
    }

    public void setFrontend(List<String> frontend) {
        this.frontend = frontend;
    }

    public List<String> getConnectionCMS() {
        return connectionCMS;
    }

    public void setConnectionCMS(List<String> connectionCMS) {
        this.connectionCMS = connectionCMS;
    }

    @Override
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    @Override
    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String getCreatedBy() {
        return createdBy;
    }

    @Override
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String getUpdatedBy() {
        return updatedBy;
    }

    @Override
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WebProject that)) return false;
        if (!super.equals(o)) return false;

        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getId().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "WebProject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", designDevelopment=" + designDevelopment +
                ", layout=" + layout +
                ", webDevelopment=" + webDevelopment +
                ", deployment=" + deployment +
                ", items=" + items +
                ", qa=" + qa +
                ", frontend=" + frontend +
                ", connectionCMS=" + connectionCMS +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
