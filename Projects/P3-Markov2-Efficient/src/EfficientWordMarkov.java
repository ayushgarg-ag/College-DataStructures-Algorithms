import java.util.*;

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;

    public EfficientWordMarkov(){
        super();
    }

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    @Override
    public void setTraining(String text) {
        super.setTraining(text);
        myMap.clear();

        for (int i = 0; i <= myWords.length - myOrder; i++) {
            WordGram kGram = new WordGram(myWords, i, myOrder);

            // Create ArrayList at key if it doesn't exist
            if (! myMap.containsKey(kGram)) {
                myMap.put(kGram, new ArrayList<String>());
            }

            // Add next string to key's value
            if (i == myWords.length - myOrder) {
                myMap.get(kGram).add(PSEUDO_EOS);
            }
            else {
                myMap.get(kGram).add(myWords[i+myOrder]);
            }
        }
    }

    @Override
    public ArrayList<String> getFollows(WordGram kGram) {
        if (! myMap.containsKey(kGram)) {
            throw new NoSuchElementException(kGram+" not in map");
        }
        return myMap.get(kGram);
    }
}
