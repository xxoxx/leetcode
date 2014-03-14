import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by szhu on 2014-03-05.
 */
public class LRUCache {
    private HashMap<Integer, Integer> map;
    private ArrayList<Integer> keyArray;
    private int size;

    public static void main(String []args){
        LRUCache lruCache = new LRUCache(2);
        lruCache.get(2);
        lruCache.set(2,6);
        lruCache.get(1);
        lruCache.set(1,5);
        lruCache.set(1,2);
        lruCache.get(1);
        lruCache.get(2);
    }

    public LRUCache(int capacity){
        this.size = capacity;
        this.map = new HashMap<Integer, Integer>();
        this.keyArray = new ArrayList<Integer>();
    }

    private void removeFromArray(int key){
        int length = this.keyArray.size();
        for(int i = 0; i < length; i++){
            if(keyArray.get(i)== key){
                keyArray.remove(i);
                break;
            }
        }
    }
    public int get(int key) {
        if(map.containsKey(key)){
            removeFromArray(key);
            keyArray.add(key);
            return map.get(key);
        }
        else
            return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)){
            map.put(key, value);
            removeFromArray(key);
            keyArray.add(key);
            return;
        }
        if(this.size > 0){
            map.put(key, value);
            keyArray.add(key);
            this.size--;
        }else{
            map.remove(keyArray.get(0));
            map.put(key, value);
            keyArray.remove(0);
            keyArray.add(key);
        }

    }
}
