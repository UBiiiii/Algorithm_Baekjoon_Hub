import java.util.*;

class Solution {
    private class Genre {
        String name;
        List<int[]> songs;
        
        Genre(String name) {
            this.name = name;
            this.songs = new ArrayList<>();
        }
        
        List<int[]> getSongs() {
            this.songs.sort((a,b)->b[1]==a[1] ? a[0]-b[0] : b[1]-a[1]);
            return this.songs;
        }
        
        void addSong(int idx, int song) {
            this.songs.add(new int[] {idx, song});
        }
        
        int getSize() {
            return this.songs.size();
        }

        int getPlays() {
            int ret = 0;
            for(int i=0;i<songs.size();i++) ret += songs.get(i)[1];
            return ret;
        }
        
        String getString() {
            return "Genre name: " + this.name + ", songs: " + songs;
        }
    }
    
    public List<Integer> solution(String[] genres, int[] plays) {
        int i=0, tmp;
        List<Integer> answer = new ArrayList<>();
        Genre[] gs;
        Map<String, Integer> idx = new HashMap<>();
        Set<String> s = Arrays.stream(genres).collect(HashSet::new, HashSet::add, HashSet::addAll);
        gs = new Genre[s.size()];
        for(String genre : s) {
            idx.put(genre, i);
            gs[i++] = new Genre(genre);
        }
        
        for(i=0;i<genres.length;i++) {
            tmp = idx.get(genres[i]);
            gs[tmp].addSong(i, plays[i]);
        }
        
        Arrays.sort(gs, (a,b)->b.getPlays()-a.getPlays());
        
        for(Genre g : gs) {
            List<int[]> songs = g.getSongs();
            answer.add(songs.get(0)[0]);
            if(songs.size() > 1)    answer.add(songs.get(1)[0]);
        }
        
        return answer;
    }
}