import java.util.Arrays;

/*
 * @lc app=leetcode id=475 lang=java
 *
 * [475] Heaters
 * [binary-search][2pointers]
 */

// @lc code=start
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        return linearSearch(houses, heaters);
    }

    public int binarySearch(int[] houses, int[] heaters) {
        // key thinking: binary-search for heater's warm radius
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int rMin = 0;
        int rMax = Math.max(houses[houses.length - 1], heaters[heaters.length - 1]); // 重要：区间取大不取小！
        
        int ans = 0;
        while (rMin <= rMax) {
            int mid = rMin + (rMax - rMin) / 2;
            if (possible(houses, heaters, mid)) {
                ans = mid;
                rMax = mid - 1;
            } else {
                rMin = mid + 1;
            }
        }

        return ans;
    }

    private boolean possible(int[] houses, int[] heaters, int len) {
        int m = houses.length;
        int n = heaters.length;
        int index = 0;

        // two-pointers tc O(m + n)
        for(int i = 0 ; i < n ; i++){
            //针对每个heaters计算
            long l = heaters[i]-len , r = heaters[i]+len;
            //计算能否完全覆盖房屋
            while(index < m && (long)houses[index] >= l && (long)houses[index] <= r){
                index++;
            }
            // 所有房屋都覆盖完毕了
            if(index == m) return true;
        }
        return false;

    }

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

