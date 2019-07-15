package com.forcelate;

import com.forcelate.Entity.ArticleEntity;
import com.forcelate.Entity.Enum.Color;
import com.forcelate.Entity.UserEntity;
import com.forcelate.Repository.ArticleRepository;
import com.forcelate.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class ForcelateApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ForcelateApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i <=8; i++){
            UserEntity userEntity1 = new UserEntity();
            userEntity1.setAge(1 + i);
            userEntity1.setName("Name1" + i);
            userEntity1 = userRepository.save(userEntity1);

            Random r = new Random();
            for(int j = 0; j <=r.nextInt(5); j++){
                ArticleEntity articleEntity = new ArticleEntity();
                articleEntity.setColor(randomEnum(Color.class));
                articleEntity.setText("Text1" + i);
                articleEntity.setUser(userEntity1);
                articleRepository.save(articleEntity);
            }

        }
    }
    private static final SecureRandom random = new SecureRandom();
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz){
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
