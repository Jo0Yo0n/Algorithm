class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0, max = 0, left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                count++;
            }

            if(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
        }

        return nums.length - left;
    }
}