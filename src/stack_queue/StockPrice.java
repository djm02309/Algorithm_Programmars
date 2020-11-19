package stack_queue;
import java.util.Stack;

public class StockPrice {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i< prices.length; i++) {
            Stack<Integer> st = new Stack<>();
            for (int j = prices.length-1; j >= i+1; j--) {
                st.add(prices[j]);
            }
            int count = 0;
            int size = st.size();
            for (int j = 0; j < size; j++) {
                count++;
                if (prices[i]> st.pop()){
                    break;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String args[]){
        StockPrice sp = new StockPrice();
        int[] prices={1, 2, 3, 2, 3};

        int [] answer = sp.solution(prices);
        for(int i : answer){
            System.out.print(i+" ");
        }
    }
}
//효율성 테스트 통과못함