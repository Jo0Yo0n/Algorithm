class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int area = (n - 1) * Math.min(height[left], height[right]);

        while(left < right) {
            if(height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }

            int candArea = (right - left) * Math.min(height[left], height[right]);
            area = area > candArea ? area : candArea;
        }

        return area;
    }
}
