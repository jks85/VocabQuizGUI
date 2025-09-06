package application;

import java.util.HashMap;
import java.util.Random;
import java.util.ArrayList;

/*
 *  Class that creates a dictionary to be used as a vocab list. Implemented using a HashMap.
 *  Using English and Mandarin (pinyin) for testing
 */




public class Dictionary {
    
    private HashMap<String, String> dictionary;
    private ArrayList<String> wordList;


    public Dictionary(){
        this.dictionary = new HashMap<>();
        this.wordList = new ArrayList<>();

        // adding default pair
        this.addPair("I", "Wo");
        
    }

    public String get(String word){
        return this.dictionary.get(word);
    }

    public void addPair(String word, String translation){
        word = word.toLowerCase();
        translation = translation.toLowerCase();
        this.dictionary.put(word, translation);

        
        if (!this.wordList.contains(word)){
            this.wordList.add(word);
        }

    }

    public String getRandWord(){
        Random randomizer = new Random();
        int randIndex = randomizer.nextInt(this.wordList.size());
        return this.wordList.get(randIndex);
    }

    public ArrayList<String> getWordList(){
        return this.wordList;
    }
 
}
