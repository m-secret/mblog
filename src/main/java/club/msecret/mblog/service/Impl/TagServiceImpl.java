package club.msecret.mblog.service.Impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import club.msecret.mblog.entity.Category;
import club.msecret.mblog.entity.Tag;
import club.msecret.mblog.entity.TagOfArticle;
import club.msecret.mblog.mapper.TagMapper;
import club.msecret.mblog.service.TagService;

@Service
public class TagServiceImpl implements TagService {

    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> findAllTags() {
        return tagMapper.findAllTags();
    }

    @Override
    public void updateTagNameById(Tag tag) {
        tagMapper.updateTagNameById(tag);

    }

    @Override
    public void deleteTag(int tagId) {
        tagMapper.deleteTagById(tagId);
        tagMapper.deteleTagOfArticleByTagId(tagId);
    }

    @Override
    public void addTag(String tagName) {
        tagMapper.addTag(tagName);
    }

    @Override
    public void addTagsOfArticle(List<TagOfArticle> toas) {
        for (TagOfArticle t : toas) {
            tagMapper.addTagOfArticle(t);
        }
    }

    @Override
    public int findTagAmountById(Integer tagId) {
        return tagMapper.findTagAmountById(tagId);
    }

    @Override
    public Map<Integer, Integer> countDisplayArticleOfTag() {
        List<Tag> tags = tagMapper.countDisplayArticleOfTag();
        Map<Integer, Integer> result = new HashMap<>();
        for (Tag tag : tags) {
            result.put(tag.getTagId(), tag.getTotal());
        }
        return result;
    }

    @Override
    public void deleteTagOfArticleByAid(Long articleId) {
        tagMapper.deleteTagOfArticleBtAid(articleId);
    }

}
