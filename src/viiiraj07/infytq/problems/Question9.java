package viiiraj07.infytq.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Question9 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String instr = br.readLine().trim();
        String wordsInput = br.readLine().trim();

        String[] words = wordsInput.split(",");
        Set<Character> uniqueChars = new LinkedHashSet<>();

        Map<String, Integer> wordFrequency = new HashMap<>();
        for (String s : words) {
            if (!wordFrequency.containsKey(s)) {
                wordFrequency.put(s, 1);
            } else {
                wordFrequency.put(s, wordFrequency.get(s) + 1);
            }
        }

        for (char ch : instr.toCharArray())
            uniqueChars.add(ch);

        String output = "";

        for (Character character : uniqueChars) {
            ArrayList<Integer> indexList = new ArrayList<>();
            int firstIndex = instr.indexOf(character);
            indexList.add(firstIndex);
            for (int i = firstIndex + 1; i < instr.length(); i++) {
                if (instr.charAt(i) == character) {
                    indexList.add(i);
                }
            }

            String str = words[firstIndex];
            boolean flag = false;

            for (int x : indexList) {
                if (words[x].equals(str)) {
                    flag = true;
                } else {
                    flag = false;
                    break;
                }
            }


            if (flag && indexList.size() == wordFrequency.get(str)) {
                output += character;
            }
        }

        if (output.equals(""))
            System.out.println("NA");
        else
            System.out.println(output);
    }
}
