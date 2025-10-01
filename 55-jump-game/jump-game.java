class Solution {
    public boolean canJump(int[] arr) {
        int reach=0;
        for(int i=0;i<=reach;i++){
            reach=Math.max(reach,arr[i]+i);
            if(reach>=arr.length-1){
                return true;
            }
        }
        return false;
    }
}