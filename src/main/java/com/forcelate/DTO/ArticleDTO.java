package com.forcelate.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.forcelate.Entity.Enum.Color;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor

public class ArticleDTO {

    private Long id;

    @NotNull
    @Size(min = 1)
    private String text;

    @NotNull(message = "color cant be null")
    private Color color;


    @NotNull
    private UserDTO user;

    public ArticleDTO(Long id, String text, Color color, UserDTO user) {
        this.id = id;
        this.text = text;
        this.color = color;
        this.user = user;
    }
}
