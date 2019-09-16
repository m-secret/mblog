package club.msecret.mblog.entity;

import java.util.List;

import lombok.Data;

@Data
public class Archive {
    private int year;
    private List<Article> articles;
    private int total;
}
