package com.lineesh.prefixmatcher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class PrefixInserter {

    @Value("${prefix.file}")
    private String prefixFile;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private PrefixMatcher prefixMatcher;

    public void insertPrefix() {
        System.out.println("Data preprocessing in progress.");
        resourceLoader.getResource(prefixFile);
        Scanner sc = new Scanner(this.getClass().getClassLoader().getResourceAsStream(prefixFile));
        while (sc.hasNextLine()) {
            prefixMatcher.insert(sc.nextLine());
        }
        sc.close();
        System.out.println("Data preprocessing complete.");
    }
}
