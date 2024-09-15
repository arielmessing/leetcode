package insert_delete_random_boof1_380;

import java.util.*;

class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;

        list.add(val);
        map.put(val, list.size() - 1);

        return true;
    }
    
    public boolean remove(int val) {
        if (! map.containsKey(val)) return false;

        int index = map.get(val);

        int lastVal = list.getLast();
        list.set(index, lastVal);
        map.put(lastVal, index);

        list.removeLast();
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */