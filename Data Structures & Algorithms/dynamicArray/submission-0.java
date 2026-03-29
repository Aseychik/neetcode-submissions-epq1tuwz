class DynamicArray {
    private int[] array;
    private int last;

    public DynamicArray(int capacity) {
        //if (capacity <= 0) throw new Exeption("wrong capacity");
        array = new int[capacity];
        last = -1;
    }

    public int get(int i) {
        return array[i];
    }

    public void set(int i, int n) {
        array[i] = n;
        last = i > last ? i : last;
    }

    public void pushback(int n) {
        if (last + 1 == array.length) resize();
        last++;
        array[last] = n;
    }

    public int popback() {
        int t = array[last];
        array[last] = 0;

        last--;
        return t;
    }

    public void resize() {
        int[] newA = new int[array.length * 2];
        for (int i = 0; i < array.length; i++)
            newA[i] = array[i];
        
        array = newA;
    }

    public int getSize() {
        return last + 1;
    }

    public int getCapacity() {
        return array.length;
    }
}
