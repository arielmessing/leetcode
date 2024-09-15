package fruit_into_baskets_904;

class Solution {
    public int totalFruit(int[] fruits) {
        int[] fruitTypes = new int[] { -1, -1 };

        int prevTypeCount = 0;

        int currentCount = 0;
        int max = 0;

        for (int currentType : fruits) {

            if (currentType == fruitTypes[1] || currentType == fruitTypes[0]) {
                currentCount++;
            
            } else {
                currentCount = prevTypeCount + 1;
            }

            if (currentType == fruitTypes[1]) {
                prevTypeCount++;

            } else {
                prevTypeCount = 1;

                fruitTypes[0] = fruitTypes[1];
                fruitTypes[1] = currentType;                
            }

            max = Math.max(max, currentCount);
        }

        return max;
    }
}