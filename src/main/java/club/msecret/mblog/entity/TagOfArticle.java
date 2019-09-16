package club.msecret.mblog.entity;

import lombok.Data;

@Data
public class TagOfArticle {
    private int tagId;
    private Long articleId;

    public TagOfArticle(int tagId, Long articleId) {
        this.tagId = tagId;
        this.articleId = articleId;
    }

    public TagOfArticle() {
    }
}
