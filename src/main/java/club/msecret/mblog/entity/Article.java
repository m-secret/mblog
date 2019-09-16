package club.msecret.mblog.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class Article implements Serializable {
    private Long articleId;
    private String author;
    private String articleTitle;
    private String outline;
    private String articleContent;
    private List<Tag> tags;
    private String cName;

    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime publishTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    //@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime lastEditTime;

    private String createTime;
    private String editTime;

    public String getCreateTime() {
        if(this.publishTime != null)
            return this.publishTime.toString().replace("T"," ");
        return this.createTime;
    }


    public String getEditTime() {
        if(this.lastEditTime != null)
            return this.lastEditTime.toString().replace("T"," ");
        return this.editTime;
    }


}
