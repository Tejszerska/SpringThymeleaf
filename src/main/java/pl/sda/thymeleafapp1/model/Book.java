package pl.sda.thymeleafapp1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Size(min = 2, max = 10)
    private String title;
    @NotBlank
    private String author;
}
