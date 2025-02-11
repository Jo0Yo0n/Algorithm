class Solution {
    char[] dict = {'A', 'E', 'I', 'O', 'U'};
    boolean isFound = false;
    
    public int solution(String word) {
        int ans = dfs(word, "");
        
        return ans - 1;
    }
    
    public int dfs(String word, String cur) {
        int n = 1;
        
        if(cur.equals(word)) {
            isFound = true;
            return n;
        }
        
        if(cur.length() == 5) {
            return n;
        }
        
        for(int i = 0; i < 5; i++) {
            n += dfs(word, cur + dict[i]);
            if(isFound) return n;
        }
        
        return n;
    }
}

// dfs