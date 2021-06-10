import java.util.Arrays;

/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        return linearSearch(houses, heaters);
        // Arrays.sort(houses);
        // Arrays.sort(heaters);

        // int l = houses[0];
        // int r = houses[houses.length - 1];

        // int ans = r;
        // int count = 0;
        // while (l < r && count < 20) {
        //     int mid = l + (r - l) / 2;
        //     // System.out.println("L: " + l + " R: " + r + " Mid: " + mid);
        //     if (isValidRadius(mid, houses, heaters)) {
        //         ans = Math.min(ans, mid);
        //         r = mid;
        //     } else {
        //         l = mid;
        //     }
        //     count++;
        // }

        // // [1,5]\n[2]
        // return ans;
    }

    // private boolean isValidRadius(int radius, int[] houses, int[] heaters) {
    //     for (int house: houses) {
    //         int start = house - radius > 0 ? house - radius : 0;
    //         int end = house + radius;
    //         boolean found = false;
    //         for (int heater : heaters) {
    //             if (heater >= start && heater <= end) {
    //                 found = true;
    //                 break;
    //             }
    //         }

    //         if (!found) {
    //             return false;
    //         }
    //     }

    //     return true;
    // }

    private int linearSearch(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int preHeater = heaters[0];
        int i = 0;
        int ans = 0;
        for (int house : houses) {
            for (; i < heaters.length && heaters[i] < house; i++) {
                preHeater = heaters[i];
            }

            int afterHeater = preHeater;
            if (i < heaters.length) {
                afterHeater = heaters[i];
            }

            int distToPre = Math.abs(house - preHeater);
            int distToAfter = Math.abs(afterHeater - house);
            int radius = Math.min(distToPre, distToAfter);
            ans = Math.max(ans, radius);
        }

        return ans;
    }
}
// @lc code=end

