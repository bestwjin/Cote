package leetcode;

/**
 * 풀지 못함. 무슨소린지 모르겟다.
 */
public class MyAtoi {
    public static void main(String[] args) {
        myAtoi("+-12");
    }

    public static int myAtoi(String s) {

        boolean isNegative = false;
        boolean isPositive = false;

        int result = 0;
        String temp = "";

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '-') {
                isNegative = true;
                continue;
            }

            if(ch == '+') {
                isPositive = true;
                continue;
            }
            if(ch == ' ') continue;

            if(isNegative && isPositive) {
                result = 0;
                break;
            }


            if((ch < 48 || ch > 57) && ch != '.') {

                if(i==0) {
                    result = 0;
                    break;
                } else {
                    continue;
                }
            }

            temp += String.valueOf(ch);
        }

        if(temp.trim().equals("")) temp = "0";
        else if(isNegative) {
            temp = "-"+temp;
        }

        // integer clamp;
        double tempdb = Double.parseDouble(temp);

        if(tempdb < Integer.MIN_VALUE) {
            result = Integer.MIN_VALUE;
        } else {
            result = (int)tempdb;
        }

        System.out.println(result);

        return result;
    }
}
