class Solution {
    public boolean search(int[] arr, int target) {
        int low=0;
        int high=arr.length-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(arr[mid]==target) return true;  //if you are find it no need to elimination
            //for duplicate's 
            if(arr[low]==arr[mid]  && arr[mid]==arr[high]){
                low++;
                high--;
                continue;
            }
            //left side sorted
            if(arr[low]<=arr[mid]){
                if(arr[low]<=target && target<=arr[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
            //right side sorted
            else{
                if(arr[mid]<=target && target<=arr[high]){
                    low=mid+1;
                }else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}