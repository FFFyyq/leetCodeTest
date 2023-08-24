package media;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class First {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(hasDuplicateChars(s));
        scan.close();

    }
    public static boolean hasDuplicateChars(String s) {
        // 使用HashSet来判断去重后的字符长度是否与原字符串长度相同
        Set<Character> charSet = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charSet.contains(c)) {
                return false;  // 出现重复字符，返回true
            }
            charSet.add(c);
        }
        return true;  // 字符串中没有重复字符，返回false
    }

}
