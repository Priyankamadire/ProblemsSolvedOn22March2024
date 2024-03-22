
/*Given a non-negative integer num, Return its encoding string.
The encoding is done by converting the integer to a string using a secret function that 
you should deduce from the following table:
N f(n)
0 “ ”
1 “0”
2 “1”
3 “00”
4 “01”
5 “10”
6 “11”
7 “000”
Example 1:
Input: num = 23
Output: “1000”
Example 2:
Input: num = 107
Output: “101100”
If n is 0, then f(n) is "". If 1 <= n < 3, then f(n) is a binary string with length 1. If 3
<= n < 7, then f(n) is a binary string with length 2. If 7 <= n < 15, then `f(n) is a 
binary string with length 3.
Procedure
1. For the given number num, obtain the number of bits bits for number num + 1, 
where the number of bits means the number of bits remaining after removing 
leading zeros.
2. Calculate difference as the difference between num + 1 and 2 ^ bits, and return 
the binary representation of difference

TESTCASES
-----------------------------
case=1
input=23
output=1000

case=2
input=107
output=101100*/
import java.util.*;

public class EncodeNumber {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(solve(n));
    }

    public static String solve(int n) {
        n++;
        int bits = (int) (Math.log(n) / Math.log(2));
        int difference = n - (int) Math.pow(2, bits);
        String encodeStr = binary(difference, bits);
        return encodeStr;
    }

    public static String binary(int num, int bits) {
        String str = "";
        for (int i = 0; i < bits; i++) {
            int remainder = num % 2;
            str = remainder + str;
            num /= 2;
        }
        return str;
    }
}