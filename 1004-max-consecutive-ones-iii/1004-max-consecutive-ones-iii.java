class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0, max = 0, left = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 1) {
                max = Math.max(max, right - left + 1);
                continue;
            } else {
                count++;
                if (count <= k) {
                    int tmp = right - left + 1;
                    max = max > tmp ? max : tmp;
                }
            }
            while(count > k) {
                if(nums[left] == 0) {
                    count--;
                }
                left++;
            }
        }

        return max;
    }
}