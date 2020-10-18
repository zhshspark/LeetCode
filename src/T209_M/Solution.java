package T209_M;

public class Solution {
	//����,leetcode�ٷ����ԣ���Ҫ700ms����
    public static int minSubArrayLen0(int s, int[] nums) {
        if(nums.length<1) return 0;
    	int res=Integer.MAX_VALUE;
    	for (int i = 0; i < nums.length; i++) {
    		int tmp=0;
			for (int j = i; j < nums.length; j++) {
				tmp+=nums[j];
				if (tmp>=s) {
					res=Math.min(res, j-i+1);
				}
			}

		}
    	return res==Integer.MAX_VALUE?0:res;
    }
    
    //˫ָ�뷨
    //�趨����ָ�룬left=0, right=0;
    //right���Ҳ��ƶ���ֱ���ʹ���s���ٳ�������left
    //leetcode���ԣ�ֻ��Ҫ2ms��ʱ�临�Ӷ�O(n)
    public static int minSubArrayLen1(int s, int[] nums) {
    	int len=nums.length;
    	if(len<1) return 0;
    	int res=Integer.MAX_VALUE;
    	int left=0,right=0;
    	int sum=0;
    	while(right<len) {
    		sum+=nums[right];
    		while(sum>=s) { //��������left
    			res=Math.min(res, right-left+1);
    			sum-=nums[left++];
    		}
			right++;		
    	}
    	return res==Integer.MAX_VALUE?0:res;
    }
}
