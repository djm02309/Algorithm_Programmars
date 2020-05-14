package fullSearch;
/*
출처: https://programmers.co.kr/learn/courses/30/lessons/42839
* */

public class FindSosu {
    public int solution(String numbers) {
        int answer = 0;
        return answer;
    }

    public int[] isPrime (int n) {
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
                // 소수 일때만 값을 출력
                System.out.println(i + " ");
            }
        }
    }
}
