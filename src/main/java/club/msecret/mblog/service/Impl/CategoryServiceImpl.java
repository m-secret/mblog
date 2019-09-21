package club.msecret.mblog.service.Impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Category;
import club.msecret.mblog.entity.CategoryOfArticle;
import club.msecret.mblog.mapper.CategoryMapper;
import club.msecret.mblog.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> findAllCategories() {
        return categoryMapper.findAllCategories();
    }

    @Override
    public Map<Integer, Integer> countDisplayArticleOfCategory() {
        List<Category> categories = categoryMapper.countDisplayArticleOfCategory();
        Map<Integer, Integer> result = new HashMap<>();
        for (Category c : categories) {
            result.put(c.getCid(), c.getTotal());
        }
        return result;
    }

    @Override
    public int findCategoryAmountByCid(int cid) {
        return categoryMapper.findCategoryAmountByCid(cid);
    }

    @Override
    public void updateCategoryNameById(Category category) {
        categoryMapper.updateCategoryNameById(category);

    }

    @Override
    public void deleteCategory(int cid) {
        categoryMapper.deleteCategoryById(cid);
        categoryMapper.deteleCategoryOfArticleByCid(cid);
    }

    @Override
    public void addCategory(String cName) {
        categoryMapper.addCategory(cName);
    }

    @Override
    public void addCategoryOfArticle(CategoryOfArticle cov) {
        categoryMapper.addCategoryOfArticle(cov);
    }

    @Override
    public Category findArticleCategoryByArticleId(Long articleId) {
        return categoryMapper.findArticleCategoryByArticleId(articleId);
    }

    @Override
    public void updateCategoryOfArticleByAid(CategoryOfArticle cov) {
        categoryMapper.updateCategoryOfArticleByAid(cov);
    }
}
