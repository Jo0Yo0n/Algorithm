class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int sum = 0;
        int max;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }
        max = sum;

        for(int i = k; i < nums.length; i++) {
            sum -= nums[left++];
            sum += nums[i];
            max = max > sum ? max : sum;
        }

        return (double) max / k;
    }
}