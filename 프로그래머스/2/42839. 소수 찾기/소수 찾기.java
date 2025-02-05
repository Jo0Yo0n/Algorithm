import java.util.*;

class Solution {
    public int solution(String given) {
        char[] numbers = new char[given.length()];
        for(int i = 0; i < given.length(); i++) {
            numbers[i] = given.charAt(i);
        }
        
        // n개 자릿수, n-1개 자릿수, ..., 1개 자릿수의 순열을 모두 구하고 해당 수가 소수인지 판별
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= numbers.length; i++) {
            set.addAll(generatePermutations(numbers, i));
        }
        
        System.out.println(set.toString());
        
        int ans = 0;
        Iterator<Integer> iter = set.iterator();
        while(iter.hasNext()) {
            int num = iter.next();
            boolean flag = true;
            if(num == 1) continue;
            for(int i = 2; i < num; i++) {
                if(num % i == 0) {
                    flag = false;
                    break;
                }
            }
            
            if(flag) {
                ans++;
                flag = true;
            }
        }
        
        return ans;
    }
    
    public Set<Integer> generatePermutations(char[] arr, int r) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        char[] out = new char[r];
        Set<Integer> result = new HashSet<>();
        
        permutation(arr, 0, n, r, visited, out, result);
        return result;
    }
    
    public void permutation(char[] arr, int depth, int n, int r, boolean[] visited, char[] out, Set<Integer> result) {
        if(depth == r) {
            String str = "";
            for(char t : out) {
                str += t;
            }
            result.add(Integer.parseInt(str));
            return;
        }
        
        for(int i = 0 ; i < n; i++) {
            if(arr[i] == '0' && (depth == 0 || r == 1)) continue;
            if(!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out, result);
                visited[i] = false;
            }
        }
    }
}