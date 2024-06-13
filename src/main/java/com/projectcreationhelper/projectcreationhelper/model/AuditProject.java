package com.projectcreationhelper.projectcreationhelper.model;

import com.projectcreationhelper.projectcreationhelper.enums.SiteFramework;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AuditProject extends Project {

    public SiteFramework siteFramework;
    public String additionalFramework;
    public List<String> remarks;
    public boolean wasDDOSed;
}
