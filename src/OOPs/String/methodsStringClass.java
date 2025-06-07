package OOPs.String;

import java.util.Arrays;

public class methodsStringClass {
    public static void main(String[] args) {
        String s="durgaclasses";
        char []dst=new char[7];
        Arrays.fill(dst,'@');
        dst[0]='1';
        dst[1]='#';
        dst[2]='m';

        s.getChars(3,7,dst,3) ;
        System.out.println(dst);

        String s1="abc";
        String s2="abc";
        System.out.println(s1.compareTo(s2));
    }
}
