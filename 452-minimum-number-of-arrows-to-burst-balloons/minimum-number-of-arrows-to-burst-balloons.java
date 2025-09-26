class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));   
        long c=1;
        long temp=points[0][1];
        for(int i=1;i<points.length;i++){
            if(points[i][0]>temp){
                c++;
                temp=points[i][1];
            }
            else{
                temp=Math.min(points[i][1],temp);
            }
        }
        return (int)c;
    }
}