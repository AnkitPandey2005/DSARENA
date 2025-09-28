class Solution {
    public int[] searchRange(int[] arr, int target) {
         int f=first(arr,target);
        if(f==-1) return new int[]{-1,-1};
        int l=last(arr,target);
        return new int[]{f,l};
    }
    public static int first(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        
        while(low<=high){

            int mid=(low+high)/2;
            if(arr[mid]==target){
                ans=mid;
                high=mid-1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
    public static int last(int[] arr,int target){
        int low=0;
        int high=arr.length-1;
        int ans=-1;
        
        while(low<=high){

            int mid=(low+high)/2;
            if(arr[mid]==target){
                ans=mid;
                low=mid+1;
            }else if(arr[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return ans;
    }
}