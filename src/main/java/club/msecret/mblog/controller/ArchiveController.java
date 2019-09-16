package club.msecret.mblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Archive;
import club.msecret.mblog.service.ArchiveService;

@Controller
public class ArchiveController {

    @Resource
    private ArchiveService archiveService;

    @GetMapping("/archive")
    public ModelAndView archive() {
       ModelAndView mav = new ModelAndView("archive");
        List<Archive> archives = archiveService.findAll();
        mav.addObject("archives", archives);
        return mav;
    }
}
