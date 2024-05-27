package com.projectcreationhelper.projectcreationhelper.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class MarketingProject extends Project {
    public List<String> contentMarketing;
    public List<String> emailMarketing;
    public List<String> seo;
    public List<String> socialMarketing;
    public List<String> mediaAds;
    public List<String> videoMarketing;
}
