package leveltest_1;

import java.util.ArrayList;
import java.util.Arrays;

public class ssssssss {
    class Solution {
        public int[] solution(int[] arr, int divisor) {
            int[] answer = {-1};
            ArrayList<Integer> nums = new ArrayList<>();
            for(int i = 0; i< arr.length; i++){
                if(arr[i] % divisor == 0){
                    nums.add(arr[i]);
                }
            }
            if(nums.size() != 0){
                answer = new int[nums.size()];
                for(int i = 0; i< nums.size(); i++){
                    answer[i] = nums.get(i);
                }
                Arrays.sort(answer);
            }

            return answer;
        }
    }
}
