class Solution {
    public int[] solution(int[] answers) {
        int one, two, three;
        one = two = three = 0;
        int[] twoArr = {1, 3, 4, 5};
        int[] threeArr = {3, 1, 2, 4, 5};
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] % 5 == (i + 1) % 5) one++;
            if(i % 2 == 0 && answers[i] == 2) two++;
            if(i % 2 != 0 && answers[i] == twoArr[(i / 2) % 4]) two++;
            if(answers[i] == threeArr[(i / 2) % 5]) three++;
        }
        
        int[] ret = {one, two, three};
        int max = -1;
        for(int i = 0; i < 3; i++) {
            if(ret[i] > max) max = ret[i];
        }
        
        int count = 0;
        for(int i = 0; i < 3; i++) {
            if(max == ret[i]) count++;
        }
        int[] ans = new int[count];
        int t = 0;
        for(int i = 0; i < 3; i++) {
            if(max == ret[i]) ans[t++] = i + 1;
        }
        
        return ans;
    }
}