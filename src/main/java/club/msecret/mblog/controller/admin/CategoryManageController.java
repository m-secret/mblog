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

import club.msecret.mblog.entity.Category;
import club.msecret.mblog.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryManageController {

    @Resource
    private CategoryService categoryService;

    @RequestMapping("/categoryManage")
    public ModelAndView categoryManage() {
        return new ModelAndView("admin/categoryManage");

    }

    @RequestMapping("/getCategory")
    @ResponseBody
    public String getCategory() {
        List<Category> categories = categoryService.findAllCategories();
        for (Category ca: categories) {
            ca.setTotal(categoryService.findCategoryAmountByCid(ca.getCid()));
        }
        Map<String,Object> result = new HashMap<>();
        result.put("code", 0);
        result.put("msg", "");
        result.put("count", categories.size());
        result.put("data", categories);
        return JSON.toJSONString(result);
    }

    @RequestMapping("/changeCategoryName")
    @ResponseBody
    public String changeCategoryName(Category category) {
        categoryService.updateCategoryNameById(category);
        return "success";

    }

    @RequestMapping("/deleteCategory")
    @ResponseBody
    public String deleteCategory(int cid) {
        categoryService.deleteCategory(cid);
        return "success";

    }

    @RequestMapping("/addCategory")
    @ResponseBody
    public String addCategory(String cName) {
        categoryService.addCategory(cName);
        return "success";

    }



}
