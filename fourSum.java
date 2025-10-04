import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (nums == null || size < 4){
          return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < size - 3; i++){
          if (i > 0 && nums[i] == nums[i-1]) continue;
          for (int j = i+1; j < size - 2; j++){
            if (j > i+1 && nums[j] == nums[j-1]) continue;
            int left = j + 1;
            int right = size - 1;
            while (left < right){
              long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
              if (sum == target){
                List<Integer> res = new ArrayList<>();
                res.add(nums[i]);
                res.add(nums[j]);
                res.add(nums[left]);
                res.add(nums[right]);
                result.add(res);
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]){
                  left++;
                }
                while (left < right && nums[right] == nums[right+1]){
                  right--;
                }
              } else if (sum < target) {
                left++;
              } else {
                right--;
              }
            }
          }
        }
        return result;
    }
    
    public static void main (String[] args){
      Solution solution = new Solution();
      int[] nums = {1,0,-1,0,-2,2};
      int target = 0;
      
      List<List<Integer>> result = solution.fourSum(nums, target);
      
      System.out.println(result);
    }
}
