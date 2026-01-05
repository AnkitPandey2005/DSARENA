class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum=0;
        long count_neg=0;
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<=0){
                    count_neg++;
                }
                smallest=Math.min(smallest,Math.abs(matrix[i][j]));
                sum=sum+Math.abs(matrix[i][j]);
            }
        }
        return count_neg%2!=0?sum-2*smallest:sum;
    }
}