package programmers;

import java.util.Arrays;

/**
 * 레벨 2치고 쉬웠음.
 * 해시는 Key-value쌍으로 데이터를 저장하는 자료구조다.
 * 따라서 맵을 써서 풀 수 있는 문제가 많다. but 이문제는 그냥 배열로도 처리가능.
 * 문제 비중이 높다.
 */
public class 레벨2_힙_더맵게 {
    public static void main(String args[]) {

        String[] phone_book = {"119", "97674223", "1195524421"}; // false
        // String[] phone_book = {"123","456","789"}; // true
        // String[] phone_book = {"12","123","1235","567","88"}; // false

        solution(phone_book);
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;

        // parallelSort는 병렬처리해서 빠르다. 그러나 항목이 5000개는 넘어가야 빠르다. 즉 별 의미는 없다.
        Arrays.parallelSort(phone_book);

        // 접두어만 검사하므로 앞자리순으로 정렬하는것이 빠르다. 스트링을 앞자리순으로
        // 정리하면 길이가 짧은것이 먼저 정렬되므로 검사하기 쉬우며
        // 같은 이유로 뒤에서부터 앞으로 검사하는게 더 빠르다.
        Arrays.sort(phone_book);
        for(String a:phone_book) System.out.print(a + " ");

        for(int i=phone_book.length-1; i>0; i--) {
            if(phone_book[i].startsWith(phone_book[i-1])) {
                answer = false;
                break;
            }
        }
        System.out.println(answer);

        return answer;
    }
}

/**
 * 전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
 * 전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.
 *
 * 구조대 : 119
 * 박준영 : 97 674 223
 * 지영석 : 11 9552 4421
 * 전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때, 어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * phone_book의 길이는 1 이상 1,000,000 이하입니다.
 * 각 전화번호의 길이는 1 이상 20 이하입니다.
 * 같은 전화번호가 중복해서 들어있지 않습니다.
 * 입출력 예제
 * phone_book	return
 * ["119", "97674223", "1195524421"]	false
 * ["123","456","789"]	true
 * ["12","123","1235","567","88"]	false
 * 입출력 예 설명
 * 입출력 예 #1
 * 앞에서 설명한 예와 같습니다.
 *
 * 입출력 예 #2
 * 한 번호가 다른 번호의 접두사인 경우가 없으므로, 답은 true입니다.
 *
 * 입출력 예 #3
 * 첫 번째 전화번호, “12”가 두 번째 전화번호 “123”의 접두사입니다. 따라서 답은 false입니다.
 *
 * 알림
 *
 */