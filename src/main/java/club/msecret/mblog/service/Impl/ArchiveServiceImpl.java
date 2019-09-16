package club.msecret.mblog.service.Impl;

import org.springframework.stereotype.Service;

import java.util.List;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Archive;
import club.msecret.mblog.entity.Article;
import club.msecret.mblog.mapper.ArchiveMapper;
import club.msecret.mblog.service.ArchiveService;

@Service
public class ArchiveServiceImpl implements ArchiveService {

    @Resource
    private ArchiveMapper archiveMapper;

    @Override
    public List<Archive> findAll() {
        List<Archive> archives = archiveMapper.findAllYears();
        for (Archive archive : archives) {
            int year = archive.getYear();
            List<Article> articles = archiveMapper.findArticlesByYear(year);
            archive.setArticles(articles);
        }
        return archives;
    }
}
