class Solution {
    public int minimumBuckets(String hamsters) {
        int n = hamsters.length();
        int cnt = 0;
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            char ch = hamsters.charAt(i);
            if(ch == 'H'){
                if(i>0 && arr[i-1] == 1){
                    continue;
                }
                else if(i < n-1 && hamsters.charAt(i+1) == '.'){
                    arr[i+1] = 1;
                    cnt++;
                }
                else if(i > 0 && arr[i-1] == 0 && hamsters.charAt(i-1) == '.'){
                    arr[i-1] = 1;
                    cnt++;
                }
                else{
                    return -1;
                }
            }
        }
        return cnt;
    }
}