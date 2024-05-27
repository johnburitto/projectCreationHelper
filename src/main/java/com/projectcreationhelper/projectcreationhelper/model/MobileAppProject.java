package com.projectcreationhelper.projectcreationhelper.model;

import com.projectcreationhelper.projectcreationhelper.enums.DeployStore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MobileAppProject extends Project {
    public List<String> designMockDevelopment;
    public List<String> api;
    public List<String> webDevelopment;
    public DeployStore deployStore;
    public List<String> qa;
}