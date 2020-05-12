package leveltest_1;

public class problem2 {
    public int solution(String dartResult) {
        int answer = 0;
        char[] array = dartResult.toCharArray();
        int[] intArr = new int[array.length];
        for(int i = 0; i < array.length; ){  //몇번 반복할지 3으로 나눠서 더하기1
            int num = 0 ;
            if((array[i] - '0') >0 || (array[i] - '0') <10){
                num = array[i] - '0'; //점수
                i++;
            }
            if(array[i]=='S'||array[i]=='D'||array[i]=='T'){
                switch (array[i]){
                    case 'S' :
                        num = num * 1;
                    case 'D' :
                        num = num * num ; //제곱
                    case 'T' :
                        num = num * num * num; //세제곱
                }
                i++;
            }
            if(array[i]=='*' || array[i]=='#'){// 옵션이면
                switch (array[i]){
                    case '*' :
                        if(i != 0) {
                            intArr[i-1] = intArr[i-1] * 2;
                        };
                        num = num * 2;
                    case '#' : num =  num * -1 ; //제곱

                }
                i++;
            }

            intArr[i] =  num;
        }

        for(int i = 0; i< intArr.length; i++){
            answer += intArr[i];
        }
        return answer;
    }
    public static void main(String[] args){
        problem2 sol = new problem2();
        String a="1S2D*3T";
        System.out.println(sol.solution(a));
    }
}
