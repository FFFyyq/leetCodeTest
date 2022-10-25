package shenxinfu;
import java.util.Scanner;
public class Q1 {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            int x = input.nextInt();

            int ans = 0;
            int flag = x>0?1:-1;
            x = x > 0 ? x : -x;
            while(x !=0)
            {
                if(ans != (ans * 10)/10)
                {
                    System.out.println(0);
                    break;
                }
                ans =ans * 10 + x%10;
                x /= 10;
            }
            System.out.println(flag * ans);
        }

}
