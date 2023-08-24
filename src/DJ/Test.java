package DJ;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
//        Integer intObj = Integer.valueOf(args[args.length - 1]);
//        int i = intObj.intValue();
//        if (args.length > 1)
//            System.out.println(i);
//        if (args.length > 0)
//            System.out.println(i - 1);
//        else
//            System.out.println(i - 2);
        String inputString = "Welcome to DJI's official website www.dji.com";

        // 定义正则表达式，匹配包含"www.dji.com"的子字符串
        String regex = "[w]{0,3}.[a-z\\-]*.[a-z]+";

        // 创建Pattern对象
        Pattern pattern = Pattern.compile(regex);

        // 创建Matcher对象
        Matcher matcher = pattern.matcher(inputString);

        // 使用find()方法查找是否有匹配的子字符串
        if (matcher.find()) {
            System.out.println("Found a match: " + matcher.group());
        } else {
            System.out.println("No match found.");
        }

    }
    int foo(int n) {
        if (n < 2)
            return n;
        return foo(n - 1) + foo(n - 2);
    }
}
