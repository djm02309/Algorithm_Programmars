package ETC;
//https://programmers.co.kr/learn/courses/30/lessons/60058

import java.util.Stack;

public class CheckBracket {
    public String solution(String p) {
        if(p.isEmpty()){
            return p;
        }
        boolean correct = isCorrect(p);
        return "";
    }
    ///균형잡인 문자열로 나누기
    boolean isCorrect(String w){
        boolean returnValue = true;
        int left=0, right = 0;
        Stack<Character> stack = new Stack();

        for(int i =0; i < w.length(); i++){
            if(w.charAt(i)=='('){
                left++;
                stack.push('(');
            }
            else{
                right++;
                if(stack.empty()){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
            if(left==right){
                return returnValue;
            }
        }

        return true;
    }
    String makeCorrect(String w){
        if(w.isEmpty()){
            return "";
        }
        else{
            int divid = division(w);
            return "";
        }
    }
    ///균형잡인 문자열로 나누기
    int division(String w){
        return 0;
    }
}
