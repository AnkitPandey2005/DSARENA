class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n=deck.length;
        boolean skip=false;

        int[] result=new int[n];
        int i=0; //deck
        int j=0; //result
        Arrays.sort(deck);

        while(i<n){
            if(result[j]==0){ //abhi khali h
                if(skip==false){
                    result[j]=deck[i];
                    i++;
                }
                skip =!skip; //alternate
            }
            j=(j+1)%n;
        }
        return result;
    }
}