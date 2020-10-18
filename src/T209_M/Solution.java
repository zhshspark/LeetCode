package T209_M;

public class Solution {
	//暴力,leetcode官方测试，需要700ms以上
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
    
    //双指针法
    //设定两个指针，left=0, right=0;
    //right向右侧移动，直到和大于s，再尝试收缩left
    //leetcode测试，只需要2ms，时间复杂度O(n)
    public static int minSubArrayLen1(int s, int[] nums) {
    	int len=nums.length;
    	if(len<1) return 0;
    	int res=Integer.MAX_VALUE;
    	int left=0,right=0;
    	int sum=0;
    	while(right<len) {
    		sum+=nums[right];
    		while(sum>=s) { //尝试收缩left
    			res=Math.min(res, right-left+1);
    			sum-=nums[left++];
    		}
			right++;		
    	}
    	return res==Integer.MAX_VALUE?0:res;
    }
}
