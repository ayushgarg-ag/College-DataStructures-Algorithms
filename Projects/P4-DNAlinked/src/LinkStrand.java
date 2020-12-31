// Authors: Zibran Vastani & Ayush Garg
public class LinkStrand implements IDnaStrand {
    private class Node{
        String info;
        Node next;
        public Node(String s){
            info = s;
            next = null;
        }
    }
    private Node myFirst,myLast;
    private long mySize;
    private int myAppends;

    private int myIndex = 0;
    private int myLocalIndex = 0;
    private Node myCurrent;

    public LinkStrand() {
        this("");
    }

    public LinkStrand(String str) {
        initialize(str);
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        myFirst = new Node(source);
        myLast = myFirst;
        myCurrent = myFirst;
        mySize = source.length();
        myAppends = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        myLast.next = new Node(dna);;
        myLast = myLast.next;
        mySize += dna.length();
        myAppends++;
        return this;
    }

    @Override
    public IDnaStrand reverse() {
        LinkStrand reversed = new LinkStrand();
        Node temp = myFirst;
        Node tempFirst = null;

        while (temp != null) {
            StringBuilder rev = new StringBuilder(temp.info);
            rev.reverse();
            String str = rev.toString();

            Node toAdd = new Node(str);
            toAdd.next = tempFirst;
            tempFirst = toAdd;

            temp = temp.next;
        }

        while (tempFirst != null) {
            reversed.append(tempFirst.info);
            tempFirst = tempFirst.next;
        }

        return reversed;
    }

    @Override
    public int getAppendCount() {
        return myAppends;
    }

    @Override
    public char charAt(int index) {
        if (index >= mySize || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (myIndex > index) {
            myCurrent = myFirst;
            myIndex = 0;
            myLocalIndex = 0;
        }
        while (myIndex != index) {
            myIndex++;
            myLocalIndex++;
            if (myLocalIndex >= myCurrent.info.length()) {
                myLocalIndex = 0;
                myCurrent = myCurrent.next;
            }
        }
        return myCurrent.info.charAt(myLocalIndex);
    }

    public String toString() {
        Node temp = myFirst;
        StringBuilder ret = new StringBuilder();
        while (temp != null) {
            ret.append(temp.info);
            temp = temp.next;
        }
        return ret.toString();
    }



}

