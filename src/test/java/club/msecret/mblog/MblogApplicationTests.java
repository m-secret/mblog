package club.msecret.mblog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Archive;
import club.msecret.mblog.entity.Article;
import club.msecret.mblog.mapper.ArchiveMapper;
import club.msecret.mblog.service.ArchiveService;
import club.msecret.mblog.service.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MblogApplicationTests {

    @Resource
    private ArticleService articleService;

    @Resource
    private ArchiveService archiveService;


    @Test
    public void test() {
        /*List<Archive> ay = archiveMapper.findAllYears();
        System.out.println(ay);
        List<Article> a = archiveMapper.findArticlesByYear(2019);
        System.out.println(a);*/
        System.out.println(archiveService.findAll());

    }
}
