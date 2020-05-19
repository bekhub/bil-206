package model;

import util.SetMap;

public class Model {

    private String text;
    private final SetMap<String> words;

    public Model() {
        words = new SetMap<>();
    }

    public void setText(String text) {
        this.text = text;
    }

    private void handleText() {
        String tempText = text.replaceAll("[.,<>/:;{}?!\"@#$%^&*()=\n]", " ");
        String[] textWords = tempText.split(" ");
        words.clear();
        for (var word: textWords) {
            if(word.isEmpty()) continue;
            words.put(word.toLowerCase());
        }
    }

    public SetMap<String> getWords() {
        handleText();
        return words;
    }
}
