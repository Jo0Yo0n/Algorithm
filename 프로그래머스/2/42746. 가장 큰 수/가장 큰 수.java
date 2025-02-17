import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        Integer[] arr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
        Arrays.sort(arr, (a, b) -> {
            String aStr = String.valueOf(a);
            String bStr = String.valueOf(b);
            
            return (bStr + aStr).compareTo(aStr + bStr);
        });
        
        if(arr[0] == 0) {
            return "0";
        }
        
        for(int i = 0; i < arr.length; i++) {
            answer += arr[i];
        }
        
        return answer;
    }
}