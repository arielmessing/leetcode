package min_time_diff_539;

import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {

        // Bucket sort
        boolean[] timesSeen = new boolean[24 * 60];

        for (String timePoint : timePoints) {
            int time = timePointToTime(timePoint);

            if (timesSeen[time]) return 0;

            timesSeen[time] = true;
        }

        int minDifference = Integer.MAX_VALUE;

        int firstTime = -1,
                prevTime = -1,
                currentTime = -1;

        for (int i = 0; i < timesSeen.length; i++) {
            if (timesSeen[i]) {

                if (prevTime == -1) {
                    prevTime = i;
                    firstTime = i;

                } else {
                    currentTime = i;

                    minDifference = Math.min(minDifference, currentTime - prevTime);

                    prevTime = currentTime;
                }
            }
        }

        return Math.min(minDifference, timesSeen.length - currentTime + firstTime);
    }

    private int timePointToTime(String timePoint) {
        String[] split = timePoint.split(":");
        return Integer.parseInt(split[0]) * 60 +
                Integer.parseInt(split[1]);
    }
}