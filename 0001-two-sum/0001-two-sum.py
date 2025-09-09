class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        pair = {}
        ans = []

        for idx, val in enumerate(nums):
            if val in pair:
                ans.append(pair[val])
                ans.append(idx)
                return ans
            
            pair[target - val] = idx
