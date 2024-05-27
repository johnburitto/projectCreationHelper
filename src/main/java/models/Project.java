package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    @Id
    public String id;
    public User user;
    public LocalDateTime createdAt;
    public LocalDateTime updatedAt;
}
