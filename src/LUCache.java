/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/

import java.util.*;

public class LUCache {
    private HashMap<Object, Integer> hashMap;
    private Queue<HashMap<Object, Integer>> queue;
    private HashMap<Object, Integer> leastMap;
    private TreeMap<Integer, HashSet<Integer>> reverseMap;
    private int size;

    public static void main(String []args){
        LUCache lruCache = new LUCache(2);
        lruCache.set(2,1);
        lruCache.set(3,2);
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        lruCache.set(4,3);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }

    public LUCache(int capacity) {
        this.size = capacity;
        hashMap = new HashMap<Object, Integer>();
        leastMap = new HashMap<Object, Integer>();
        reverseMap = new TreeMap<Integer, HashSet<Integer>>();
    }

    public int get(int key) {
        if(hashMap.containsKey(key)){
            int count = leastMap.get(key);
            reverseMap.get(count).remove(key);
            if(reverseMap.get(count).isEmpty())
                reverseMap.remove(count);
            count++;
            leastMap.put(key, count);
            if(reverseMap.containsKey(count))
                reverseMap.get(count).add(key);
            else{
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(key);
                reverseMap.put(count, set);
            }
            return hashMap.get(key);
        }
        else
            return -1;
    }

    public void set(int key, int value) {
        if(size > 0){
            hashMap.put(key, value);
            leastMap.put(key, 1);
            if(reverseMap.containsKey(1))
                reverseMap.get(1).add(key);
            else{
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(key);
                reverseMap.put(1, set);
            }
            size--;
        }else{
            ArrayList arrayList = new ArrayList();
            //arrayList.addAll(reverseMap.firstEntry().getValue().toArray());
            int key1 = (Integer)reverseMap.firstEntry().getValue().toArray()[reverseMap.firstEntry().getValue().size() - 1];
            //Integer key1 = reverseMap.firstEntry().getValue().iterator().next();
            hashMap.remove(key1);
            leastMap.remove(key1);
            hashMap.put(key, value);
            leastMap.put(key, 1);
            if(reverseMap.containsKey(1))
                reverseMap.get(1).add(key);
            else{
                HashSet<Integer> set = new HashSet<Integer>();
                set.add(key);
                reverseMap.put(1, set);
            }
        }
    }
}
