package viiiraj07.infytq.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Question4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        sc.close();
        String[] nums = input.split(",");

        ArrayList<Integer> arrangedArray = new ArrayList<>();

        for (String num : nums) {
            if (num.equals("")) continue;
            int n = Integer.parseInt(num.trim());
            if (n < 0) {
                arrangedArray.add(n);
            }
        }

        for (String num : nums) {
            int n = Integer.parseInt(num.trim());
            if (n >= 0) {
                arrangedArray.add(n);
            }
        }

        List<Integer> outarr = new ArrayList<>();

        for (int i = 0; i < arrangedArray.size() - 1; i++) {
            int num1 = arrangedArray.get(i);
            int num2 = arrangedArray.get(i + 1);

            int diff = num2 - num1;

            if (diff > 1) {
                int sum = 0;
                int low = 0;
                int high = 0;
                if (num1 > num2) {
                    low = num2;
                    high = num1;
                } else {
                    low = num1;
                    high = num2;
                }

                for (int start = low + 1; start < high; start++)
                    sum += start;

                outarr.add(sum);
            } else {
                outarr.add(0);
            }
        }

        System.out.println(outarr.toString().replace("[", "").replace("]", "").replace(" ", ""));

    }
}
