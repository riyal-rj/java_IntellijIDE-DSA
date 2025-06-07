package companies.amazon;

public class romanToInteger_LC13 {

    static int romanToIntger(String roman)
    {
        int result=0;
        int prevVal=0;
        int n=roman.length();
        for(int i=n-1;i>=0;i--)
        {
            int currVal=getInt(roman.charAt(i));
            if(currVal<prevVal)
                result-=currVal;
            else
                result+=currVal;

            prevVal=currVal;
        }

        return result;
    }

    static int getInt(char ch)
    {
        return switch (ch) {
            case 'M' -> 1000;
            case 'D' -> 500;
            case 'C' -> 100;
            case 'L' -> 50;
            case 'X' -> 10;
            case 'V' -> 5;
            case 'I' -> 1;
            default -> 0;
        };
    }

    public static void main(String[] args) {
        System.out.println(romanToIntger("MCDLVI"));
    }
}
