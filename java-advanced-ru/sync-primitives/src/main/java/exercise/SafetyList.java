package exercise;

class SafetyList {
    // BEGIN
    private int[] numbers;

    public SafetyList() {
    }

    public synchronized void add(int number) {
        if (numbers == null) {
            int[] newArr = new int[1];
            newArr[0] = number;
            this.numbers = newArr;
        } else {
            int sizeNumbers = getSize();
            int [] newArr = new int[sizeNumbers + 1];
            System.arraycopy(numbers, 0, newArr, 0, sizeNumbers);
            newArr[sizeNumbers] = number;
            this.numbers = newArr;
        }
    }

    public int get(int index) {
        if ((index >= 0) && (index < numbers.length)) {
            return numbers[index];
        }
        return 0;
    }

    public int getSize() {
        return numbers.length;
    }
    // END
}
