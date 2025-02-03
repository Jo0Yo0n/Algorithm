class Solution {
    public int solution(int[][] sizes) {
        StringBuilder sb = new StringBuilder();
        int maxW = -1;
        int maxH = -1;
        
        for(int i = 0; i < sizes.length; i++) {
            if(sizes[i][0] < sizes[i][1]) {
                swap(sizes[i]);
            }
            if(sizes[i][0] > maxW) {
                maxW = sizes[i][0];
            }
            if(sizes[i][1] > maxH) {
                maxH = sizes[i][1];
            }
        }
        int answer = maxW * maxH;
        return answer;      
    }
    
    public void swap(int[] arr) {
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }
}