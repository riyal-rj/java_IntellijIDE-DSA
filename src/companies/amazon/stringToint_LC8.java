package companies.amazon;

public class stringToint_LC8 {
    public static int myAtoi(String s) {
        int sign=1;

        int no=0;
        s=s.stripLeading();
        for(int ind=0;ind<s.length();ind++)
        {
            if(s.charAt(ind)>=48 && s.charAt(ind)<=57)
            {
                int digit=(int)s.charAt(ind)-48;
                if (no > (Integer.MAX_VALUE - digit) / 10) {
                    return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                no=no*10+digit;
            }
            else if(ind ==0 && s.charAt(ind)=='-')
            {
                sign=-1;
            }
            else if(ind ==0 && s.charAt(ind)=='+')
            {
                sign=1;
            }
            else
                break;
        }
        if(sign*no <Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return sign*no;
    }

    public static void main(String[] args) {
        System.out.println("Ex1");
        System.out.println(myAtoi("   -042"));
        System.out.println("Ex2");
        System.out.println(myAtoi(".1"));
        System.out.println("Ex-3");
        System.out.println(myAtoi("+1"));
        System.out.println(myAtoi("2147483646"));
        //System.out.println(Integer.MAX_VALUE);
        //int a=91283472332;
        //System.out.println(a);
    }
}
