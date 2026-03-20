class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> pos=new ArrayList<>();
        ArrayList<Integer> neg=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                pos.add(nums[i]);
            }else{
                neg.add(nums[i]);
            }
        }

        if(pos.size()>neg.size()){
            for(int i=0;i<neg.size();i++){
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }

            int idx=neg.size()*2;
            for(int i=neg.size();i<pos.size();i++){
                nums[idx]=pos.get(i);
                idx++;
            }
        }else{
             for(int i=0;i<pos.size();i++){
                nums[2*i]=pos.get(i);
                nums[2*i+1]=neg.get(i);
            }

            int idx=pos.size()*2;
            for(int i=pos.size();i<neg.size();i++){
                nums[idx]=neg.get(i);
                idx++;
            }
        }
        return nums;
    }
}