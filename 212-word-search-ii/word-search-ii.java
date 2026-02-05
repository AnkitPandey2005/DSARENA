class Solution {
    static List<String> result;
    public List<String> findWords(char[][] maze, String[] words) {
        result=new ArrayList<>();
        Trie t=new Trie();
        for(String s:words){
            t.insert(s);
        }
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(t.root.child.containsKey(maze[i][j])){
                    t.search(maze,i,j,t.root);
                }
            }
        }
        return result;
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

        Node root=new Node('*');

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

        public void search(char [][] maze,int i,int j,Node node){
            if(i<0 || j<0 || i>=maze.length || j>=maze[0].length || !node.child.containsKey(maze[i][j])){
                return;
            }
            char ch=maze[i][j];
            node=node.child.get(ch);
            if(node.terminal!=null){
                result.add(node.terminal);
                node.terminal=null;
            }
            maze[i][j]='*';
            search(maze,i-1,j,node);
            search(maze,i,j-1,node);
            search(maze,i+1,j,node);
            search(maze,i,j+1,node);
            maze[i][j]=ch;
        }
    }
}