class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        //Taking the lower left corner as the first cell to start with
        int r = m-1;
        int c = 0;
        while(r>=0 && c<n){
            if(matrix[r][c] == target){
                return true;
            }
            else if(matrix[r][c] > target){
                r-=1;
            }
            else{
                c+=1;
            }
        }
        return false;
    }
}