package club.msecret.mblog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import club.msecret.mblog.service.LoginService;

@Controller
public class AdminLoginController {

    @Resource
    private LoginService loginService;

    @RequestMapping("login")
    public ModelAndView login(HttpSession httpSession) {
        String msg = (String) httpSession.getAttribute("msg");
        ModelAndView mav = new ModelAndView("/admin/login");
        if (msg != null) {
            mav.addObject("msg", msg);
        }
        return mav;
    }

    @RequestMapping("/admin/index")
    public ModelAndView index(HttpSession httpSession) {
        String uname = (String) httpSession.getAttribute("uname");
        ModelAndView mav = new ModelAndView("/admin/index");
        mav.addObject("uname", uname);
        return mav;
    }

    @PostMapping("checkLogin")
    public ModelAndView checkLogin(@RequestParam("userId") Long tel, String password, HttpSession httpSession) {
        ModelAndView mav = new ModelAndView();
        Map result = loginService.loginCheck(tel);
        if (result.get("code").equals("-1")) {
            httpSession.setAttribute("msg", result.get("message"));
            mav.setViewName("redirect:/login");
        }
        if (result.get("code").equals("0")) {
            if (password.equals(result.get("message"))) {
                httpSession.setAttribute("uname", result.get("uname"));
                httpSession.setAttribute("loginStatus","login");
                httpSession.removeAttribute("msg");
                httpSession.setMaxInactiveInterval(24*60*60);
                mav.setViewName("redirect:/admin/index");
            } else {
                httpSession.setAttribute("msg", "密码错误");
                mav.setViewName("redirect:/login");
            }
        }
        return mav;
    }

    @RequestMapping("/exit")
    public ModelAndView exit(HttpSession httpSession) {
        httpSession.removeAttribute("loginStatus");
        return new ModelAndView("redirect:/login");
    }



}
