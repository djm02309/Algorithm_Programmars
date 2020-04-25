package hash;

import java.util.HashMap;
import java.util.Set;

public class Spy {
    public int solution(String[][] clothes) {
        int answer = 1;
        int answer1 = 1;
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            map.put(clothe[1], map.getOrDefault(clothe[1], 0) + 1);
        }
//       version 1 ---------------------------------------------이건 통과안됨
        for(int i = 0 ; i<map.size(); i++){
            answer = answer *( map.get(clothes[i][1]) + 1);
        }
        answer = answer-1;
        //version 2 조합 ---------------------------------------------이건 통과됨 ...왜?
        Set<String> keySet = map.keySet(); //의상종류.

        for(String key : keySet) {
            answer1 *= map.get(key)+1;
        }
        answer1 = answer1-1;

        return answer1;
    }
    public static void main(String[] args){
        Spy spy1 = new Spy();
        String[][] cl = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        String [][] cl2 = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
        String[][] cl3 = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "head"}};
        //testcase
        System.out.println(spy1.solution(cl3));
    }
}
