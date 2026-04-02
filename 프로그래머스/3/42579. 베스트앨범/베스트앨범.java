import java.io.*;
import java.util.*;

class Solution {
	Map<String, Genre> genreMap;
    
    public int[] solution(String[] genres, int[] plays) {
    	genreMap = new HashMap<>();
    	
    	for(int i = 0; i < genres.length; i++) {
    		Song song = new Song(i, plays[i]);
    		
    		Genre genre = genreMap.getOrDefault(genres[i], new Genre(genres[i]));
    		genre.add(song);
    		genreMap.put(genres[i], genre);
    	}
    	
    	PriorityQueue<Genre> genreOrder = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
    	for(String name : genreMap.keySet()) {
    		Genre genre = genreMap.get(name);
    		
    		genreOrder.add(genre);
    	}
    	
    	List<Integer> answer = new ArrayList<>();
    	while(!genreOrder.isEmpty()) {
    		Genre cur = genreOrder.poll();
    		for(int i = 0; i < 2; i++) {
    			if(cur.songList.isEmpty()) continue;
    			
    			answer.add(cur.songList.poll().id);
    		}
    	}
    	
    	return answer.stream().mapToInt(Integer::intValue).toArray();
    }	
}

class Song {
    int id;
    int plays;
    
    Song (int id, int plays) {
        this.id = id;
        this.plays = plays;
    }
}

class Genre {
	String name;
	int cnt;
	PriorityQueue<Song> songList;
	
	Genre(String name) {
		this.name = name;
		cnt = 0;
		songList = new PriorityQueue<>((a, b) -> {
			if(a.plays == b.plays) return a.id - b.id;
			return b.plays - a.plays;
		});
	}
	
	public void add(Song song) {
		cnt += song.plays;
		songList.add(song);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}