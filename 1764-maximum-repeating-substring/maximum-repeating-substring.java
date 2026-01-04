class Solution {
    public int maxRepeating(String sequence, String word) {
       int cnt=0;
       String tar=word;

       while(sequence.contains(tar)){
         cnt++;
         tar=tar+word;
       }
       return cnt;
    }
}