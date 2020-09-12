class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0)
            return 0;
        int minans = nums[0];
        int maxans = nums[0];
        int gans = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] < 0){
                //swap minans, maxans
                int temp = minans;
                minans = maxans;
                maxans = temp;
            }
            minans = Math.min(minans*nums[i],nums[i]);
            maxans = Math.max(maxans*nums[i],nums[i]);
            gans = Math.max(gans,maxans);
        }
        return gans;
    }    
}
