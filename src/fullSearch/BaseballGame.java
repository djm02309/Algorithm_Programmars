package fullSearch;

import java.util.Set;
import java.util.TreeSet;

public class BaseballGame {
    Set<Integer> set = new TreeSet<Integer>();
    public int solution(int[][] baseball) {
        int answer = 0;
        int[] arr = {1,2,3,4,5,6,7,8,9};
        boolean[] visited = new boolean[arr.length];
        //중복되지 않은 수로 만들 수 있는 모든 수
        int[] output = new int[3];
        perm(arr, output, visited, 0, arr.length,3);


        return answer;
    }
    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;
            //여기서 숫자 3개 나옴
            for (int i = output.length-1, dan = 1; i >= 0; i--, dan *= 10) {
                sum += output[i] * dan;
            }
            set.add(sum);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (visited[i] != true) {
                visited[i] = true;
                output[depth] = arr[i];
                perm(arr, output, visited, depth + 1, n, r);
                output[depth] = 0; // 이 줄은 없어도 됨
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args){
        int[][] arr = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        BaseballGame base = new BaseballGame();
        base.solution(arr);
    }
}
