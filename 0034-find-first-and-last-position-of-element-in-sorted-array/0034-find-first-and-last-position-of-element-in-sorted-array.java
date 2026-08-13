class Solution {
    public int[] searchRange(int[] nums, int target) {
        int firstNum = findFirstOccurence(nums,target);
        int lastNum = findSecondOccurence(nums,target);
        return new int[]{firstNum,lastNum};
    }

    private int findFirstOccurence(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                ans = mid;
                right = mid-1;
            }
            else if (nums[mid]>target){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return ans;
    }
    private int findSecondOccurence(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int ans = -1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]==target){
                ans = mid;
                left = mid+1;
            }
            else if (nums[mid]>target){
                right = mid-1;
            }
            else {
                left = mid+1;
            }
        }
        return ans;
    }
}