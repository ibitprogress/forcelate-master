package com.forcelate.Repository;
import com.forcelate.Entity.Enum.Color;
import com.forcelate.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findAllByAgeAfter(int age);

    Optional<UserEntity> findById(Long id);

    List<UserEntity> findAllByArticlesColor(Color color);

 //   @Query(value = "SELECT DISTINCT user.name FROM UserEntity user where size(user.articles) > ?1")

    @Query(value = "SELECT DISTINCT user.name FROM UserEntity user where ?1 < (select count(art.id) from user.articles art where art.user = user)")
    List<String> getAllByArticles(Long articleCount);

}