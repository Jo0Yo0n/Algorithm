import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        int sum = 0;
        for(int citation : citations) {
            sum += citation;
        }
        int aver = sum / citations.length;
        
        Integer[] arr = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> b.compareTo(a));
        
        while(!getHIndex(arr, aver)) {
            aver--;
        }
        
        return aver;
    }
    
    public boolean getHIndex(Integer[] arr, int pred) {
        int count = 0;
        
        for(Integer i : arr) {
            if(i >= pred) count++;
            else break;
        }
        
        return (count >= pred) ? true : false;
    }
}