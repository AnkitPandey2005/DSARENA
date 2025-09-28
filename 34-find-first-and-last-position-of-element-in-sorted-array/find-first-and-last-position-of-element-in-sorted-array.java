class Solution {
    public int[] searchRange(int[] arr, int target) {
        int lb=lowerbound(arr,target);
        if(lb==arr.length || arr[lb]!=target){
            return new int[]{-1,-1};
        }
        return new int[]{lb,upperbound(arr,target)-1};
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