package org.bs.commentaryserver;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author bs
 */
@SpringBootApplication
@MapperScan("org.bs.commentaryserver.db.mapper")
public class CommentaryServerApplication
{
    private static Logger logger = LoggerFactory.getLogger(CommentaryServerApplication.class);

    public static void main(String[] args)
    {
        SpringApplication.run(CommentaryServerApplication.class, args);
        logger.warn("---------------------- system started! ----------------------");
    }
}
