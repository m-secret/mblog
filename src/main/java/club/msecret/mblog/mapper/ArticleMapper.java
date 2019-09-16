package club.msecret.mblog.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

import club.msecret.mblog.entity.Article;

@Repository
public interface ArticleMapper {

    List<Article> findAllArticles();

    List<Article> searchArticles(String key);

    List<Long> findArticleIdByTagId(Integer tagId);

    Article findArticleById(Long articleId);

    Article findLastArticleByCurrentId(Long articleId);

    Article findNextArticleByCurrentId(Long articleId);

    List<Article> findArticlesByCategoryName(String category);

    void showBlog(Long articleId);

    void hideBlog(Long articleId);

    void deleteArticleById(Long articleId);

    void deleteArticleTagsByArticleId(Long articleId);

    void deleteArticleCategoryByArticleId(Long articleId);

    void addArticle(Article article);

    List<Article> findArticlesByTagName(String tagName);
}
