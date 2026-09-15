class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num:nums){
            high = Math.max(num,high);
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(smallestDivisor(nums, threshold, mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean smallestDivisor(int[] nums, int threshold, int k){
        long divisor = 0;
        for(int num:nums){
            divisor += (num+k-1)/k ;
        }
        return divisor <= threshold;
    }
}