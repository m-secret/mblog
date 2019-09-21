package club.msecret.mblog.service.Impl;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Article;
import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.mapper.ArticleMapper;
import club.msecret.mblog.mapper.TagMapper;
import club.msecret.mblog.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    @Resource
    private TagMapper tagMapper;

    @Override
    // @Cacheable(value = "articles")
    public List<Article> findAll() {
        List<Article> articles = articleMapper.findAllArticles();
        for (Article article : articles) {
            List<Tag> tags = findArticleTagsById(article.getArticleId());
            article.setTags(tags);
        }
        return articles;
    }

    @Override
    //@Cacheable(value = "articleCategory", key = "#tagId")
    public List<Article> findArticlesByTag(Integer tagId) {
        List<Long> articleId = articleMapper.findArticleIdByTagId(tagId);
        List<Article> articles = new ArrayList<>();
        for (Long a : articleId) {
            Article article = articleMapper.findArticleById(a);
            List<Tag> tags = new ArrayList<>();
            List<Integer> tagIds = tagMapper.findTagIdsByArticleId(article.getArticleId());
            for (Integer tId : tagIds) {
                tags.add(tagMapper.findTagById(tId));
            }
            article.setTags(tags);
            articles.add(article);
        }
        return articles;
    }

    @Override
    public List<Article> findArticlesByTagName(String tagName) {
        return articleMapper.findArticlesByTagName(tagName);
    }

    @Override
    // @Cacheable(value = "article", key = "#articleId")
    public Article findArticleById(Long articleId) {
        Article article = articleMapper.findArticleById(articleId);
        List<Tag> tags = findArticleTagsById(articleId);
        article.setTags(tags);
        return article;
    }

    @Override
    public Article findLast(Long articleId) {
        return articleMapper.findLastArticleByCurrentId(articleId);
    }

    @Override
    public Article findNext(Long articleId) {
        return articleMapper.findNextArticleByCurrentId(articleId);
    }

    @Override
    public List<Article> findArticlesByCategoryName(String category) {
        List<Article> articles = articleMapper.findArticlesByCategoryName(category);
        for (Article article : articles) {
            List<Tag> tags = findArticleTagsById(article.getArticleId());
            article.setTags(tags);
            article.setCName(category);
        }

        return articles;
    }

    @Override
    public void hideBlog(Long articleId) {
        articleMapper.hideBlog(articleId);
    }

    @Override
    public void showBlog(Long articleId) {
        articleMapper.showBlog(articleId);
    }

    @Override
    public void deleteBlogById(Long articleId) {
        articleMapper.deleteArticleById(articleId);
        articleMapper.deleteArticleTagsByArticleId(articleId);
        articleMapper.deleteArticleCategoryByArticleId(articleId);
    }

    @Override
    public void addArticle(Article article) {
        articleMapper.addArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleMapper.updateArticle(article);
    }


    private List<Tag> findArticleTagsById(Long articleId) {
        List<Integer> tagIds = tagMapper.findTagIdsByArticleId(articleId);
        List<Tag> tags = new ArrayList<>();
        for (Integer tagId : tagIds)
            tags.add(tagMapper.findTagById(tagId));
        return tags;
    }



}


