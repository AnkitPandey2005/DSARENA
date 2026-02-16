class Solution {
    public boolean isValidSerialization(String s) {
        String[] str=s.split(",");
        int v=1;
        for(int i=0;i<str.length;i++){
            if(v==0){
                return false;
            }
            if(str[i].equals("#")){
                v=v-1;
            }else{
                v=v-1;
                v=v+2;
            }
        }
        if(v==0){
            return true;
        }else{
            return false;
        }
    }
}