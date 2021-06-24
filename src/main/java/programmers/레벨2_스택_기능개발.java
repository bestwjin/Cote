package programmers;

import java.util.ArrayList;
import java.util.Stack;

public class 레벨2_스택_기능개발 {
    public static void main(String args[]) {
        int[] progresses = {1,2,3,1};
        int[] speeds = 	{1,100,1,1};
/*        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = 	{1, 1, 1, 1, 1, 1};*/
        solution(progresses, speeds);
        // [1, 2, 3, 2, 3]
        // [4, 3, 1, 1, 0]

    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> answer_list = new ArrayList<>();

        int answeridx = 0;
        for(int i=0;i<progresses.length; i++) {
            int lastdays = (int) Math.ceil((100-progresses[i])/(double)speeds[i]);
            System.out.println(lastdays);

            if(!stack.isEmpty() && stack.peek() < lastdays) {
                answer_list.add(stack.size());
                stack.clear();
            }

            stack.push(lastdays);
        }

        answer_list.add(stack.size());

        answer = new int[answer_list.size()];

        int idx = 0;
        for(int a:answer_list) {
            System.out.print(a + " ");
            answer[idx] = a;
            idx++;
        }

        return answer;
    }
}