import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map <Integer, Integer> seen = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
          int comp = target - nums[i];
          
          if(seen.containsKey(comp)){
            return new int[] {seen.get(comp), i};
          } else {
            seen.put(nums[i], i);
          }
        }
        throw new IllegalArgumentException("No Match");
    }
    
    public static void main(String[] args){
      Solution solution = new Solution();
      
      int[] nums = {2,7,11,15};
      int target = 9;
      
      int[] result = solution.twoSum(nums, target);
      
      System.out.println(Arrays.toString(result));
    }
}
