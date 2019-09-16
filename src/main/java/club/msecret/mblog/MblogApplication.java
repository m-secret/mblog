package club.msecret.mblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("club.msecret.mblog.mapper")
//@EnableCaching
public class MblogApplication {

    public static void main(String[] args) {

        SpringApplication.run(MblogApplication.class, args);

    }

}
