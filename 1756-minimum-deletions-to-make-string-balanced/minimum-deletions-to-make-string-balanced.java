class Solution {
    public int minimumDeletions(String s) {
        int numb=0;
        int mindel=0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                mindel=Math.min(mindel+1,numb);
            }else{
                numb++;
            }
        }
        return mindel;
    }
}