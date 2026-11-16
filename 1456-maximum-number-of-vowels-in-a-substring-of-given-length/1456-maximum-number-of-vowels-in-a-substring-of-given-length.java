class Solution {
    public int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int count = 0, max = 0, left = 0;

        for(int i = 0; i < k; i++) {
            if(vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }
        }
        max = count;

        for(int i = k; i < s.length(); i++) {
            if(vowels.indexOf(s.charAt(left)) != -1) {
                count--;
            }

            if(vowels.indexOf(s.charAt(i)) != -1) {
                count++;
            }

            max = max > count ? max : count;
            left++;
        }

        return max;
    }
}