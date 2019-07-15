package com.forcelate.ServiceAndIMPL.ServiceIMPL;
import com.forcelate.DTO.ArticleDTO;
import com.forcelate.Entity.ArticleEntity;
import com.forcelate.ObjectMapperUtils;
import com.forcelate.Repository.ArticleRepository;
import com.forcelate.ServiceAndIMPL.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceIMPL implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ObjectMapperUtils objectMapperUtils;

    @Override
    public void saveArticle(ArticleDTO article) {
        ArticleEntity articleEntity = objectMapperUtils.map(article, ArticleEntity.class);
        articleRepository.save(articleEntity);
    }

}
