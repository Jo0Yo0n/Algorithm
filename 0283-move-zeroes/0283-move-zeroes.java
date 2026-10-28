class Solution {
    public void moveZeroes(int[] nums) {
        int zp = 0, np = 0;

        while(np < nums.length) {
            while(np < nums.length && nums[np] == 0) {
                np++;
                
                if(np == nums.length) return;
            }

            while(zp < nums.length && nums[zp] != 0) {
                zp++;
            }

            if (zp < np) {
                nums[zp] = nums[np];
                nums[np] = 0;
            } else {
                np++;
            }
        }
    }
}