package HighPoint.fullSearch;
/*문제 설명
숫자 야구 게임이란 2명이 서로가 생각한 숫자를 맞추는 게임입니다. 게임해보기

각자 서로 다른 1~9까지 3자리 임의의 숫자를 정한 뒤 서로에게 3자리의 숫자를 불러서 결과를 확인합니다. 그리고 그 결과를 토대로 상대가 정한 숫자를 예상한 뒤 맞힙니다.

* 숫자는 맞지만, 위치가 틀렸을 때는 볼
* 숫자와 위치가 모두 맞을 때는 스트라이크
* 숫자와 위치가 모두 틀렸을 때는 아웃
예를 들어, 아래의 경우가 있으면

A : 123
B : 1스트라이크 1볼.
A : 356
B : 1스트라이크 0볼.
A : 327
B : 2스트라이크 0볼.
A : 489
B : 0스트라이크 1볼.
이때 가능한 답은 324와 328 두 가지입니다.

질문한 세 자리의 수, 스트라이크의 수, 볼의 수를 담은 2차원 배열 baseball이 매개변수로 주어질 때, 가능한 답의 개수를 return 하도록 solution 함수를 작성해주세요.

*제한사항
-질문의 수는 1 이상 100 이하의 자연수입니다.
-baseball의 각 행은 [세 자리의 수, 스트라이크의 수, 볼의 수] 를 담고 있습니다.

*입출력 예
baseball	| return
[[123, 1, 1], [356, 1, 0], [327, 2, 0], [489, 0, 1]] | 2
*/
import java.util.Set;
import java.util.TreeSet;

public class BaseballGame {
    Set<Integer> set = new TreeSet<Integer>();
    public int solution(int[][] baseball) {

        int[] arr = {1,2,3,4,5,6,7,8,9};
        boolean[] visited = new boolean[arr.length];
        //중복되지 않은 수로 만들 수 있는 모든 수
        int[] output = new int[3];
        perm(arr, output, visited, 0, baseball);


        return set.size();
    }
    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int[][] baseball) {
        if (depth == 3) {
            int sum = 0;
            //여기서 숫자 3개 나옴
            int count = 0;
            for(int i = 0; i < baseball.length; i++){
//                int now = baseball[i][0];
                int strike = getStrike(baseball[i][0],output[0],output[1],output[2]);
                int ball = getBall(baseball[i][0],output[0],output[1],output[2]);
                if(strike == baseball[i][1] && ball == baseball[i][2]){
                    count++;
                }
            }

            if(count == baseball.length) {
                for (int i = output.length-1, dan = 1; i >= 0; i--, dan *= 10) {
                    sum += output[i] * dan;

                }
                set.add(sum);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, baseball);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
            }
        }
    }
    public int getStrike(int now, int a,int b,int c){
        int num1 = now/100;
        int num2 = (now%100)/10;
        int num3 = (now%100)%10;

        int ret = 0;
        if (a == num1) {
            ++ret;
        }
        if (b == num2) {
            ++ret;
        }
        if (c == num3) {
            ++ret;
        }

        return ret;
    }
    public int getBall(int now, int a,int b,int c){
        int num1 = now/100;
        int num2 = (now%100)/10;
        int num3 = (now%100)%10;

        int ret = 0;
        if (a == num2 || a == num3) {
            ++ret;
        }
        if (b == num1 || b == num3) {
            ++ret;
        }
        if (c == num1 || c == num2) {
            ++ret;
        }

        return ret;

    }
    public static void main(String[] args){
        int[][] arr = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        BaseballGame base = new BaseballGame();
        base.solution(arr);
    }
}