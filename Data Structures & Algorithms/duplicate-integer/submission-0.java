class Solution {
    public boolean hasDuplicate(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0;
        int right = 1;
        while(right < n){
            if(nums[left] != nums[right]){
                left++;
                right++;
            }
            else{
                return true;
            }
        }
        return false;
    }
}