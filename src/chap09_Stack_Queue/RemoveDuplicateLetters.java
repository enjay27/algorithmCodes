package chap09_Stack_Queue;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        String str = "bcabc";
        System.out.println(removeDuplicate(str));
    }

    private static String removeDuplicate(String letters) {
        int[] ints = letters.chars().distinct().sorted().toArray();
        StringBuilder result = new StringBuilder();
        for (int i : ints) {
            result.append((char) i);
        }
        return result.toString();
    }
}
