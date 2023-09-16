package hu.progmatic.gallows_0916.service;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GallowsService {

    //List<Word> words = new ArrayList<>();

    private String result = "kecske";
    private char[] wordsToArray;
    private Set<Character> usedCharacters;
    private int counter = 10;

    public GallowsService() {
        this.wordsToArray = new char[result.length()];
        this.usedCharacters = new HashSet<>();
        Arrays.fill(wordsToArray, '_');
    }

    public char[] getWordsToArray() {
        return wordsToArray;
    }

    public void setWordsToArray(char[] wordsToArray) {
        this.wordsToArray = wordsToArray;
    }

    public Set<Character> getUsedCharacters() {
        return usedCharacters;
    }

    public void setUsedCharacters(Set<Character> usedCharacters) {
        this.usedCharacters = usedCharacters;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }


    public boolean isContain(char character) {
        for (int i = 0; i < result.length(); i++) {
            if (character == result.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public char[] charFind(char character) {
        if (isContain(character)) {
            for (int i = 0; i < result.length(); i++) {
                if (character == result.charAt(i)) {
                    wordsToArray[i] = character;
                }
            }
        } else {
            usedCharacters.add(character);
            counter--;
        }
        return wordsToArray;
    }

    public boolean win() {
        for (int i = 0; i < this.wordsToArray.length; i++) {
            if (this.wordsToArray[i] != this.result.charAt(i)) {
                return false;
            }
        }
        return true;
    }


}
