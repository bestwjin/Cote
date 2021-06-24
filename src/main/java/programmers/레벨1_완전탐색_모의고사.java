package programmers;

import java.util.*;

// 완전탐색 -> 무식하게 풀면됨.
// 그냥 순차적으로 탐색.
public class 레벨1_완전탐색_모의고사 {

    static Map<Integer, Integer> hmap = new HashMap<>();
    static int supos[][] = {{1,2,3,4,5}, {2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};

    public static void main(String args[]) {
        solution(new int[]{2,1,2,3,2,4,2,5});
    }

    public static int[] solution(int[] answers) {

        int[] answer = {};

        for(int i=0; i<answers.length; i++) {
            // a체크
            if(checkAnswer(0, i, answers[i])) addToMap(0);
            if(checkAnswer(1, i, answers[i])) addToMap(1);
            if(checkAnswer(2, i, answers[i])) addToMap(2);
        }

        // 방법3
        // value순으로 정렬
        List<Integer> listKeySet = new ArrayList<>(hmap.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (hmap.get(value2).compareTo(hmap.get(value1))));

        int idx = 0;
        int maxVal = 0;
        for(int key : listKeySet) {
            if(idx == 0) {
                maxVal = hmap.get(key);
            }
            if (maxVal > hmap.get(key)) {
                hmap.remove(key, hmap.get(key));
            }
            idx++;
        }

        answer = new int[hmap.size()];
        idx = 0;
        for(int key:hmap.keySet()) {
            answer[idx] = key+1;
            idx++;
        }

        Arrays.sort(answer);

        for(int a:answer) System.out.println(a);

        return answer;
    }

    public static boolean checkAnswer(int cls, int idx, int num) {
        int[] temp = supos[cls];
        boolean result = false;

        if(idx <= temp.length-1) {
            if(temp[idx] == num) result = true;
        } else {
            if(temp[idx%temp.length] == num) result = true;
        }

        return result;
    }

    public static void addToMap(int cls) {
        if(hmap.containsKey(cls)) {
            hmap.put(cls, hmap.get(cls) + 1);
        } else {
            hmap.put(cls, 1);
        }
    }
}

/**
 * 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
 *
 * 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
 * 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
 * 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
 *
 * 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 조건
 * 시험은 최대 10,000 문제로 구성되어있습니다.
 * 문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
 * 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
 * 입출력 예
 * answers	return
 * [1,2,3,4,5]	[1]
 * [1,3,2,4,2]	[1,2,3]
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 수포자 1은 모든 문제를 맞혔습니다.
 * 수포자 2는 모든 문제를 틀렸습니다.
 * 수포자 3은 모든 문제를 틀렸습니다.
 * 따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
 *
 * 입출력 예 #2
 *
 * 모든 사람이 2문제씩을 맞췄습니다.
 */