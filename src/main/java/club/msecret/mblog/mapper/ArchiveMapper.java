package club.msecret.mblog.mapper;

import java.util.List;

import club.msecret.mblog.entity.Archive;
import club.msecret.mblog.entity.Article;

public interface ArchiveMapper {

    List<Archive> findAllYears();

    List<Article> findArticlesByYear(int year);


}
