package HighPoint.BFSDFS;

public class FindingTargetNum {
    static int answer =0;
    public int solution(int[] numbers, int target) {
        dfs(numbers,target,0);
        return answer;
    }

    public void dfs(int[] numbers, int target, int node){
//        int sum = 0;
        if(node == numbers.length){ //끝까지 다 돌았으면
            int sum = 0;
            for(int num : numbers){ // 모든 숫자 반복
                sum+= num;   //총합 구하기
            }
            if(sum == target){ // 총합이 타겟이면 갯수 증가
                answer++;
            }
        }
        else{ //하나씩 돌기
            numbers[node]*=1;
            dfs(numbers,target,node+1);
            numbers[node]*= -1;
            dfs(numbers,target,node+1);
        }

    }
}
