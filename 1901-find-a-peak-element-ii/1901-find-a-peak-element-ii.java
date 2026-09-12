class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        //Binary search on columns
        int left = 0;
        int right = n-1;
        while(left<=right){
            int mid = (left + right)/2;
            int maxRow = 0 ;
            for(int row =1;row<m;row++){
                if(mat[row][mid] > mat[maxRow][mid]){
                    maxRow=row;
                }
            }

            int currentElement = mat[maxRow][mid];

            //Checking if leftValue and rightValue exists or not
            int leftValue = (mid>0) ? mat[maxRow][mid-1] : -1; 
            int rightValue = (mid<n-1) ? mat[maxRow][mid+1] : -1;

            if(currentElement > leftValue && currentElement > rightValue){
                return new int[]{maxRow,mid};
            }
            else if(leftValue > currentElement){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }
        return new int[]{-1,-1};
    }
}