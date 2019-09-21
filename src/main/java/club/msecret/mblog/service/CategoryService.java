package club.msecret.mblog.service;

import java.util.List;
import java.util.Map;

import club.msecret.mblog.entity.Category;
import club.msecret.mblog.entity.CategoryOfArticle;

public interface CategoryService {
    List<Category> findAllCategories();

    Map<Integer, Integer> countDisplayArticleOfCategory();

    int findCategoryAmountByCid(int cid);

    void updateCategoryNameById(Category category);

    void deleteCategory(int cid);

    void addCategory(String cName);

    void addCategoryOfArticle(CategoryOfArticle cov);

    Category findArticleCategoryByArticleId(Long articleId);

    void updateCategoryOfArticleByAid(CategoryOfArticle cov);
}
