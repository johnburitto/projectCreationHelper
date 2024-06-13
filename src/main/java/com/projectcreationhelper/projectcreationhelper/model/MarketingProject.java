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
public class MarketingProject extends Project {
    @Id
    private String id; // UUID
    private String name;
    private String description;
    public List<String> contentMarketing;
    public List<String> emailMarketing;
    public List<String> seo;
    public List<String> socialMarketing;
    public List<String> mediaAds;
    public List<String> videoMarketing;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String createdBy;
    private String updatedBy;

    public MarketingProject(String id,
                            String name,
                            String description,
                            List<String> contentMarketing,
                            List<String> emailMarketing,
                            List<String> seo,
                            List<String> socialMarketing,
                            List<String> mediaAds,
                            List<String> videoMarketing,
                            LocalDateTime createdAt,
                            LocalDateTime updatedAt,
                            String createdBy,
                            String updatedBy) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.contentMarketing = contentMarketing;
        this.emailMarketing = emailMarketing;
        this.seo = seo;
        this.socialMarketing = socialMarketing;
        this.mediaAds = mediaAds;
        this.videoMarketing = videoMarketing;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
    public MarketingProject() {}

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
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

    public List<String> getContentMarketing() {
        return contentMarketing;
    }

    public void setContentMarketing(List<String> contentMarketing) {
        this.contentMarketing = contentMarketing;
    }

    public List<String> getEmailMarketing() {
        return emailMarketing;
    }

    public void setEmailMarketing(List<String> emailMarketing) {
        this.emailMarketing = emailMarketing;
    }

    public List<String> getSeo() {
        return seo;
    }

    public void setSeo(List<String> seo) {
        this.seo = seo;
    }

    public List<String> getSocialMarketing() {
        return socialMarketing;
    }

    public void setSocialMarketing(List<String> socialMarketing) {
        this.socialMarketing = socialMarketing;
    }

    public List<String> getMediaAds() {
        return mediaAds;
    }

    public void setMediaAds(List<String> mediaAds) {
        this.mediaAds = mediaAds;
    }

    public List<String> getVideoMarketing() {
        return videoMarketing;
    }

    public void setVideoMarketing(List<String> videoMarketing) {
        this.videoMarketing = videoMarketing;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        MarketingProject that = (MarketingProject) o;
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
        return "MarketingProject{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", contentMarketing=" + contentMarketing +
                ", emailMarketing=" + emailMarketing +
                ", seo=" + seo +
                ", socialMarketing=" + socialMarketing +
                ", mediaAds=" + mediaAds +
                ", videoMarketing=" + videoMarketing +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy='" + createdBy + '\'' +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
