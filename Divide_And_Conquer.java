package Recursion_MONUBHAIYA;

//what is the diff between the recursion and DNC --->
public class Divide_And_Conquer {
    public static void main(String[] args) {
        int[] arr={5,7,3,4,2};
        int[] ans=Sort(arr,0,arr.length-1);
        for(int i=0;i<ans.length;i++){
            System.out.print(ans[i]+" ");
        }
    }
    public static int[] Sort(int[] arr,int si,int ei){//[5,7,3,4,2]  {0,1,2,3,4} N=4/2=2   left side={5,7,3} right side={4,2}
        if(si==ei){
            int[] bs=new int[1];
            bs[0]=arr[si];
            return bs;
        }
        int mid=(si+ei)/2;
        int[] a=Sort(arr,si,mid);
        int[] b=Sort(arr,mid+1,ei);
        return merge_Two_Array(a,b);
    }
    public static int[] merge_Two_Array(int[] arr1,int[] arr2){
        int n=arr1.length;
        int m=arr2.length;
        int[] ans=new int[n+m];
        int i=0,j=0,k=0;
        while(i<n && j<m){
            if(arr1[i]<arr2[j]){
                ans[k]=arr1[i];
                k++;
                i++;
            }
            else{
                ans[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i<n){
            ans[k]=arr1[i];
            k++;
            i++;
        }
        while(j<m){
            ans[k]=arr2[j];
            k++;
            j++;
        }
        return ans;
    }
}
