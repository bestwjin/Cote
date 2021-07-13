package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 이건 힙이다.
 */
public class 레벨2_힙_더맵게 {
    public static void main(String args[]) {

        int[] scoville = {1, 2, 3, 9, 10, 12}; // false
        int K = 7;

        solution(scoville, K);
    }

    // 1 4
    // 섞은 음식의 스코빌 지수 = 가장낮은값 + (두번째로 낮은값 * 2)
    public static int solution(int[] scoville, int K) {
        int answer = 0;

        // 우선순위 큐로 구현하면 낮은 숫자부터 나오기때문에 정렬을 따로 안해줘도 된다.
        // 우선순위큐로 하니까 퍼포먼스는 다 통과. 확실히 빠른가봄.
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<scoville.length; i++) {
            if(scoville[i] < K) {
                queue.offer(scoville[i]);
            } else {
                break;
            }
        }

        while(queue.size() > 1) {
            int temp = queue.poll() + (queue.poll() * 2);

            if(temp < K) {
                queue.offer(temp);
            }
            answer++;
        }

        if(answer == 0) answer = -1;

        System.out.println(answer);

        return answer;
    }
}
