package club.msecret.mblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Article;
import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.service.ArticleService;
import club.msecret.mblog.service.TagService;

@Controller
public class TagController {

    @Resource
    private ArticleService articleService;

    @Resource
    private TagService tagService;

    @RequestMapping("/tags")
    public ModelAndView tags(String tag) {
        ModelAndView mav = new ModelAndView("tags");
        List<Tag> tags = tagService.findAllTags();
        Map<Integer, Integer> map = tagService.countDisplayArticleOfTag();
        for (Tag t : tags) {
            t.setTotal(map.get(t.getTagId()) != null ? map.get(t.getTagId()) : 0);
        }
        String currentTag = "还没有添加分类";
        if (tag != null) {
            currentTag = tag;
        }else {
            if (tags.size() > 0) {
                currentTag = tags.get(0).getTagName();
            }
        }

        List<Article> articles = articleService.findArticlesByTagName(tag != null ? tag : tags.get(0).getTagName());
        mav.addObject("articles", articles);
        mav.addObject("currentTag", currentTag);
        mav.addObject("tags", tags);
        return mav;
    }
}
