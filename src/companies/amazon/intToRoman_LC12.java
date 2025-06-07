package companies.amazon;

public class intToRoman_LC12 {

    public static String intToRoman(int num)
    {
        int []values={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String []roman={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int n=values.length;
        StringBuilder res=new StringBuilder();
        for(int ind=0;ind<n;ind++)
        {
            while(num>=values[ind])
            {
                res.append(roman[ind]);
                num-=values[ind];

            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println("Example 1:  \n"+intToRoman(3749));
        System.out.println("Example 2:  \n"+intToRoman(58));
        System.out.println("Example 3:  \n"+intToRoman(1994));



    }
}
