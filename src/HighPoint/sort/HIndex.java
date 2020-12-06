package HighPoint.sort;
/*
출처: https://programmers.co.kr/learn/courses/30/lessons/42747
문제 설명>>>
H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
위키백과1에 따르면, H-Index는 다음과 같이 구합니다.
어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index입니다.
어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때, 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
* 제한
-과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
-논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
*/

import java.util.Arrays;

public class HIndex {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations); //오름차순으로 정렬
        for(int i = 0; i < citations.length; i ++){
            // 양끝에서 좁혀 가면서 중간지점 찾기
           // hIndex는 점점 줄어들고 원소의 값을 커지므로 중간 값을 찾기 위함
            int hIndex = citations.length - i;
            if(hIndex <= citations[i] ){ //원소의 값과 비교하면서 줄어들고 있는 h인덱스와 같거나 작아지면 h인덱스!
                return hIndex;
            }
        }

        return answer;
    }
    public static void main(String args[]){
        HIndex phone = new HIndex();
        int[] a = {3,0,6,1,5};
        int[] b = {3,0,6,1,5,8,4};  //테스트 예시들
        System.out.println(phone.solution(a));
    }
}
