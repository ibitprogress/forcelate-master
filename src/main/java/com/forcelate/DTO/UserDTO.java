package com.forcelate.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDTO {

    private Long id;

    @NotNull
    @Size(min = 1)
    private String name;


    @Min(value = 1)
    @Max(value = 100)
    private int age;

    @JsonIgnoreProperties("user")
    private List<ArticleDTO> articles;

    public UserDTO(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
