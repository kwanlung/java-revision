public class hashMap {
    private static class Entry{
        final int key;
        int value;
        Entry next;
        Entry(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private final int size = 1000;
    private Entry[] table = new Entry[size];

    public void put(int key, int value){
        int index = key % size;
        Entry entry = table[index];

        if (entry == null){

        }
    }
}
