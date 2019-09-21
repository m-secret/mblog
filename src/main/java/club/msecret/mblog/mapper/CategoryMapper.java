package club.msecret.mblog.mapper;

import java.util.List;

import club.msecret.mblog.entity.Category;
import club.msecret.mblog.entity.CategoryOfArticle;

public interface CategoryMapper {

    List<Category> findAllCategories();

    List<Category> countDisplayArticleOfCategory();

    Category findCategoryById(Integer cid);

    int findCategoryAmountByCid(int cid);

    void updateCategoryNameById(Category category);

    void deleteCategoryById(int cid);

    void deteleCategoryOfArticleByCid(int cid);

    void addCategory(String cName);

    void addCategoryOfArticle(CategoryOfArticle cov);

    Category findArticleCategoryByArticleId(Long articleId);

    void updateCategoryOfArticleByAid(CategoryOfArticle cov);
}
