package viiiraj07.infytq.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Question3 {
    static List<String> al = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String num = sc.nextLine();

        findsubsequences(num, "");
        int max = Integer.MIN_VALUE;

        for (String sub : al) {
            if (Objects.equals(sub, "")) continue;
            if (!sub.startsWith("0") && checkPrime(Integer.parseInt(sub))) {
                max = Math.max(max, Integer.parseInt(sub));
            }
        }
        if (max < 0) max = -1;
        System.out.println(max);
    }

    private static void findsubsequences(String s, String ans) {
        if (s.length() == 0) {
            al.add(ans);
            return;
        }
        findsubsequences(s.substring(1), ans + s.charAt(0));
        findsubsequences(s.substring(1), ans);
    }

    private static boolean checkPrime(int n) {
        if (n <= 1)
            return false;

        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;

        return true;
    }
}
