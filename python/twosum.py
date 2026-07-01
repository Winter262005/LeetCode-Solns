from typing import List

nums = [3,2,3]
target = 6

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        thisdict = {}
        for i in range(len(nums)):
            comp = target - nums[i]
            if comp in thisdict:
              return [thisdict[comp], i]
            else:
              thisdict[nums[i]] = i

solver = Solution()
solver.twoSum(nums,target)
