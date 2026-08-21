class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n){
            return -1;
        }
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int day : bloomDay){
            high = Math.max(high,day);
            low = Math.min(low,day);
        }
        int ans = -1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canBloom(bloomDay,m,k,mid)){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }

    private boolean canBloom(int[] bloomDay, int m, int k, int day){
        int count = 0;
        int bouquets = 0;
        for(int bloom : bloomDay){
            if(bloom <= day){
                count++;
                if(count == k){
                    bouquets++;
                    count = 0;
                }
            }
            else{
                count = 0;
            }
        }
        return bouquets>=m;
    }
}