package StackQueue;

import java.util.Stack;

public class removeKDigits {
    public static String removeKdigits(String num, int k) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<num.length();i++)
        {
            while(!st.isEmpty() && k>0 && (st.peek()-'0')>(num.charAt(i)-'0'))
            {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k>0)
        {
            st.pop();
            k--;
        }
        if(st.isEmpty())
            return "0";
        String res="";

        while(!st.isEmpty())
            res+=st.pop();
        int ind=0;
        for(ind=res.length()-1;ind>=0;ind--)
            if(res.charAt(ind)!='0')
                break;
        String result="";
        for(int i=ind;i>=0;i--)
            result+=res.charAt(i);
        if(result.isEmpty())
            return "0";
        return result;
    }

    public static void main(String[] args) {
        System.out.println(removeKdigits("123456789",3));
        System.out.println(removeKdigits("987612345",3));
        System.out.println(removeKdigits("987",3));
        System.out.println(removeKdigits("10",1));

    }
}
