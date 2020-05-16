package fullSearch;
/*
출처: https://programmers.co.kr/learn/courses/30/lessons/42839
* */

import java.util.ArrayList;

public class FindSosu {
    ArrayList<Integer> list = new ArrayList();

    public int solution(String numbers) {
        int answer = 0;
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        boolean[] visited = new boolean[arr.length];

        for (int i = 1; i <= numbers.length(); i++) {  //만들 수 있는 모든 수 만들기
            int[] output = new int[i];
            perm(arr, output, visited, 0, numbers.length(), i);
        }
        answer = isPrime(list);
        return answer;
    }

    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;
            for (int i = output.length-1, dan = 1; i >= 0; i--, dan *= 10) {
                sum += output[i] * dan;
                //System.out.print(output[i]);
            }
            //System.out.println();
            list.add(sum);

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

    public int isPrime(ArrayList listA) {
        ArrayList result = new ArrayList();
        for(int k =0; k < listA.size(); k++) {
            int n = (int) listA.get(k);
            for (int i = 2; i <= n; i++) {
                boolean isPrime = true;
                // 초기 값
                // for(int j=2; j<=i/2; j++) {
                for (int j = 2; j * j <= i; j++) {
                    if (i % j == 0) {
                        // 소수가 아니다.
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    result.add(n);
                }
            }
        }
        return result.size();
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        FindSosu sosu = new FindSosu();
        sosu.solution("17");
    }
}
