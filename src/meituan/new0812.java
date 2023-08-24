package meituan;

import java.util.Scanner;

public class new0812 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = in.nextInt();
        }
        int x = in.nextInt();
        int y = in.nextInt();
        for (int i = 0; i < n; i++) {
            if(data[i]==x){
                if(i+1<n&&data[i+1]==y){
                    System.out.println("Yes");
                    return;
                }
                if(i-1>=0&&data[i-1]==y){
                    System.out.println("Yes");
                    return;
                }
            }
            if (data[i]==y){
                if(i+1<n&&data[i+1]==x){
                    System.out.println("Yes");
                    return;
                }
                if(i-1>=0&&data[i-1]==x){
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
        return;
    }
}