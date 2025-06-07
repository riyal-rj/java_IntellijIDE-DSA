package companies.amazon;

public class numberToWords_LC273 {
    static final String []lessTwenty={"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    static final String []tens={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    static final String [] thousands={"","Thousand","Million","Billion"};

    static String numberToWords(int num)
    {
        if(num==0)
            return "Zero";
        StringBuilder words=new StringBuilder();
        int thInd=0;
        while(num>0)
        {
            if(num%1000!=0)
                words.insert(0,helper(num%1000)+thousands[thInd]+" ");
            num/=1000;
            thInd++;
        }
        return words.toString().trim();
    }

     static String helper(int num)
     {
         if(num==0)
             return "";
         if(num<20)
             return lessTwenty[num]+" ";
         if(num<100)
             return tens[num/10]+" "+helper(num%10);
         return lessTwenty[num/100]+" Hundred "+helper(num%100);
     }

    public static void main(String[] args) {
        System.out.println(numberToWords(123));
        System.out.println(numberToWords(12345));
        System.out.println(numberToWords(1234567));
    }
}
