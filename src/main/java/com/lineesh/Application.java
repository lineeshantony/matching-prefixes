package com.lineesh;

import com.lineesh.prefixmatcher.PrefixInserter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
        PrefixInserter prefixInserter = applicationContext.getBean(PrefixInserter.class);
        prefixInserter.insertPrefix();
    }
}
