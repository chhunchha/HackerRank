import java.util.*;

/**
 * Created by chhunchha on 10/1/16.
 */
public class BiggestRegion {

    // Just helper function
    public static void print_matrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    // to check if cell is not out of bound
    public static boolean isSafe(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    // depth first search ,
    // general idea - there are 8 sourrounding cells which is connected,
    // check if any of them is not yet visited and is connected, if so go and visit those
    // no_of_region is getting increasesed in main loop whenever it finds complete disconnected/new region
    // managing hashmap with region and no of nodes against it, increasing count when you visit new safe node.
    // safe node = not out of bound and has value 1 and not yet visited
    public static void DFS(int[][] matrix, int i, int j, int[][] visited_matrix, int no_of_regions, HashMap<Integer, Integer> region_node_count_map) {

        visited_matrix[i][j] = no_of_regions;
        region_node_count_map.put(no_of_regions, region_node_count_map.get(no_of_regions) + 1);

        // to identify which all cells are neighbour
        int[] neighbour_row = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] neighbour_col = new int[]{-1, 1, 1, -1, 1, -1, 0, 1};

        for(int k = 0; k < neighbour_col.length; k++) {
            int n_i = i + neighbour_row[k];
            int n_j = j + neighbour_col[k];

            if(isSafe(n_i, n_j, matrix.length, matrix[0].length) && visited_matrix[n_i][n_j] == 0 && matrix[n_i][n_j] == 1)
                DFS(matrix, n_i, n_j, visited_matrix, no_of_regions, region_node_count_map);
        }
    }

    public static int getBiggestRegion(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] visited_matrix = new int[m][n];
        HashMap<Integer, Integer> region_node_count_map = new HashMap<Integer, Integer>();
        int no_of_regions = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1 &&  visited_matrix[i][j] == 0) {
                    region_node_count_map.put(no_of_regions, 0);
                    DFS(matrix, i, j, visited_matrix, no_of_regions, region_node_count_map);
                    no_of_regions++;
                }
            }
        }

        print_matrix(matrix);
        System.out.println();
        print_matrix(visited_matrix);

        // java 8 only
        // java 7 - write method to find max value from hashmap by traversing all keysets
        //getting max value from collection
        return Collections.max(region_node_count_map.entrySet(), Map.Entry.comparingByValue()).getValue();

    }

    public static void main(String[] args) {
        int grid[][] = new int[][]{{ 1, 1, 1}, {0, 1, 0}, {1, 1, 1}, {1, 1, 1}};
        System.out.println(grid.length);
        System.out.println(grid[0].length);
        System.out.println(getBiggestRegion(grid));

        grid = new int[][]{
                {0,1,0,0,0,0,1,1,0},
                {1,1,0,0,1,0,0,0,1},
                {0,0,0,0,1,0,1,0,0},
                {0,1,1,1,0,1,0,1,1},
                {0,1,1,1,0,0,1,1,0},
                {0,1,0,1,1,0,1,1,0},
                {0,1,0,0,1,1,0,1,1},
                {1,0,1,1,1,1,0,0,0}
        };

        //ans 29

        System.out.println(getBiggestRegion(grid));

    }
}