package com.lineesh.controller;

import com.lineesh.prefixmatcher.PrefixInserter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PrefixMatcherControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private PrefixInserter prefixInserter;

    @BeforeEach
    public void setup() {
        prefixInserter.insertPrefix();
    }

    @Test
    public void testGetMatchingPrefixWhenPrefixIsAbsent() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prefixMatcher/{inputString}", "Test string")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

    }

    @Test
    public void testGetMatchingPrefixWhenPrefixIsPresent() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prefixMatcher/{inputString}", "2y3fKTS string")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().string(containsString("2y3fKTS")))
                .andExpect(status().isOk());

    }

    @Test
    public void testGetMatchingPrefixWhenInputStringIsEmpty() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/prefixMatcher/{inputString}", "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());

    }
}