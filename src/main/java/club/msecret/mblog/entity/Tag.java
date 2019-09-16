package club.msecret.mblog.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class Tag implements Serializable {
    private Integer tagId;
    private String tagName;
    private int total;
}
