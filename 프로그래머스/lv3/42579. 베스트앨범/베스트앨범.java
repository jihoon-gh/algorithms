import java.util.*;

class Solution {
    static class Song{
        public int id;
        public int plays;
        public Song(int a, int b){
            id = a;
            plays = b;
        }
    }
    static Map<String, Integer> songPlays = new HashMap<>();
    static Map<String, PriorityQueue<Song>> songs = new HashMap<>();
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        for(int i = 0 ; i < genres.length; i++){
            String genre = genres[i];
            int k = songPlays.getOrDefault(genre, 0);
            songPlays.put(genre, k + plays[i]);
            if(songs.get(genre) == null){
                songs.put(genre, new PriorityQueue<Song>(new Comparator<Song>(){
                    @Override
                    public int compare(Song s1, Song s2){
                        if(s1.plays == s2.plays){
                            return s1.id - s2.id;
                        }
                        return s2.plays-s1.plays;
                    }
                }));
            }
            songs.get(genre).add(new Song(i, plays[i]));
        }
        List<String> genreList = new ArrayList<>();
        for(String s : songPlays.keySet()){
            genreList.add(s);
        }
        Collections.sort(genreList, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return songPlays.get(s2) - songPlays.get(s1);
            }
        });
        List<Integer> alist = new ArrayList<>();
        int i = 0;
        for(String s : genreList){
            if(songs.get(s).size() == 1){
                int id = songs.get(s).poll().id;
                alist.add(id);
            }
            else{
                int id1 = songs.get(s).poll().id;
                int id2 = songs.get(s).poll().id;
                alist.add(id1);
                alist.add(id2);
            }
        }
        answer = alist.stream().mapToInt(a -> a).toArray();
        return answer;
    }
}