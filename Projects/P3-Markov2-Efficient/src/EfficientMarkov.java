import java.util.*;

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;
	
	public EfficientMarkov(){
		this(3);
	}

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	@Override
	public void setTraining(String text) {
		super.setTraining(text);
		myMap.clear();

		for (int i = 0; i <= myText.length()-myOrder; i++) {
			String sub = myText.substring(i, i + myOrder);

			// Create ArrayList at key if it doesn't exist
			if (! myMap.containsKey(sub)) {
				myMap.put(sub, new ArrayList<String>());
			}

			// Add next string to key's value
			if (i == myText.length()-myOrder) {
				myMap.get(sub).add(PSEUDO_EOS);
			}
			else {
				myMap.get(sub).add(myText.substring(i+myOrder, i+myOrder+1));
			}
		}
	}

	@Override
	public ArrayList<String> getFollows(String key) {
		if (! myMap.containsKey(key)) {
			throw new NoSuchElementException(key+" not in map");
		}
		return myMap.get(key);
	}

}
