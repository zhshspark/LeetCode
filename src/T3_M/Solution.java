package T3_M;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	//用HashMap存储字符及其下标的键值对，
	//如果hashmap中存在当前字符:
	//		1. 则当前字串的最大长度为当前下标-hashmap中对应该字符的下标
	//      2.当前下标变为hashmap中对应该字符的下标+1
	//      3.清空hashmap,  这样会比较慢
    public static int lengthOfLongestSubstring0(String s) {
    	int len=s.length();
    	if (len<2) {
			return len;
		}
    	int res=0;
    	int tmp=0;
    	Map<Character, Integer> hm=new HashMap<Character, Integer>();
    	for (int i = 0; i < len; ) {
			if(hm.containsKey(s.charAt(i))) {
				res=Math.max(res, tmp);				
				i=hm.get(s.charAt(i))+1;
				hm.clear();
				tmp=0;
			}
			else {
				hm.put(s.charAt(i), i);
				i++;
				tmp++;
			}
		}
    	return Math.max(res, tmp);
    }
    
    //官方的滑动窗口解法
    public static int lengthOfLongestSubstring1(String s) {
    	int len=s.length();
    	if (len<2) {
			return len;
		}
    	int res=0;
    	int right=-1;
    	Set<Character> set=new HashSet<Character>();
    	for (int i = 0; i < len; i++) {
    		if (i!=0) {
				set.remove(s.charAt(i-1));  //左指针向右侧移动一位
			}
    		while (right+1<len && !set.contains(s.charAt(right+1))) {  //不断移动右侧指针，直到字符串结束或者出现重复字符
				set.add(s.charAt(right+1));
    			right++;
			}
    		//更新从当前字符开始获取到的最大子串长度
    		res=Math.max(res,right-i+1);
    		
		}
    	return res;
    }
}
