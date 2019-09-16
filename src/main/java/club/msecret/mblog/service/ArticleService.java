package club.msecret.mblog.service;

import java.util.List;

import club.msecret.mblog.entity.Article;

public interface ArticleService {
    //@Cacheable(value = "article")
    List<Article> findAll();

    List<Article> findArticlesByTag(Integer tagId);

    List<Article> findArticlesByTagName(String tagName);

    Article findArticleById(Long articleId);

    Article findLast(Long articleId);

    Article findNext(Long articleId);

    List<Article> findArticlesByCategoryName(String category);

    void hideBlog(Long articleId);

    void showBlog(Long articleId);

    void deleteBlogById(Long articleId);

    void addArticle(Article article);
}
