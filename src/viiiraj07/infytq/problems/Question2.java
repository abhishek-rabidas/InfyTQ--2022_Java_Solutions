package viiiraj07.infytq.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Question2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> outnum = new ArrayList<>();
        String input = br.readLine().trim();
        String[] arr = input.split(",");

        for (String str : arr) {
            if (str.contains("6")) {
                String newStr = str.replace("6", "9");
                StringBuilder reversedNum = new StringBuilder(newStr).reverse();
                outnum.add(Integer.parseInt(reversedNum.toString()));
            } else outnum.add(Integer.parseInt(str));
        }

        int sum = 0;
        for (int x : outnum) {
            sum += x;
        }

        float avg = sum / outnum.size();

        System.out.println(avg);
    }
}
