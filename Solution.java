import java.util.Stack;

class Solution {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        
        for (char c: chars) {
          if (c == ']') {
              // pop
              String topStr;
            //   StringBuffer buffer = new StringBuffer(9000);
            String tmpStr = "";
              while (!"[".equals(topStr = stack.pop())) {
                //   buffer.insert(0, topStr);
                tmpStr = topStr + tmpStr;
              }

            //   String tmp = buffer.toString();
            String decodeStr = "";
              int repeat = Integer.parseInt(stack.pop());
              while (repeat != 0) {
                //   buffer.append(tmp);
                decodeStr += tmpStr;
                  repeat--;
              }
            //   stack.push(buffer.toString());
            stack.push(decodeStr);
          } else {
              stack.push(String.valueOf(c));
          }
      }

    //   StringBuffer res = new StringBuffer(9000);
      String res = "";
      while (stack.size() != 0) {
        //   res.insert(0, stack.pop());
          res = res + stack.pop();
      }

      // ""100[leetcode]""
    //   return res.toString();
      return res;
    }

    public static void main(String[] args) {
      Solution s = new Solution();
      System.out.println(s.decodeString("100[a]"));
    }
}


