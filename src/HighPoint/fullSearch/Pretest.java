package HighPoint.fullSearch;

import java.util.ArrayList;
import java.util.Arrays;

public class Pretest {
    public int[] solution(int[] answers) {
        int[] answer ;
        int[] student1 = {1,2,3,4,5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] countAnswer= {0,0,0};
        int[] sorting;
        for(int i = 0; i < answers.length; i++){
            if(answers[i] == student1[i%5]){
                countAnswer[0]++;
            }
            if(answers[i] == student2[i%8]){
                countAnswer[1]++;
            }
            if(answers[i] == student3[i %10]){
                countAnswer[2]++;
            }
        }
        sorting = countAnswer.clone();
        Arrays.sort(sorting);
        int max = sorting[countAnswer.length-1];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i <countAnswer.length; i ++){
            if(countAnswer[i] == max){
                list.add(i+1);
            }
        }
        answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
    public static void main(String args[]){
        Pretest test = new Pretest();
        int[] a = {1,2,3,4,5};
        int[] b = {1,3,2,4,2};  //테스트 예시들
        int[] result = test.solution(a);
        for(int i = 0; i <result.length; i ++){
            System.out.println(result[i]);
        }

    }
}
