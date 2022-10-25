package shenxinfu;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(deletePattern("222BCC111CB"));
    }
    public static String deletePattern(String str) {
        String result = str.replaceFirst("(.)\\1{2,}", "");
        if (result.length() == str.length()) {
            return result;
        } else {
            return deletePattern(result);
        }
    }
}
