package exercise;

// BEGIN
public final class ReversedSequence implements CharSequence {
    private String reversed;
    private int count;
    private char[] arrChar;
    public ReversedSequence(String textIn) {
        char[] arrCharSequence = textIn.toCharArray();
        char[] resultChar = new char[arrCharSequence.length];
        int counter = 0;
        for (int j = (arrCharSequence.length - 1); j >= 0; j--) {
            resultChar[counter] = arrCharSequence[j];
            counter++;
        }
        this.reversed = new String(resultChar);
        this.count = counter;
        this.arrChar = resultChar;
    }
    @Override
    public int length() {
        return this.count;
    }

    @Override
    public char charAt(int index) {
        return this.arrChar[index];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        int lengthSequence = end - start;
        if (lengthSequence < 1) {
            return null;
        }
        char[] charSubSequence = new char[lengthSequence];
        for (int i = 0; i < lengthSequence; i++) {
            charSubSequence[i] = this.arrChar[start + i];
        }
        CharSequence result = new String(charSubSequence);
        return result;
    }
    @Override
    public String toString() {
        return this.reversed;
    }
}
// END
