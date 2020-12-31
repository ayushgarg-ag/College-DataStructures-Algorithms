
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Ayush Garg
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram by creating instance variable myWords and copying
	 * size strings from source starting at index start
	 * @param source is array of strings from which copying occurs
	 * @param start starting index in source for strings to be copied
	 * @param size the number of strings copied
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = "";
		myHash = 0;

		// TODO: initialize all instance variable
		int c = 0;
		for(int i = start; i < start + size; i++) {
			myWords[c] = source[i];
			c++;
		}
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Return the order/size of this WordGram
	 * @return int number of words stored in myWords
	 */
	public int length(){
		// TODO: change this
		return myWords.length;
	}


	/**
	 * Return true when the same strings in the same order appear in this and the other WordGram object
	 * @param o the other WordGram object
	 * @return boolean whether the two WordGram objects are equal to each other
	 */
	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		// TODO: Complete this method
		WordGram wg = (WordGram) o;
		if (myWords.length != wg.myWords.length) {
			return false;
		}
		for (int i = 0; i < myWords.length; i++) {
			if (! myWords[i].equals(wg.myWords[i])) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		// TODO: complete this method: assign to myHash as needed
		if (myHash == 0) {
			myHash = this.toString().hashCode();
		}
		return myHash;
	}
	

	/**
	 * Create and return a new WordGram object with k entries (where k is the order of this WordGram) whose first k-1 entries are the same as the last k-1 entries of this WordGram, and whose last entry is the parameter last
	 * @param last is last String of returned WordGram
	 * @return a new WordGram object with k entries and items shifted over
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0, myWords.length);
		// TODO: Complete this method
		for (int i = 1; i < this.length(); i++) {
			wg.myWords[i-1] = myWords[i];
		}
		wg.myWords[myWords.length-1] = last;
		return wg;
	}

	@Override
	public String toString(){
		// TODO: Complete this method, assign to myToString as needed
		if (myToString.equals("")) {
			myToString = String.join(" ", myWords);
		}
		return myToString;
	}
}
