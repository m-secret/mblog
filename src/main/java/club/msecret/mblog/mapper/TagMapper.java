package club.msecret.mblog.mapper;

import java.util.List;

import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.entity.TagOfArticle;

public interface TagMapper {

    List<Tag> findAllTags();

    List<Integer> findTagIdsByArticleId(Long articleId);

    Tag findTagById(Integer tagId);

    int findTagAmountById(int tagId);

    void updateTagNameById(Tag tag);

    void deleteTagById(int tagId);

    void deteleTagOfArticleByTagId(int tagId);

    void addTag(String tagName);

    void addTagOfArticle(TagOfArticle t);

    List<Tag> countDisplayArticleOfTag();

    void deleteTagOfArticleBtAid(Long articleId);
}
