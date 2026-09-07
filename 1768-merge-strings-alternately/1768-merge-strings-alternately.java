class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder answer = new StringBuilder();

        for(int i = 0; i < Math.max(len1, len2); i++) {

            if (i < len1) {
                answer.append(word1.charAt(i));
            }

            if (i < len2) {
                answer.append(word2.charAt(i));
            }
        }

        return answer.toString();
    }
}