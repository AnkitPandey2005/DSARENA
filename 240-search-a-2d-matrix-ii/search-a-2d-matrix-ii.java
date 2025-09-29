class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;

        if (n == 0) return false; // Check for empty matrix

        for (int i = 0; i < n; i++) {
            if (BS(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }
    public static boolean BS(int[] arr,int target){
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]==target) return true;
            else if(target>arr[mid]) low=mid+1;
            else high=mid-1;
        }
        return false;
    }
}