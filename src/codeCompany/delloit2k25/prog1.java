package codeCompany.delloit2k25;

import java.util.Scanner;

//public class prog2 {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String s=sc.nextLine().toUpperCase();
//        String res=removeAll(s);
//        System.out.println(res);
//
//    }
//    public static String removeAll(String str)
//    {
//        String st1="STRUCTURAL";
//        StringBuilder sb=new StringBuilder();
//        for(char c:str.toCharArray())
//        {
//            if(st1.indexOf(c)==-1)
//                sb.append(c);
//        }
//        return sb.toString();
//    }
//}
import java.util.Scanner;

public class prog1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] amounts = new int[N];

        for (int i = 0; i < N; i++) {
            amounts[i] = sc.nextInt();
        }

        int evenSum = 0;
        int oddSum = 0;

        for (int amount : amounts) {
            if (amount % 2 == 0) {
                evenSum += amount;
            } else {
                oddSum += amount;
            }
        }

        System.out.println(evenSum + " " + oddSum);
    }
}