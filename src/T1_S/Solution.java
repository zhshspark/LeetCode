package T1_S;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	//������ΪҪ����������±�ֵ�����Բ��ܶ���������������򣬷����±�ͱ���
    public int[] twoSum0(int[] nums, int target) {
    	//����Map�������벻��ʲô���õķ�ʽ
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
    //�����ƽ�
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
