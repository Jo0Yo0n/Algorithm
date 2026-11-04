class Solution {
    public boolean isSubsequence(String s, String t) {
        int pointer = 0;

        for(int i = 0; pointer < s.length() && i < t.length(); i++) {
            if(t.charAt(i) == s.charAt(pointer)) {
                pointer++;
            }
        }

        return pointer == s.length();
    }
}