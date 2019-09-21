package club.msecret.mblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Article;
import club.msecret.mblog.entity.Category;
import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.service.ArticleService;
import club.msecret.mblog.service.CategoryService;
import club.msecret.mblog.service.TagService;

@Controller
public class BlogController {

    @Resource
    private ArticleService articleService;

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/")
    public ModelAndView BlogIndex() {
        ModelAndView mav = new ModelAndView("index");
        List<Article> articles = articleService.findAll();
        articles.removeIf(article1 -> article1.getStatus() != 1);
        List<Category> categories = categoryService.findAllCategories();
     /*   for (Category ca: categories) {
            ca.setTotal(categoryService.findCategoryAmountByCid(ca.getCid()));
        }*/
        if (categories.size() > 6) {
            for (int i = categories.size(); i > 6; i--) {
                categories.remove(i - 1);
            }
        }
        mav.addObject("articles", articles);
        mav.addObject("categories", categories);
        mav.addObject("categoryPosition", 0);
        return mav;
    }




    @RequestMapping("/blog/{id}")
    public ModelAndView articleDetail(@PathVariable("id") Long articleId) {
        ModelAndView mav = new ModelAndView("article");
        Article article = articleService.findArticleById(articleId);
        mav.addObject("article", article);
        if (article == null)
            return mav;
        Article last = articleService.findLast(articleId);
        Article next = articleService.findNext(articleId);
        mav.addObject("last", last);
        mav.addObject("next", next);
        return mav;
    }







}
