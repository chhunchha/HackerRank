/**
 * Created by chhunchha on 10/2/16.
 */
public class CommonSubString {

    public static void print_matrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String backTrackForSubstring(String a, String b, int[][] matrix, int i, int j) {

        if(i-1 == -1 || j-1 == -1)
            return "";

        if(a.charAt(i-1) == b.charAt(j-1)) {
            return backTrackForSubstring(a, b, matrix, i-1, j-1).concat(a.charAt(i-1)+"");
        } else {
            if (matrix[i][j-1] > matrix[i-1][j])
                return backTrackForSubstring(a, b, matrix, i, j-1);
            else
                return backTrackForSubstring(a, b, matrix, i-1, j);
        }
    }

    // creating matrix with first row and col with 0's
    // will help in avoiding check for going out of bound
    // need to take care of mismatch between index of character in string and associated row/col in matrix
    public static int findCommonLongestSubStringLength(String a, String b) {
        int m = a.length()+1;
        int n = b.length()+1;
        int[][] matrix = new int[m][n];

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = matrix[i-1][j] > matrix[i][j-1] ? matrix[i-1][j] : matrix[i][j-1];
                }
            }
        }

        print_matrix(matrix);

        System.out.println("Common string: " + backTrackForSubstring(a, b , matrix, m-1, n-1));
        return matrix[m-1][n-1];

    }

    public static void main(String[] args) {
        String a = "abcdefgac";
        String b = "abdefcgh";
        System.out.println("longest substring can be of characters: " + findCommonLongestSubStringLength(a, b));
    }
}
