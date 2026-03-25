class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
      DFS(image,sr,sc,color,image[sr][sc]);    
      return image;
    }
    public static void DFS(int[][] image,int i,int j,int newcolor,int orgcolor){
        //base case [3]
        if(i<0 || j<0 ||i>=image.length || j>=image[0].length || image[i][j]!=orgcolor || image[i][j]==newcolor){
            return;
        }

        image[i][j]=newcolor;

        DFS(image,i-1,j,newcolor,orgcolor);//top
        DFS(image,i,j+1,newcolor,orgcolor);//right
        DFS(image,i,j-1,newcolor,orgcolor);//left
        DFS(image,i+1,j,newcolor,orgcolor);//bottom
    }
}