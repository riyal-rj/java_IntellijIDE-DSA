package TwoPointer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class substringConcatenationWithAllWords {

    public static List<Integer> findSubstring(String s,String[]words)
    {
        List<Integer> result=new ArrayList<>();
        Map<String, Integer> mpp=new HashMap<>();
        int wordLength=words[0].length();
        for(String word:words)
            mpp.put(word,mpp.getOrDefault(word,0)+1);

        for(int i=0;i<wordLength;i++)
        {
            int l=i;
            int r=i;
            Map<String,Integer> mpp1=new HashMap<>();
            while(r+wordLength<=s.length())
            {
                String word=s.substring(r,r+wordLength);
                r+=wordLength;
                if(mpp.containsKey(word))
                {
                    mpp1.put(word, mpp1.getOrDefault(word, 0) + 1);
                    while (mpp1.get(word) > mpp.get(word)) {
                        String leftWord = s.substring(l, l + wordLength);
                        mpp1.put(leftWord, mpp1.get(leftWord) - 1);
                        if (mpp1.get(leftWord) == 0)
                            mpp1.remove(leftWord);
                        l += wordLength;
                    }
                    if (r - l == wordLength * words.length)
                        result.add(l);
                }
                else
                {
                    mpp1.clear();
                    l=r;
                }


            }
        }
        return result;
    }

    public static void main(String[] args) {
        String []words={"foo","bar"};
        System.out.println(findSubstring("barfoothefoobarman",words));
    }
}
