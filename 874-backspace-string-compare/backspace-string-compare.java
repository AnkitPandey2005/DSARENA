class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#'){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s.charAt(i));
            }
        }

        Stack<Character> ts=new Stack<>();
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#'){
                if(!ts.isEmpty()){
                    ts.pop();
                }
            }
            else{
                ts.push(t.charAt(i));
            }
        }

        if(st.equals(ts)){
            return true;
        }
        return false;
    }
}