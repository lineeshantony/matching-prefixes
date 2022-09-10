package com.lineesh.controller;

import com.lineesh.prefixmatcher.PrefixMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrefixMatcherController {

    @Autowired
    private PrefixMatcher prefixMatcher;

    @GetMapping("/prefixMatcher/{inputString}")
    public ResponseEntity<String> getMatchingPrefix(@PathVariable("inputString") String inputString) {
        String prefix = prefixMatcher.fetchLongestPrefix(inputString);
        return "".equals(prefix)
                ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
                : new ResponseEntity<>(prefix, HttpStatus.OK);
    }
}
