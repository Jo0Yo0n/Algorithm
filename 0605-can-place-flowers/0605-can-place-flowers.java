class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
        for(int i = 0; i < flowerbed.length; i++) {
            
            if (flowerbed[i] == 1) {
                i++;
                continue;
            }

            if (i == flowerbed.length - 1) {
                n--;
                continue;
            }
            
            int front = i + 1;

            if (front < flowerbed.length && flowerbed[front] == 0) {
                i++;
                n--;
            }
        }
        return n <= 0;
    }
}