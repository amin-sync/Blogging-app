package com.example.blogapplication.payloads;

import com.example.blogapplication.models.Post;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Data
public class CategoryDto {
    private Integer id;
    @NotEmpty
    @Size(min = 4, message = "The title must be min of 4 char")
    private String title;
    @NotEmpty
    @Size(min = 10)
    private String description;


}
