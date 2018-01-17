package org.bs.commentaryserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.bs.commentaryserver.db.mapper")
public class CommentaryServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CommentaryServerApplication.class, args);
    }
}
