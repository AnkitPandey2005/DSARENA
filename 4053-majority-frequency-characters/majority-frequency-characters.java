class Solution {
    class Pair{
        int freq;
        StringBuilder ch;
        Pair(int freq,StringBuilder ch){
            this.freq=freq;
            this.ch=ch;
        }
    }

    public String majorityFrequencyGroup(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }else{
                map.put(s.charAt(i),1);
            }
        }

        HashMap<Integer,StringBuilder> map1=new HashMap<>();
        for(char i:map.keySet()){
            int key=map.get(i);
            char val=i;
            if(map1.containsKey(key)){
               map1.get(key).append(val);
            }else{
                map1.put(key,new StringBuilder());
                map1.get(key).append(val);
            }
        }


        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
            if(a.ch.length()>b.ch.length()){
                return -1;
            }
           else if(a.ch.length()<b.ch.length()){
                return 1;
            }
            else{
                return b.freq-a.freq;
            }
        });

        for(int i:map1.keySet()){
            pq.add(new Pair(i,map1.get(i)));
        }
        return pq.remove().ch.toString();
    }
}