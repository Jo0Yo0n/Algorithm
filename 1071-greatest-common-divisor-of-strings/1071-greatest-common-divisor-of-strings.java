class Solution {
    public String gcdOfStrings(String str1, String str2) {
        
        StringBuilder answer = new StringBuilder();
        int len1 = str1.length();
        int len2 = str2.length();
        int minLen = Math.min(len1, len2);

        for(int i = 0; i < minLen; i++) {
            if(str1.charAt(i) == str2.charAt(i)) {
                answer.append(str1.charAt(i));
            }
        }

        while(answer.length() > 0) {
            if(len1 % answer.length() != 0 || len2 % answer.length() != 0) {
                answer.deleteCharAt(answer.length() - 1);
                continue;
            }

            int str1Time = len1 / answer.length();
            int str2Time = len2 / answer.length();
            String answerStr1Time = "";
            String answerStr2Time = "";

            for(int i = 0; i < str1Time; i++) {
                answerStr1Time += answer;
            }
            for(int i = 0; i < str2Time; i++) {
                answerStr2Time += answer;
            }

            if (!answerStr1Time.equals(str1) || !answerStr2Time.equals(str2)) {
                answer.deleteCharAt(answer.length() - 1);
                continue;
            }
            else {
                return answer.toString();
            }
        }

        return "";
    }
}