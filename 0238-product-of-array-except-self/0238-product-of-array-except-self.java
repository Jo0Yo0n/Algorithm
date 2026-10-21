class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        int comp = 1;

        for(int i = 0; i < n; i++) {
            answer[i] *= comp;
            comp *= nums[i];
        }

        comp = 1;
        for(int i = n - 1; i >= 0; i--) {
            answer[i] *= comp;
            comp *= nums[i];
        }

        return answer;
    }
}