class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];
        int comp = 1;

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                answer[i] = comp;
                continue;
            }

            comp *= nums[i - 1];
            answer[i] = comp;
        }

        comp = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(i == n - 1) {
                answer[i] *= comp;
                continue;
            }

            comp *= nums[i + 1];
            answer[i] *= comp;
        }

        return answer;
    }
}