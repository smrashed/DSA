import java.util.ArrayList;
import java.util.List;

class MyHashMap {

    private int maxBucket = 10001;
    private List<List<int[]>> bucket;
    
    public MyHashMap() {
        bucket = new ArrayList<>(maxBucket);
        for(int i=0;i<maxBucket;i++){
             bucket.add(new ArrayList<>());
        }
        
    }
    
    public void put(int key, int value) {
         int idx = key%maxBucket;
         List<int[]> keyValuePairList = bucket.get(idx);
         for (int[] pair : keyValuePairList) {
           if (pair[0] == key) {
             pair[1] = value;
             return;
           }
         } 
        keyValuePairList.add(new int[]{key,value});
    }
    
    public int get(int key) {
        int idx = key % maxBucket;
        List<int[]> keyValuePairList = bucket.get(idx);
        for (int[] pair : keyValuePairList) {
          if (pair[0] == key) {
            return pair[1];
          }
        }
        return -1;
    }
    
    public void remove(int key) {
        int idx = key % maxBucket;
        List<int[]> keyValuePairList = bucket.get(idx);
        for (int[] pair : keyValuePairList) {
          if (pair[0] == key) {
            pair[1] = -1;
            return;
          }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */