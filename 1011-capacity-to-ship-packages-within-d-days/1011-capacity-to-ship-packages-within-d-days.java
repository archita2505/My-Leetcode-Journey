class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0; //min range = maximum of all the weights
        int high = 0; //max range = sum of all the weights
        for(int w : weights){
            low = Math.max(low,w);
            high += w;
        }
        int ans = 0;
        while(low<=high){
            int cap = low + (high -low)/2;
            if(canShip(weights,days,cap)){
                ans = cap;
                high = cap-1;
            }
            else{
                low = cap+1;
            }
        }
        return ans ; 
    }

    private boolean canShip(int[]weights,int days,int cap){
        int day = 1;
        int curr = 0;
        for(int w : weights){
            if(curr+w > cap){
            day++;
            curr = w;
        }
        else{
            curr += w;
        }
        }
        return day <= days;
    }
}