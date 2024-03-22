
/*We are given an m x n binary matrix grid. 
In one operation, you can choose any row or column and flip each value in that row 
or column (i.e., changing all 0's to 1's, and all 1's to 0's). 
Return true if it is possible to remove all 1’s from the grid using any number of 
operations or false otherwise. 
Input: grid = [[0,1,0],[1,0,1],[0,1,0]]
Output: true
Explanation: One possible way to remove all 1's from grid is to: - Flip the middle row - Flip the middle column
3. Remove All Ones with Row and Column Flips

TESTCASES:
CASE=1
INPUT =3
0 1 0
1 0 1
0 1 0
OUTPUT=true
*/
import java.util.*;

public class RemoveAllOneswithFlips {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int mat[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.print(solve(mat));
    }

    public static boolean solve(int mat[][]) {
        for (int i = 1; i < mat.length; i++) {
            if (!help(mat[0], mat[i])) {
                return false;
            }
        }
        return true;
    }

    public static boolean help(int arr[], int brr[]) {
        boolean a = true;
        boolean b = true;
        for (int i = 0; i < arr.length; i++) {
            a = (a) && (arr[i] == brr[i]);
            b = (b) && (arr[i] != brr[i]);
        }
        return a || b;
    }
}