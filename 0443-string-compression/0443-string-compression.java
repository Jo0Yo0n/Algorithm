class Solution {
    public int compress(char[] chars) {
        int cur = 0;

        for(int i = 0; i < chars.length;) {
            int count = 0;
            char c = chars[i];

            while(i < chars.length && c == chars[i]) {
                count++;
                i++;
            }

            chars[cur++] = c;
            if(count > 1) {
                for(char t : String.valueOf(count).toCharArray()) {
                    chars[cur++] = t;
                }
            }
        }

        return cur;
    }
}