package club.msecret.mblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MeController {

    @GetMapping("/me")
    public ModelAndView me() {
        ModelAndView mav = new ModelAndView("me");
        return mav;
    }
}
