class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        if(matrix.length==0 || matrix[0].length==0 || matrix==null){
            return;
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
        // reverse(matrix[i]);
    }
    public static void reverse(int[] arr){
        int start=0;
        int end=arr.length-1;
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
}