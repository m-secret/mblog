package club.msecret.mblog.service;

import java.util.List;
import java.util.Map;

import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.entity.TagOfArticle;

public interface TagService {

    List<Tag> findAllTags();

    void updateTagNameById(Tag tag);

    void deleteTag(int tagId);

    void addTag(String tagName);

    void addTagsOfArticle(List<TagOfArticle> toas);

    int findTagAmountById(Integer tagId);

    Map<Integer, Integer> countDisplayArticleOfTag();

    void deleteTagOfArticleByAid(Long articleId);
}
