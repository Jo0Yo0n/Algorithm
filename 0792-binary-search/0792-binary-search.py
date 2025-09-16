class Solution:
    def search(self, nums: List[int], target: int) -> int:
        low = 0
        high = len(nums) - 1

        while low <= high:
            middle = (low + high) // 2
            if nums[middle] == target:
                return middle
            
            elif nums[middle] < target:
                low = middle + 1
            else:
                high = middle - 1

        return -1