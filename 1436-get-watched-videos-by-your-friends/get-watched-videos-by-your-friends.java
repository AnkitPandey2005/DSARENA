class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n=friends.length;
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(id);
        visited[id]=true;
        int currentlevel=0;

        while(!queue.isEmpty() && currentlevel<level){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int person=queue.poll();
                for(int friend:friends[person]){
                    if(!visited[friend]){
                        visited[friend]=true;
                        queue.offer(friend);
                    }
                }
            }
            currentlevel++;
        }

        Map<String,Integer> freqMap=new HashMap<>();
        while(!queue.isEmpty()){
            int person=queue.poll();
            for(String video:watchedVideos.get(person)){
                freqMap.put(video,freqMap.getOrDefault(video,0)+1);
            }
        } 

        List<String> result=new ArrayList<>(freqMap.keySet());
        result.sort((a,b)->{
            int cmp=freqMap.get(a)-freqMap.get(b);
            if(cmp!=0) return cmp;
            return a.compareTo(b);
        });
        return result;
    }
}