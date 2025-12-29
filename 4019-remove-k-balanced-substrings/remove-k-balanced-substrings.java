class Solution {
    public String removeSubstring(String s, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<k;i++){
            sb.append('(');
        }
        for(int i=0;i<k;i++){
            sb.append(')');
        }
        String pattern=sb.toString();
        int pos=0;
        StringBuilder sb1=new StringBuilder(s);
        while((pos =sb1.indexOf(pattern,pos))!=-1){
            sb1.delete(pos,pos+sb.length());
            pos-=2*k;
        }
        return sb1.toString();
    }
}