import java.util.*;

/*
 * @lc app=leetcode id=126 lang=java
 *
 * [126] Word Ladder II
 */

// @lc code=start
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<List<String>>();
        int minLengh = Integer.MAX_VALUE;
        HashSet<String> visited = new HashSet<>();
        // Queue<String> q = new LinkedList<>();
        Queue<ArrayList<String>> q = new LinkedList<>(); // KEY: just save the path to the queue
        ArrayList<String> path = new ArrayList<>();
        path.add(beginWord);
        q.offer(path);
        while (!q.isEmpty()) {
            ArrayList<String> curPath = q.poll();
            String s = curPath.get(curPath.size() - 1);
            // if (visited.contains(s)) {
            //     System.out.println("path: " + curPath + " visited: " + s);
            //     continue;
            // }

            visited.add(s);
            if (s.compareTo(endWord) == 0) {
                if (minLengh >= curPath.size()) {
                    minLengh = curPath.size();
                    ans.add(new ArrayList<>(curPath));
                }
            }

            for (String word : wordList) {
                if (isOneWordDiff(s, word) && !visited.contains(word)) {
                    ArrayList<String> newPath = new ArrayList<>(curPath);
                    newPath.add(word);
                    q.offer(newPath);
                }
            }
        }

        return ans;
    }

    private boolean isOneWordDiff(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        boolean diffFound = false;
        for (int i=0; i<s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diffFound) {
                    // more than 1 diff
                    return false;
                } else {
                    diffFound = true;
                }
            }
        }

        // System.out.println(s2 + " result: " + diffFound);
        return diffFound;
    }
}
// @lc code=end

