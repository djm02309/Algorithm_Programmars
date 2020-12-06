package HighPoint.fullSearch;
/*
출처: https://programmers.co.kr/learn/courses/30/lessons/42839
* */

import java.util.*;

public class FindSosu {
//    ArrayList<Integer> list = new ArrayList();
    Set<Integer> set = new TreeSet<Integer>();
    static int AAA=0;
    public int solution(String numbers) {
        int answer;
        int[] arr = new int[numbers.length()];
        for (int i = 0; i < numbers.length(); i++) {
            arr[i] = numbers.charAt(i) - '0';
        }
        boolean[] visited = new boolean[arr.length];

        for (int i = 1; i <= numbers.length(); i++) {  //만들 수 있는 모든 수 만들기
            int[] output = new int[i];
            perm(arr, output, visited, 0, numbers.length(), i);
        }
        answer = isPrime(set);
        return answer;
    }

    public void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if (depth == r) {
            int sum = 0;
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

    public int isPrime(Set listA) {
//        ArrayList result = new ArrayList();

        Iterator it = set.iterator();
        while(it.hasNext()){
            int n = (int) it.next();
            if(n > 1) {
                boolean isPrime = true;
                    for (int j = 2; (j * j) <= n; j++) {
                        if (n % j == 0) {
                            // 소수가 아니다.
                            isPrime = false;
                            break;
                        }
                    }
                if (isPrime) {
//                    result.add(n);
                    AAA++;
                }
            }
        }
        return AAA;
    }
    public static void main(String[] args){
        int[] arr = {1,2,3,4};
        FindSosu sosu = new FindSosu();
        sosu.solution("011");
    }
}
