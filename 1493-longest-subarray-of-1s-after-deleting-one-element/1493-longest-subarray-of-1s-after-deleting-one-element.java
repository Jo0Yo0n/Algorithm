class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCount = 0;
        int left = 0, right = 0;

        for(; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            if(zeroCount > 1) {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }

        return (nums.length - 1) - left;
    }
}
