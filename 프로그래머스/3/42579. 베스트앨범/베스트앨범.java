import java.util.*;
// 3:40
class Solution {
    static class Album{
        int idx;
        String name;
        int count;
        
        public Album(int idx, String name, int count){
            this.idx = idx;
            this.name = name;
            this.count = count;
        }
    }
    static class Music implements Comparable<Music>{
        int idx;
        int count;
        
        public Music(int idx, int count){
            this.idx = idx;
            this.count = count;
        }
        public int compareTo(Music o){
            if(o.count == this.count){
                return this.idx - o.idx;
            }
            return o.count - this.count;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashSet<String> set = new HashSet<>();
        HashMap<String, Album> genreMap = new HashMap<>();
        TreeMap<String, Integer> genreCounts = new TreeMap<>();
        
        int albumIdx = 0;
        for(String s : genres){
            if(set.contains(s))
                continue;
            set.add(s);
            genreMap.put(s, new Album(albumIdx++, s, 0));
            
        }
        
        PriorityQueue<Music>[] albums = new PriorityQueue[genreMap.size() + 1];
        for(int i = 0; i <= genreMap.size(); i++){
            albums[i] = new PriorityQueue<Music>();
        }
        
        int musicIdx = 0;
        for(int i = 0; i < genres.length; i++){
            Album album = genreMap.get(genres[i]);
            int albumNo = album.idx;
            albums[albumNo].add(new Music(musicIdx++, plays[i]));
            album.count += plays[i];
        }
        PriorityQueue<Album> albumPq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for(String s : set){
            albumPq.add(genreMap.get(s));
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        while(!albumPq.isEmpty()){
            Album album = albumPq.poll();

            for(int i = 0; i < 2; i++){
                if(albums[album.idx].isEmpty())
                    break;
                Music music = albums[album.idx].poll();

                answer.add(music.idx);
            }
            
        }
        
        int[] ans = new int[answer.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
}