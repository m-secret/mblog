package club.msecret.mblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Article;
import club.msecret.mblog.entity.Category;
import club.msecret.mblog.service.ArticleService;
import club.msecret.mblog.service.CategoryService;

@Controller
public class CategoryController {

    @Resource
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;


    @RequestMapping("/categories")
    public ModelAndView category(String category) {
        ModelAndView mav = new ModelAndView("category");
        List<Category> categories = categoryService.findAllCategories();
        Map<Integer, Integer> map = categoryService.countDisplayArticleOfCategory();
        for (Category c : categories) {
            c.setTotal(map.get(c.getCid()) != null ? map.get(c.getCid()) : 0);
        }

        String currentCategory = "还没有添加分类";
        if (category != null) {
            currentCategory = category;
        }else {
            if (categories.size() > 0) {
                currentCategory = categories.get(0).getCName();
            }
        }
        List<Article> articles = articleService.findArticlesByCategoryName(category != null ? category: categories.get(0).getCName());
        articles.removeIf(article1 -> article1.getStatus() != 1);

        mav.addObject("articles", articles);
        mav.addObject("currentCategory", currentCategory);
        mav.addObject("categories", categories);
        return mav;

    }
}
