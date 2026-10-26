class Solution {
    public int compress(char[] chars) {
        int cur = 0, count = 0, answer = 0;
        char c = chars[0];

        for(int i = 0; i < chars.length; i++) {
            if(c != chars[i]) {
                String digit = count == 1 ? "" : Integer.toString(count);
                char tmp = chars[i];

                chars[cur++] = c;
                for(int j = 0; j < digit.length(); j++) {
                    chars[cur++] = digit.charAt(j);
                }

                answer += 1 + digit.length();
                c = tmp;
                count = 0;
            }
            if(i == chars.length - 1) {
                count += 1;
                chars[cur++] = c;
                
                String digit = count == 1 ? "" : Integer.toString(count);
                for(int j = 0; j < digit.length(); j++) {
                    chars[cur++] = digit.charAt(j);
                }

                answer += 1 + digit.length();
            }

            count += 1;
        }

        return answer;
    }
}