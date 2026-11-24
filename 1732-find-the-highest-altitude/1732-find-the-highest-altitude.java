class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int[] altitudes = new int[gain.length + 1];

        for(int i = 1; i <= gain.length; i++) {
            altitudes[i] = altitudes[i - 1] + gain[i - 1];

            max = Math.max(max, altitudes[i]);
        }

        return max;
    }
}