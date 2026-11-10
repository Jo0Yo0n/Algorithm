class Solution {
    public int maxOperations(int[] nums, int k) {
        int answer = 0;
        int left = 0;
        int right = nums.length - 1;

        Arrays.sort(nums);
        while(left < right) {
            int sum = nums[left] + nums[right];

            if(sum == k) {
                left++;
                right--;
                answer++;
            }
            else if(sum > k) {
                right--;
            }
            else {
                left++;
            }
        }

        return answer;
    }
}