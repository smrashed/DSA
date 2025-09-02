package DSA;

import java.util.ArrayList;
import java.util.List;

class MyHashSet {

    private int maxBucket = 10001;
    private List<List<int[]>> bucket;

    public MyHashSet() {
        bucket = new ArrayList<>(maxBucket);
        for (int i = 0; i < maxBucket; i++) {
            bucket.add(new ArrayList<>());
        }
    }

    public void add(int key) {
        int idx = key % maxBucket;
        List<int[]> keyList = bucket.get(idx);
        for (int[] key1 : keyList) {
            if (key1[0] == key) {
                if (key1[1] > 0) {
                    return;
                } else if (key1[1] < 0) {
                    key1[1] = 1;
                    return;
                }
            }
        }

        keyList.add(new int[] { key, 1 });

    }

    public void remove(int key) {
        int idx = key % maxBucket;
        List<int[]> keyList = bucket.get(idx);
        for (int[] key1 : keyList) {
            if (key1[0] == key) {
                key1[1] = -1;
                return;
            }
        }

    }

    public boolean contains(int key) {
        int idx = key % maxBucket;
        List<int[]> keyList = bucket.get(idx);
        for (int[] key1 : keyList) {
            if (key1[0] == key) {
                return key1[1] > 0;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        MyHashSet obj = new MyHashSet();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.contains(1)); // return True
        System.out.println(obj.contains(3)); // return False, (not found)
        obj.add(2); // set = [1, 2]
        System.out.println(obj.contains(2)); // return True
        obj.remove(2); // set = [1]
        System.out.println(obj.contains(2)); // return False, (already removed)
        obj.add(2); // set = [1,2]
        System.out.println(obj.contains(2));
    }
}
