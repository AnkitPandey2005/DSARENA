class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t=new Trie();
        for(String s:dictionary){
            t.insert(s);
        }
        String [] arr=sentence.split(" ");
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String s=arr[i];
            sb.append(t.search(s));
            if(i!=arr.length-1){
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    // trie implementation
    static class Trie{
        class Node{
            char ch;
            String terminal;
            HashMap<Character,Node> child;
            public Node(char ch){
                this.ch=ch;
                child=new HashMap<>();
            }
        }

        private Node root=new Node('*');

        public void insert(String word) {
            Node curr=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                }
                else{
                    Node nn=new Node(ch);
                    curr.child.put(ch,nn);
                    curr=nn;
                }
            }
            curr.terminal=word;
        }

        public String search(String word) {
            Node curr=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                    if(curr.terminal!=null){
                        return curr.terminal;
                    }
                }
                else{
                    return word;
                }
            }
            return word;
        }
    } 
}