package HighPoint.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class numberK {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> ans = new ArrayList();
        for(int i = 0; i < commands.length; i++){
            int length = commands[i][1] - commands[i][0] +1; //자른 배열의 길이
            int[] newArray =  new int[length];
            for(int j = commands[i][0]-1, k = 0; j<= commands[i][1]-1 && k <newArray.length ; j++, k++){
                //n번째 부터 n번째 까지 새로 배열 만들기 (배열은 0부터 시작하니까 -1해줘야함)
                newArray[k] = array[j];
            }
            Arrays.sort(newArray);      //오름차순으로 정렬
            ans.add(newArray[commands[i][2]-1]);    //뽑아내야하는 k번째를 arraylistdp 추가
        }
        int[] answer = new int[ans.size()];
        for(int i=0 ; i< ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        numberK k =new numberK();
        int[] answer = {};
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};
//        int[][] commands = {{1,7,3}};
        answer = k.solution(array, commands);
        for(int i=0 ; i< answer.length; i++){
            System.out.print(answer[i]);
        }
    }
}
