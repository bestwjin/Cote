package programmers;

import java.util.*;

public class 레벨2_스택_주식가격 {
    public static void main(String args[]) {
        int[] prices = {1, 2, 3, 2, 3};
        solution(prices);
        // [1, 2, 3, 2, 3]
        // [4, 3, 1, 1, 0]
    }

    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<prices.length-1; i++) {
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        while(!stack.isEmpty()) {
            answer[stack.peek()]= prices.length - stack.peek() -1;
            stack.pop();
        }

        return answer;
    }
}