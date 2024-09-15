package number_of_provinces_547;

import java.util.HashSet;

class Solution {

    public int findCircleNum(int[][] isConnected) {
        return unionFind(isConnected);
    }

    public int unionFind(int[][] isConnected) {
        int[] parents = new int[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected[i].length; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    union(i, j, parents);
                }
            }
        }

        var uniques = new HashSet<Integer>();
        for (int i = 0; i < parents.length; i++) {
            uniques.add(find(i, parents));
        }

        return uniques.size();
    }

    private void union(int i, int j, int[] parents) {
        int parentI = find(i, parents);
        int parentJ = find(j, parents);
        parents[parentI] = parentJ;
    }

    private int find(int i, int[] parents) {
        if (parents[i] != i) {
            parents[i] = find(parents[i], parents);
        }

        return parents[i];
    }
}
/*
[[1,1,0],
 [1,1,0],
 [0,0,1]]
*/