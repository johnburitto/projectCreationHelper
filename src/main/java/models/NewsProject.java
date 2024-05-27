package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NewsProject extends Project {
    public List<String> designDevelopment;
    public List<String> layout;
    public List<String> webDevelopment;
    public List<String> deployment;
    public List<String> qa;
}
