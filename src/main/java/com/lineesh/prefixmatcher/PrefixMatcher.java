package com.lineesh.prefixmatcher;

import org.springframework.stereotype.Component;

@Component
public class PrefixMatcher {
    private final CharacterNode root;

    public PrefixMatcher() {
        this.root = new CharacterNode();
    }

    public String fetchLongestPrefix(String inputString) {
        String longestPrefix = "";
        CharacterNode current = root;
        for (int i = 0; i < inputString.length(); i++) {
            current = current.next(inputString.charAt(i));
            if (current == null) {
                break;
            }
            if (current.isEnd()) {
                longestPrefix = inputString.substring(0, i + 1);
            }
        }
        return longestPrefix;
    }

    public void insert(String prefix) {
        CharacterNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (current.getCharacterNodes().get(prefix.charAt(i)) == null) {
                current.getCharacterNodes().put(prefix.charAt(i), new CharacterNode());
            }
            current = current.next(prefix.charAt(i));
        }
        current.setEnd(true);
    }
}
