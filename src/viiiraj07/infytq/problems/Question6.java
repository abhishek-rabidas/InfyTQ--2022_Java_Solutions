package viiiraj07.infytq.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Question6 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().trim();
        int inNum1 = Integer.parseInt(br.readLine());
        int inNum2 = Integer.parseInt(br.readLine());

        String[] words = input.split(",");

        String tempStr = "";

        for (int i = 1; i < words.length; i++) {
            String curr = words[i];
            char ch1 = curr.charAt(highestOccurringCharacterCount(words[i - 1]) % curr.length());
            tempStr += ch1;
        }

        System.out.println(getSubstrings(inNum1, inNum2, tempStr));
    }

    static int highestOccurringCharacterCount(String word) {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : word.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        for (int x : map.values()) {
            count = Math.max(x, count);
        }
        return count;
    }

    static int getSubstrings(int min, int max, String word) {
        Set<String> substrings = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length() + 1; j++) {
                String substring = word.substring(i, j);
                if (substring.length() >= min && substring.length() <= max)
                    substrings.add(substring);
            }
        }

        //System.out.println(substrings);

        return substrings.size();
    }
}
