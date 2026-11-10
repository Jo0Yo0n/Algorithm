class Solution {
    public int maxOperations(int[] nums, int k) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i  = 0; i < nums.length; i++) {
            int count = map.getOrDefault(nums[i], 0);

            if (count > 0) {
                map.put(nums[i], count - 1);
                answer++;
                continue;
            }

            map.put(k - nums[i], map.getOrDefault(k - nums[i], 0) + 1);
        }

        return answer;
    }
}
