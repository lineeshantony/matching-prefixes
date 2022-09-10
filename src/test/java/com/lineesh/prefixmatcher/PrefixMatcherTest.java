package com.lineesh.prefixmatcher;

import org.junit.Assert;
import org.junit.Test;

public class PrefixMatcherTest {

    @Test
    public void testQueryWhenNoPrefixesArePresent() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        Assert.assertEquals("", prefixMatcher.fetchLongestPrefix("Test string"));
    }

    @Test
    public void testQueryWhenInputStringDoesNotMatchAnyPrefix() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        prefixMatcher.insert("abc123");
        prefixMatcher.insert("_Test string");
        Assert.assertEquals("", prefixMatcher.fetchLongestPrefix("Test string"));
    }

    @Test
    public void testQueryWhenInputStringMatchesOnePrefix() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        prefixMatcher.insert("abc123");
        prefixMatcher.insert("Test");
        Assert.assertEquals("Test", prefixMatcher.fetchLongestPrefix("Test string"));
    }

    @Test
    public void testQueryWhenInputStringMatchesMultiplePrefixesAndReturnsLongest() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        prefixMatcher.insert("abc123");
        prefixMatcher.insert("Test");
        prefixMatcher.insert("Test st");
        Assert.assertEquals("Test st", prefixMatcher.fetchLongestPrefix("Test string"));
    }

    @Test
    public void testQueryWhenInputStringMatchesStartOfPrefixButPrefixIsLonger() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        prefixMatcher.insert("abc123");
        prefixMatcher.insert("Test string 1");
        Assert.assertEquals("", prefixMatcher.fetchLongestPrefix("Test string"));
    }

    @Test
    public void testQueryWhenInsertingMultiplePrefixOfSameValue() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        prefixMatcher.insert("abc123");
        prefixMatcher.insert("Test st");
        prefixMatcher.insert("Test st");
        Assert.assertEquals("Test st", prefixMatcher.fetchLongestPrefix("Test string"));
    }

    @Test
    public void testQueryWhenInsertingMultiplePrefixWithSimilarStart() {
        PrefixMatcher prefixMatcher = new PrefixMatcher();
        prefixMatcher.insert("abc123");
        prefixMatcher.insert("a1bc123");
        prefixMatcher.insert("ab2c123");
        prefixMatcher.insert("abc3123");
        prefixMatcher.insert("abc1123");
        prefixMatcher.insert("abc1223");
        prefixMatcher.insert("abc1233");
        Assert.assertEquals("abc123", prefixMatcher.fetchLongestPrefix("abc123 abc123"));
        Assert.assertEquals("a1bc123", prefixMatcher.fetchLongestPrefix("a1bc123 abc123"));
        Assert.assertEquals("ab2c123", prefixMatcher.fetchLongestPrefix("ab2c123 abc123"));
        Assert.assertEquals("abc3123", prefixMatcher.fetchLongestPrefix("abc3123 abc123"));
        Assert.assertEquals("abc1123", prefixMatcher.fetchLongestPrefix("abc1123 abc123"));
        Assert.assertEquals("abc1223", prefixMatcher.fetchLongestPrefix("abc1223 abc123"));
        Assert.assertEquals("abc1233", prefixMatcher.fetchLongestPrefix("abc1233 abc123"));
    }

}