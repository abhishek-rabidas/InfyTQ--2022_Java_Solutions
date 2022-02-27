package viiiraj07.infytq.problems;

import java.util.HashMap;
import java.util.Scanner;

public class Question5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String instr = sc.nextLine();
        System.out.println(result(instr));

    }

    static String result(String input) {
        int indexChar = getHighestOccurringChar(input);
        int indexDigit = getHighestOccurringDigit(input);
        int specialIndex = Math.abs(indexChar - indexDigit);
        char removalCharacter = input.charAt(specialIndex);
        input = input.replace(' ', '$');
        StringBuilder br = null;
        if (!Character.isWhitespace(removalCharacter)) {
            input = input.replace(removalCharacter, ' ');
            br = new StringBuilder(input);
            for (int i = 0; i < br.length(); i++) {
                char ch = br.charAt(i);
                if (Character.isWhitespace(ch)) {
                    br.deleteCharAt(i);
                }
            }
        } else return input;

        return br.toString().trim();
    }

    static int getHighestOccurringChar(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        int max = Integer.MIN_VALUE;
        for (int x : map.values()) {
            max = Math.max(x, max);
        }
        return max <= 0 ? 0 : max;
    }

    static int getHighestOccurringDigit(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                if (!map.containsKey(ch)) {
                    map.put(ch, 1);
                } else {
                    map.put(ch, map.get(ch) + 1);
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for (int x : map.values()) {
            max = Math.max(x, max);
        }
        return max <= 0 ? 0 : max;
    }
}
