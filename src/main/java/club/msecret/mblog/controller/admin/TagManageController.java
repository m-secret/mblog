package club.msecret.mblog.controller.admin;

import com.alibaba.fastjson.JSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.service.TagService;

@Controller
@RequestMapping("/admin")
public class TagManageController {

    @Resource
    private TagService tagService;

    @RequestMapping("/tagManage")
    public ModelAndView tagManage() {
        return new ModelAndView("admin/tagManage");

    }

    @RequestMapping("/getTag")
    @ResponseBody
    public String getTag() {
        List<Tag> tags = tagService.findAllTags();
        for (Tag tag : tags) {
            tag.setTotal(tagService.findTagAmountById(tag.getTagId()));
        }
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", " ");
        result.put("count", tags.size());
        result.put("data", tags);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/changeTagName")
    @ResponseBody
    public String changeTagName(Tag tag) {
        tagService.updateTagNameById(tag);
        return "success";

    }


    @RequestMapping("/deleteTag")
    @ResponseBody
    public String deleteTag(int tagId) {
        tagService.deleteTag(tagId);
        return "success";

    }

    @RequestMapping("/addTag")
    @ResponseBody
    public String addTag(String tagName) {
        tagService.addTag(tagName);
        return "success";

    }

}
