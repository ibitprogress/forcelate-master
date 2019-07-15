package com.forcelate.Controller;
import com.forcelate.DTO.ArticleDTO;
import com.forcelate.DTO.ExceptionResponse;
import com.forcelate.ServiceAndIMPL.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("/article/")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping
    public ResponseEntity<?> createArticle(@Valid @RequestBody ArticleDTO article,
                                           BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            String field = bindingResult.getFieldErrors().get(0).getField();
            String message = bindingResult.getFieldErrors().get(0).getDefaultMessage();
            return new ResponseEntity<>(new ExceptionResponse("validation " + field + " failed", message), HttpStatus.BAD_REQUEST);
        }

        articleService.saveArticle(article);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

}
