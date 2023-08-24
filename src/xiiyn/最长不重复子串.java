package xiiyn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 最长不重复子串 {


    public static List<String> findLongestSubstring(String s) {
        List<String> maxSubstrings = new ArrayList<>();
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {
            String substring = "";
            for (int j = i; j < s.length(); j++) {
                if (substring.indexOf(s.charAt(j)) != -1) {
                    break;
                }
                substring += s.charAt(j);
            }
            if (substring.length() > maxLen) {
                maxSubstrings = new ArrayList<>();
                maxSubstrings.add(substring);
                maxLen = substring.length();
            } else if (substring.length() == maxLen) {
                maxSubstrings.add(substring);
            }
        }

        return maxSubstrings;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入一个字符串：");
        String s = scanner.nextLine();
        List<String> maxSubstrings = findLongestSubstring(s);
        System.out.println("长度最长的不含重复字符的子字符串是：");
        for (String substring : maxSubstrings) {
            System.out.println(substring);
        }
    }
}
