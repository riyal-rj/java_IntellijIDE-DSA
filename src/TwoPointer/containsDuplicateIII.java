package TwoPointer;

import java.util.TreeMap;

public class containsDuplicateIII {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Long,Integer> mpp=new TreeMap<>();
        int l=0,r=0;
        while(r<nums.length)
        {
            long no=nums[r];
            Long floor=mpp.floorKey(no+valueDiff);
            Long ceil=mpp.ceilingKey(no-valueDiff);
            if((floor!=null && floor>=no-valueDiff  ) || (ceil!=null && ceil<=no+valueDiff))
                return true;
            mpp.put(no,mpp.getOrDefault(no,0)+1);
            if(r-l>=indexDiff)
            {
                long leftNo=nums[l];
                mpp.put(leftNo,mpp.get(leftNo)-1);
                if(mpp.get(leftNo)==0)
                    mpp.remove(leftNo);
                l++;
            }
            r++;
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
