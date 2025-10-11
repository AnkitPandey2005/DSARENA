class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
         int m=flowers.length;
         int n=people.length;

         int[] result=new int[n];

         int[] start_time=new int[m];
         int[] end_time=new int[m];

         for(int i=0;i<m;i++){
            start_time[i]=flowers[i][0];
            end_time[i]=flowers[i][1];
         }

         Arrays.sort(start_time);
         Arrays.sort(end_time);

         for(int i=0;i<n;i++){
            int bloomed=upperbound(start_time,people[i]);
            int died=lowerbound(end_time,people[i]);
            result[i]=bloomed-died;
         }
         return result;
    }

    public static int lowerbound(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]>=target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public static int upperbound(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=arr.length;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]>target){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }   
}