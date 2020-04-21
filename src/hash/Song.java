package hash;

import java.util.HashMap;

public class Song {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < genres.length; i ++){
            map.put(genres[i],plays[i]);
        }

        return answer;
    }
}
