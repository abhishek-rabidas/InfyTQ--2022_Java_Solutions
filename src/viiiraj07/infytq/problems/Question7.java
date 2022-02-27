package viiiraj07.infytq.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question7 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputStr = br.readLine();
        int m = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> inMatrix = new ArrayList<>();
        String[] inArr = inputStr.split(",");

        for (int i = 0; i < m; i++) {
            String input = br.readLine().trim();
            ArrayList<Integer> integers = new ArrayList<>();
            for (String w : input.split(" ")) {
                integers.add(Integer.parseInt(w));
            }
            inMatrix.add(integers);
        }

        Character[] alphabets = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int i = 0;

        ArrayList<String> replacedStrings = new ArrayList<>();

        for (String str : inArr) {
            int j = 0;
            String newStr = str.replace(str.charAt(inMatrix.get(i).get(j)), alphabets[inMatrix.get(i).get(j + 1)]);
            replacedStrings.add(newStr);
            i++;
        }

        int output = Integer.MAX_VALUE;
        String outStr = "";

        for (int index = replacedStrings.size() - 1; index >= 0; index--) {
            int curr = countConsonants(replacedStrings.get(index));

            if (output >= curr) {
                output = curr;
                outStr = replacedStrings.get(index);
            }
        }

        System.out.println(outStr);
    }

    static int countConsonants(String word) {
        int c = 0;
        for (char ch : word.toCharArray()) {
            if (!(ch == 'a' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'e')) {
                c++;
            }
        }
        return c;
    }
}
