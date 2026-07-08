class Solution {
    public int[] sortArray(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        mergesort( nums,  left,  right);
        return nums;
    }
    public  void mergesort(int[] nums, int left, int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergesort(nums, left, mid);
        mergesort(nums, mid + 1, right);
        merge(nums, left, mid, right);
    }
    public void merge(int[] nums, int left, int mid, int right){
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];
        for(int i = 0; i < n1; i++){
            l[i] = nums[left + i];
        }
        for(int j = 0; j < n2; j++){
            r[j] = nums[mid + 1 + j];
        }
        int i = 0;
        int j = 0;
        int k = left;
        while(i < n1 && j < n2){
            if(l[i] <= r[j]){
                nums[k++] = l[i++];
            }
            else{
                nums[k++] = r[j++];
            }
        }
        while(i < n1){
            nums[k++] = l[i++];
        }
        while(j < n2){
            nums[k++] = r[j++];
        }
    }
}