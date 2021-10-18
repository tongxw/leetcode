/*
 * @lc app=leetcode id=1366 lang=java
 *
 * [1366] Rank Teams by Votes
 * [stat][hashmap]
 */

// @lc code=start
class Solution {
    public String rankTeams(String[] votes) {
        Map<Character, int[]> counts = new HashMap<>(); // sc O(team)
        for (String vote : votes) { // tc O(voters)
            for (int i=0; i<vote.length(); i++) { //  tc O(teams)
                char c= vote.charAt(i);
                if (counts.get(c) == null) {
                    int[] count = new int[vote.length()];
                    counts.put(c, count);
                }
                
                counts.get(c)[i] += 1;
            }
        }
        
        Character[] team = counts.keySet().toArray(new Character[0]);
        Arrays.sort(team, (t1, t2) -> { // tc O(nlogn) n-> teams
            int i = 0;
            int j = 0;
            int[] count1 = counts.get(t1);
            int[] count2 = counts.get(t2);
            int n = count1.length;
            while (i < n && j < n) {
                if (count1[i] != count2[i])  {
                    return count2[i] - count1[i];
                }
                i++;
                j++;
            }
            
            return t1 - t2;
        });
        
        
        StringBuilder sb = new StringBuilder();
        for (char c : team) {
            sb.append(c);
        }
        
        return sb.toString();
    }
}
// @lc code=end

