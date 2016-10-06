import java.util.ArrayList;

/**
 * Created by chhunchha on 10/5/16.
 */
public class SmallestDiff {

    public static void print_matrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void findSmallestDiff(int[] a, int[] b) {

        int[][] diff_matrix = new int[b.length][a.length];
        int rows = b.length;
        int cols = a.length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                diff_matrix[i][j] = Math.abs(b[i] - a[j]);
            }
        }

      //  print_matrix(diff_matrix);

        ArrayList<Integer> diff_elements = new ArrayList<>();

        int smallest_diff = 0;
        int last_element_row = rows - 1;
        for(int col = cols - 1; col >= 0; col--) {

            int min = diff_matrix[last_element_row][col];
            int min_row = last_element_row;
            for(int row = last_element_row ; row >= col ; row--) {
                if(min > diff_matrix[row][col]) {
                    min = diff_matrix[row][col];
                    min_row = row;
                }
            }

            diff_elements.add(b[min_row]);
            smallest_diff += min;
            last_element_row = min_row - 1;
        }

        System.out.println(diff_elements.toString());
        System.out.println("Min diff: " + smallest_diff);

        int top_down_smallest_diff = 0;
        last_element_row = 0;
        for(int col = 0; col < cols ; col++) {

            int min = diff_matrix[last_element_row][col];
            int min_row = last_element_row;
            for(int row = last_element_row ; row <= rows - (cols - col) ; row++) {
                if(min > diff_matrix[row][col]) {
                    min = diff_matrix[row][col];
                    min_row = row;
                }
            }

            diff_elements.add(b[min_row]);
            top_down_smallest_diff += min;
            last_element_row = min_row + 1;
        }

        System.out.println(diff_elements.toString());
        System.out.println("Min diff: " + top_down_smallest_diff);


    }

    //https://en.wikipedia.org/wiki/Dynamic_time_warping
    public static int closestSequence2UsingDTW(int a[], int b[]) {
        int rows = b.length + 1;
        int cols = a.length + 1;
        int[][] DTW = new int[rows][cols];

        for(int i = 0; i < rows; i++) {

                DTW[i][0] = Integer.MAX_VALUE;
        }

        for(int j = 0; j < cols; j++) {

            DTW[0][j] = Integer.MAX_VALUE;
        }
        print_matrix(DTW);

        DTW[0][0] = 0;

        for(int row = 1; row <= rows; row++) {
            for(int col = 1; col <= cols; col++) {
                int diff = Math.abs(b[row-1] - a[col-1]);
                DTW[row][col] = diff + Math.min(Math.min(DTW[row-1][col], DTW[row][col-1]), DTW[row-1][col-1]);
            }
        }

        return DTW[rows][cols];

    }


    public static void main(String[] args) {
        int[] a;
        int[] b;


//        a = new int[] {2, 4, 6};
//        b = new int[] {4, 1, 0, 9, 2, 4, 5};

//        a = new int[] {1, 2, 1, 2, 1, 2};
//        b = new int[] {3, 0, 0, 3, 0, 3, 3, 0, 0};

//        a = new int[] {1,3,5};
//        b = new int[] {5,3,1,5,3,0};

//        a = new int[] {1, 2, 6};
//        b = new int[] {0, 1, 7, 8, 9};

        a = new int[] { 10, 20, 30};
        b = new int[] { 1,18,17,25,28,31};

//        a = new int[]{-26, -35, 44, 23, 7, -40, -14, 18, 39, -12, -22, -5, 4, 10, 0, -11, 45, -16, 2, 46, -45, 2, -3, -50, -17, 49, 47, -15, 49, -15, 16, 43, 33, 22, -34, 48, -41, 12, 19, -17, 31, -46, 38, -21, 16, 3, -43, -50, 4, 7};
//        b = new int[]{18, 16, -22, 4, -5, -46, -43, 28, 50, -47, 31, -41, 35, -6, -20, -33, 10, 34, -7, -46, 0, 35, 29, 22, 19, -48, -4, 10, -41, 26, -33, 45, -2, 24, 4, 39, -2, -42, 41, 18, -28, 28, -44, 19, 34, 41, 33, -27, -26, 41};
//        findSmallestDiff(a, b);

        System.out.println(closestSequence2UsingDTW(a, b));

    }
}
