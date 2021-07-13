import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        int[] people = {10,20,30,40,50,60,70,80,90};
        int limit = 100;

        solution(people, limit);
    }

    // 구명보트 한번에 2명씩만 탈 수 있음. 무게제한도 있음 limit
    // 구명보트를 최대한 적게 사용하여 다 구출할 수 있는 최소수를 구해라.
    // 탐욕법이니까 탐욕적으로.
    public static int solution(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        for(int i=0; i<people.length; i++) {

        }

        return answer;
    }
}
