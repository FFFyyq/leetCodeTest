package A4399;

public class q081401 {
    public static String subtract(String a, String b) {
        // 初始化结果字符串和指针
        StringBuilder result = new StringBuilder();
        int idx1 = a.length() - 1;
        int idx2 = b.length() - 1;
        int borrow = 0;

        // 从末尾开始逐位相减
        while (idx1 >= 0 || idx2 >= 0) {
            // 获取当前位的数值，如果指针已经越界，则设为0
            int num1 = (idx1 >= 0) ? Character.getNumericValue(a.charAt(idx1)) : 0;
            int num2 = (idx2 >= 0) ? Character.getNumericValue(b.charAt(idx2)) : 0;

            // 计算当前位的差值
            int diff = num1 - num2 - borrow;

            // 如果差值小于0，需要向前借位
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }

            // 将差值添加到结果字符串的开头
            result.insert(0, diff);

            // 更新指针
            idx1--;
            idx2--;
        }

        // 移除结果字符串开头的多余的0
        while (result.length() > 0 && result.charAt(0) == '0') {
            result.deleteCharAt(0);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String a = "1234567890";
        String b = "987654321";
        String result = subtract(a, b);
        System.out.println(result);  // 输出结果：246913457

        // 更多测试用例
    }
}