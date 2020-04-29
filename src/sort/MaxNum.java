package sort;

import java.util.*;

public class MaxNum {

    public String solution(int[] numbers) {
        String answer = "";
        ArrayList<String> temp = new ArrayList<>();

        for(int i = 0; i < numbers.length; i ++){
            temp.add(Integer.toString(numbers[i]));
        }
        Collections.sort(temp, new Comparator<String>() {
            //두 string 연결해서 더 큰거를 기준으로 정렬
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        //
        if (temp.get(0).equals("0")) return "0";

        for (int i =0; i< temp.size(); i++){
            answer += temp.get(i);
        }
        return answer;
    }
    public static void main(String[] args){
        MaxNum max = new MaxNum();
        int[] numbers = {6,10,2};
        int[] numbers2 = {3,30,34,5,9,0000};
        System.out.println(max.solution(numbers2));
    }
}
/**
 * public String solution(int[] numbers) {
 *         //다읽어와서 한자리씩 자르고 큰수로 정렬해서 리턴
 *         String input ="";
 *         int[] divNum = new int[numbers.length];
 *         ArrayList temp = new ArrayList();
 *         for (int i =0; i< numbers.length; i++){
 *             if(numbers[i] / 10 != 0) {
 *                 divNum[i] = numbers[i] / 10;  //몫으로 비교
 *             }
 *             else{
 *                 divNum[i] = numbers[i] % 10;
 *             }
 *             temp.add(divNum[i]);
 *         }
 *         for (int i =0; i< divNum.length; i++){
 *
 *             Math.max(divNum[i], divNum[i+1]);
 *             input += Integer.toString(numbers[i]);
 *         }
 *         Integer [] arr = new Integer[input.length()];
 *         for(int i =0; i< input.length(); i++){
 *             arr[i] = Integer.parseInt(Character.toString(input.charAt(i)));
 *         }
 *         Arrays.sort(arr, Collections.reverseOrder());
 *         String answer = "";
 *         for(int i =0; i< arr.length; i++){
 *             answer += arr[i];
 *         }
 *         return answer;
 *     }
 * */