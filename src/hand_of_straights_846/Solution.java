package hand_of_straights_846;

import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        TreeMap<Integer, Integer> countByValue = new TreeMap<>();

        for (int card : hand) {
            if (! countByValue.containsKey(card)) {
                countByValue.put(card, 1);
            
            } else {
                countByValue.put(card, countByValue.get(card) + 1);
            }
        }

        while (! countByValue.isEmpty()) {
            int minCard = countByValue.firstKey();
   
            for (int card = minCard; card < minCard + groupSize; card++) {

                if (! countByValue.containsKey(card)) return false;
                
                if (countByValue.get(card) > 1) {
                    countByValue.put(card, countByValue.get(card) - 1);

                } else {
                    countByValue.remove(card);
                }
            }
        }

        return true;
    }
}