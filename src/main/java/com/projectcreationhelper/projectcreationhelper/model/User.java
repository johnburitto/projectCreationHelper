package com.projectcreationhelper.projectcreationhelper.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    public String id;
    public String name;
    public String email;
    public String phoneNumber;
    public String siteUrl;
    public String projectGoal;
    public String monetizationModel;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
