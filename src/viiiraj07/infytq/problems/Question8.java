package viiiraj07.infytq.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Character>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            String[] inputs = s.split(",");
            ArrayList<Character> row = new ArrayList<>();
            for (String x : inputs) {
                char ch = x.charAt(0);
                row.add(ch);
            }
            matrix.add(row);
        }

        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(ArrayList<ArrayList<Character>> matrix) {
        int rows = matrix.size(), cols = rows > 0 ? matrix.get(0).size() : 0;
        int[][] dp = new int[rows + 1][cols + 1];
        int maxsqlen = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix.get(i - 1).get(j - 1) == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxsqlen = Math.max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen;
    }
}
