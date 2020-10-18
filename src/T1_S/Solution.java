package T1_S;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	//此题因为要返回数组的下标值，所以不能对数组进行重新排序，否则下标就变了
    public int[] twoSum0(int[] nums, int target) {
    	//除了Map，好像想不到什么更好的方式
    	Map<Integer, Integer> map=new HashMap<Integer, Integer>();
    	for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target-nums[i])) {
				return new int[] {map.get(target-nums[i]),i};
			}
			else {
				map.put(nums[i], i);
			}
		}
    	return new int[] {};
    }
    //暴力破解
    public int[] twoSum1(int[] nums, int target) {
    	for (int i = 0; i < nums.length-1; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if (nums[i]+nums[j]==target) {
					return new int[] {i,j};
				}
			}
		}
    	return new int[] {};
    }
}
