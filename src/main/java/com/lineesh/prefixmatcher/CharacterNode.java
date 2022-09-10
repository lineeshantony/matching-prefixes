package com.lineesh.prefixmatcher;

import java.util.HashMap;
import java.util.Map;

public class CharacterNode {

    private boolean isEnd;
    private final Map<Character, CharacterNode> characterNodes = new HashMap<>();

    public CharacterNode next(char c) {
        return characterNodes.get(c);
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd(boolean end) {
        isEnd = end;
    }

    public Map<Character, CharacterNode> getCharacterNodes() {
        return characterNodes;
    }

}
