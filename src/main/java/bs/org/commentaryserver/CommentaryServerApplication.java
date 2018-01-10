package bs.org.commentaryserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("bs.org.commentaryserver.db.mapper")
public class CommentaryServerApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(CommentaryServerApplication.class, args);
    }
}
