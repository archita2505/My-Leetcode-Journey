class Solution {
    public int maxFrequency(int[] nums, int k) {
        //Sorting the array
        Arrays.sort(nums);

        int n = nums.length;

        // Initialising variables
        int left = 0;
        long sum = 0;
        int maxFreq = 1;

        //Expanding the window
        for (int right = 0; right < n; right++) {

            sum += nums[right];

            // Shrink while operations exceed k
            while ((long) nums[right] * (right - left + 1) - sum > k) {

                sum -= nums[left];

                left++;
            }

            //Update maximum frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }
}