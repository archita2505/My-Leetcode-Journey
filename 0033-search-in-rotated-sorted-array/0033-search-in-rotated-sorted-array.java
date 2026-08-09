class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = left + (right-left)/2;
            if(nums[mid]==target){
                return mid;
            }
            //Checking whether the target falls in left sorted array or right sorted array
            if(nums[mid]>=nums[left]){ //left sorted array
                if(nums[left]<=target && target<nums[mid]){
                    right = mid-1;
                }
                else{
                    left = mid+1;
                }
            }
            else{//right sorted array
                if(nums[mid]<target && target<=nums[right]){
                    left = mid+1;
                }
                else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}