class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
        int n = candies.length;
        List<Boolean> results = new ArrayList<>();

        int max = -1;
        for(int i = 0; i < n; i++) {
            if(max < candies[i]) {
                max = candies[i];
            }
        }

        for(int i = 0; i< n; i++) {
            if(candies[i] + extraCandies >= max) {
                results.add(true);
            } else {
                results.add(false);
            }
        }

        return results;
    }
}