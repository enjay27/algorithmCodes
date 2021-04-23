package chap12_Graph;

import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinationsV3(""));
        System.out.println(letterCombinationsV3("23"));
        System.out.println(letterCombinationsV3("234"));
    }

    public static List<String> letterCombinationsV1(String digits) {
        Map<Character, String> numberMap = new HashMap<>();
        numberMap.put('2', "abc");
        numberMap.put('3', "def");
        numberMap.put('4', "ghi");
        numberMap.put('5',"jkl");
        numberMap.put('6',"mno");
        numberMap.put('7',"pqrs");
        numberMap.put('8',"tuv");
        numberMap.put('9',"wxyz");
        List<String> result = new ArrayList<>();

        List<List<Character>> combination = new ArrayList<>();

        for (int i = 0; i < digits.toCharArray().length; i++) {
            combination.add(new ArrayList<>());
            for (char s : numberMap.get(digits.toCharArray()[i]).toCharArray()) {
                combination.get(i).add(s);
            }
        }
        for (int i = 0; i < combination.size(); i++) {
            for (int j = 0; j < combination.size(); j++) {
                if(j == i) continue;
                for (char c : combination.get(i)) {
                    for (char d : combination.get(j)) {
                        result.add(String.valueOf(c) + String.valueOf(d));
                    }
                }
            }
        }

        return result;
    }

    public static List<String> letterCombinationsV2(String digits) {
        Map<Character, String> numberMap = new HashMap<>();
        numberMap.put('2', "abc");
        numberMap.put('3', "def");
        numberMap.put('4', "ghi");
        numberMap.put('5',"jkl");
        numberMap.put('6',"mno");
        numberMap.put('7',"pqrs");
        numberMap.put('8',"tuv");
        numberMap.put('9',"wxyz");
        List<String> result = new ArrayList<>();

        if (digits.length() == 1) {
            char[] chars = numberMap.get(digits.charAt(0)).toCharArray();
            for (char c : chars) {
                result.add(String.valueOf(c));
            }
            return result;
        }

        List<List<Character>> combination = new ArrayList<>();

        for (int i = 0; i < digits.toCharArray().length; i++) {
            combination.add(new ArrayList<>());
            for (char s : numberMap.get(digits.toCharArray()[i]).toCharArray()) {
                combination.get(i).add(s);
            }
        }
        for (int i = 0; i < combination.size(); i++) {
            for (int j = i + 1; j < combination.size(); j++) {
                if(j == i) continue;
                for (char c : combination.get(i)) {
                    for (char d : combination.get(j)) {
                        result.add(String.valueOf(c) + String.valueOf(d));
                    }
                }
            }
        }

        return result;
    }

    public static List<String> letterCombinationsV3(String digits) {

        List<String> result = new ArrayList<>();

        if(digits == null || digits.equals(""))
            return Collections.emptyList();

        Map<Character, String> numberMap = new HashMap<>();
        numberMap.put('2', "abc");
        numberMap.put('3', "def");
        numberMap.put('4', "ghi");
        numberMap.put('5',"jkl");
        numberMap.put('6',"mno");
        numberMap.put('7',"pqrs");
        numberMap.put('8',"tuv");
        numberMap.put('9',"wxyz");


        StringBuilder sb = new StringBuilder();

        List<List<Character>> combination = new ArrayList<>();

        for (int i = 0; i < digits.toCharArray().length; i++) {
            combination.add(new ArrayList<>());
            for (char s : numberMap.get(digits.toCharArray()[i]).toCharArray()) {
                combination.get(i).add(s);
            }
        }

        dfs(result, sb, combination, 0, digits.length());

        return result;
    }

    public static void dfs(List<String> result, StringBuilder sb, List<List<Character>> combination, int i, int max) {
        if(combination.size() == i) {
            result.add(sb.toString());
            return;
        }
        for (char c : combination.get(i)) {
            sb.delete(i, max);
            sb.append(c);
            dfs(result, sb, combination, i + 1, max);
        }
    }
}
