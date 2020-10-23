package T350_S;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	//真蹩脚啊！！！，这么简单的题，提交了几次才通过，而且之前用C#做过的，效率不高，3ms
    public static int[] intersect(int[] nums1, int[] nums2) {
    	int len1=nums1.length;
    	int len2=nums2.length;
    	if (len1==0 || len2==0) {
			return new int[] {};
		}
    	Map<Integer,Integer> map=new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < nums1.length; i++) {
			map.put(nums1[i],map.getOrDefault(nums1[i], 0)+1);
		}
    	
    	ArrayList<Integer> ans=new ArrayList<Integer>();
    	for (int i = 0; i < nums2.length; i++) {
			if (map.containsKey(nums2[i])) {
				ans.add(nums2[i]);				
				if (map.get(nums2[i])==1) {
					map.remove(nums2[i]);
				}else {
					map.put(nums2[i], map.get(nums2[i])-1);
				}
			}
		}
    	
    	int[] res=new int[ans.size()];
    	int index=0;
    	for (int i : ans) {
			res[index++]=i;
		}
    	return res;
    }
}
