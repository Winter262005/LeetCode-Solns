import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int start = 0;
        int end = nums1.length;

        while (start <= end){
            int i1 = (start + end) / 2;
            int i2 = (nums1.length + nums2.length + 1) / 2 - i1;

            int left1 = i1 == 0 ? Integer.MIN_VALUE : nums1[i1 - 1];
            int right1 = i1 == nums1.length ? Integer.MAX_VALUE : nums1[i1];

            int left2 = i2 == 0 ? Integer.MIN_VALUE : nums2[i2 - 1];
            int right2 = i2 == nums2.length ? Integer.MAX_VALUE : nums2[i2];

            if (left1 > right2) {
                end = i1 - 1;
            } else if (left2 > right1) {
                start = i1 + 1;
            } else {
                if ((nums1.length + nums2.length) % 2 == 0){
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            }

        }
        return -1;
    }
    
    public static void main(String[] args){
      Solution solution = new Solution();
      int[] nums1 = {1,2};
      int[] nums2 = {3,4};
      System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }
}
