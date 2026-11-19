class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0, max = 0, left = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                max = Math.max(max, i - left + 1);
                continue;
            } else {
                count++;
                if (count <= k) {
                    max = Math.max(max, i - left + 1);
                }
            }
            while(count > k) {
                if(nums[left] == 1) {
                    left++;
                }
                if(nums[left] == 0) {
                    count--;
                    left++;
                }
            }
        }

        return max;
    }
}