import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int maxLen = 0; 
        int i = 0;     

        for (int j = 0; j < s.length(); j++) {
            char currentChar = s.charAt(j);
            
            if (set.contains(currentChar)) {
                while (set.contains(currentChar)) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            
            set.add(currentChar);
            maxLen = Math.max(maxLen, j - i + 1);
        }

        return maxLen;
    }
    
    public static void main(String[] args){
      Solution solution = new Solution();
      String s = "pwwkew";
      System.out.println(solution.lengthOfLongestSubstring(s));
    }
}
