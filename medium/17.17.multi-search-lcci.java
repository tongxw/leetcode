import java.util.*;
// https://leetcode-cn.com/problems/multi-search-lcci/
class Solution {
  public int[][] multiSearch(String big, String[] smalls) {
      Trie trie = new Trie();
      for (String word : smalls) {
          trie.insert(word);
      }
      HashMap<String, List<Integer>> map = new HashMap<>();
      for (int i=0; i<big.length(); i++) {
          String subStr = big.substring(i);
          List<String> res = trie.search(subStr);
          for (String word : res) {
              if (!map.containsKey(word)) {
                  map.put(word, new ArrayList<>());
              }

              map.get(word).add(i);
          }
      }

      int[][] ans = new int[smalls.length][];
      for (int i=0; i<smalls.length; i++) {
          String word = smalls[i];
          List<Integer> res = map.get(word);
          if (res == null) {
              ans[i] = new int[0];
          } else {
              ans[i] = new int[res.size()];
              for (int j=0; j<res.size(); j++) {
                  ans[i][j] = res.get(j);
              }
          }
      }

      return ans;
  }

  class Trie {
      Trie[] children;
      String word;

      Trie() {
          children = new Trie[26];
          word = null;
      }

      public void insert(String word) {
          Trie node = this;
          for (char c : word.toCharArray()) {
              int idx = c - 'a';
              if (node.children[idx] == null) {
                  node.children[idx] = new Trie();
              }
              node = node.children[idx];
          }
          node.word = word;
      }

      public List<String> search(String word) {
          Trie node = this;
          List<String> res = new ArrayList<>();
          for (char c : word.toCharArray()) {
              int idx = c - 'a';
              if (node.children[idx] == null) {
                  break;
              }
              node = node.children[idx];
              if (node.word != null) {
                  res.add(node.word);
              }
          }

          return res;
      }

  }
}