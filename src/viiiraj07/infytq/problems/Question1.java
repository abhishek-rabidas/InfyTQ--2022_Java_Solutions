package viiiraj07.infytq.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Question1 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String firstLine = br.readLine().trim();
        String secondLine = br.readLine().trim();

        String[] row1 = firstLine.split(",");
        String[] row2 = secondLine.split(",");

        ArrayList<String> outRow1 = new ArrayList<>();
        ArrayList<String> outRow2 = new ArrayList<>();

        for (String left : row1) {
            StringBuilder numberString = new StringBuilder();
            StringBuilder charString = new StringBuilder();
            for (char ch : left.toCharArray()) {
                if (Character.isDigit(ch)) {
                    numberString.append(ch);
                } else {
                    charString.append(ch);
                }
            }
            if (isPresent(numberString.toString(), row2)) {
                outRow1.add(numberString.toString());
                outRow2.add(charString.toString());
            } else {
                outRow1.add("NA");
                outRow2.add("NA");
            }
        }
        System.out.println(outRow1.toString().replace("[", "").replace("]", "").replace(" ", ""));
        System.out.println(outRow2.toString().replace("[", "").replace("]", "").replace(" ", ""));
    }

    public static boolean isPresent(String str, String[] row) {
        for (String s : row) {
            if (s.equals(str)) return true;
        }
        return false;
    }
}
