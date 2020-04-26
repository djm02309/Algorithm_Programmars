package hash;

import java.util.*;


public class Song {
    public static void main(String[] args){
        Song song = new Song();
//        String[] a = {"classic", "pop", "classic", "classic", "pop"};
//        int[] b = {500, 600, 150, 800, 2500};
        String[] a = {"classic", "pop"};
        int[] b = {500, 600};
        int[] answer =  song.solution(a,b);

        for (int value : answer) {
            System.out.println(value);
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList answerArr = new ArrayList();
        for(int i = 0; i < genres.length; i ++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //value값을 기준으로 내림차순으로 정렬
        List<String> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        //검색하기 쉽게 고유번호:재생횟수 로 map만듦
        HashMap<Integer, Integer> pMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            pMap.put(i, plays[i]);
        }
        //제일 많이 재생된 고유번호 찾기
        for (String s : keySetList) {
            int first = -1, second = -1;        //고유번호 -1로 초기화
            for (int k = 0; k < genres.length; k++) {
                if (genres[k].equals(s)) { //장르별로 찾기
                    if (pMap.getOrDefault(first, -1) < pMap.get(k)) { // k> first> second인 경우
                        second = first;  //first는 second가 되고 k는 first가 됨
                        first = k;
                    } else if (pMap.getOrDefault(first, -1).equals(pMap.get(k))) { //first = k > second
                        if (first > k) {  //고유번호가 k가 더 작은 경우에만 바꿔줌
                            second = first;
                            first = k;
                        }
                    } else if (pMap.getOrDefault(second, -1) < pMap.get(k)) { //first > k > second
                        second = k; //second를 k로 바꿈
                    } else if (pMap.getOrDefault(second, -1).equals(pMap.get(k))) { //first > k = second
                        if (k < second) { //고유번호가 k가 더 작은 경우에만 바꿔줌
                            second = k;
                        }
                    }
                }
            }
            if (first != -1) {  //-1이면 곡이 없다는 것이므로 array에 추가안함
                answerArr.add(first);
                if (second != -1) {
                    answerArr.add(second);
                }
            }
        }
        //정답 배열에 나온 고유번호들 넣어주기
        int[] answer = new int[answerArr.size()];

        for(int i = 0; i < answerArr.size(); i ++){
            answer[i] = (int)answerArr.get(i);
        }
        return answer;
    }
}
////////////////////////////////////////////////////////////////////////
/*
이코드가 programmers 에서 돌아감
위의 코드랑 같고 일부 정리만 했는데 위에껀 안되고 아래껀 잘돌아감
///////////////////////////
import java.util.*;
class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList anserArr = new ArrayList();
        for(int i = 0; i < genres.length; i ++){
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        //value값을 기준으로 내림차순으로 정렬
        List<String> keySetList = new ArrayList<>(map.keySet());
        // 내림차순 //
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return map.get(o2).compareTo(map.get(o1));
            }
        });

        HashMap<Integer, Integer> pMap = new HashMap<>();
        HashMap<Integer, String> gMap = new HashMap<>();
        for(int i = 0; i < genres.length; i++){
            pMap.put(i, plays[i]);
            gMap.put(i, genres[i]);
        }

        for(int i = 0; i<keySetList.size(); i++){
            int first = -1, second = -1;
            for(int k =0; k < genres.length; k++){
                if(genres[k].equals(keySetList.get(i))){
                    if(pMap.getOrDefault(first, -1) < pMap.get(k)){
                        second = first;
                        first = k;
                    }
                    else if(pMap.getOrDefault(first, -1) == pMap.get(k)){
                        if(first > k){
                            second = first;
                            first = k;
                        }
                    }
                    else if(pMap.getOrDefault(second, -1) < pMap.get(k)){
                        second = k;
                    }
                    else if(pMap.getOrDefault(second, -1) == pMap.get(k)){
                        if(k < second) {
                            second = k;
                        }
                    }
                    //모두 같은 경우
                    else if(pMap.getOrDefault(first, -1) == pMap.get(k) && pMap.getOrDefault(second, -1) == pMap.get(k)){

                    }
                }
            }
            if(first != -1){
                anserArr.add(first);
                if(second != -1){
                    anserArr.add(second);
                }
            }
        }
        int[] answer = new int[anserArr.size()];

        for(int i = 0; i < anserArr.size(); i ++){
            answer[i] = (int)anserArr.get(i);
        }
        return answer;
    }
}
 */
