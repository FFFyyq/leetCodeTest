package media;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(maxLength(s));
        scanner.close();
    }
    public static  int maxLength(String s) {
        int left = 0;//定义指正，作用于指向字符串长度
        int right = 0;
        int max = 0;//最大值
        Set<Character> set = new HashSet<Character>();
        while (right < s.length()) {
            if (set.contains(s.charAt(right))) {//set中是否包含相同的字符
                set.remove(s.charAt(left++));
            } else {
                set.add(s.charAt(right++));//往set中添加字符
                if(set.size()>max){//判断字符串的长度
                    max=set.size();
                }
            }
        }
        return max;
    }
}
