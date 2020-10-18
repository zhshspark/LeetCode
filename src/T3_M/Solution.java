package T3_M;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	//��HashMap�洢�ַ������±�ļ�ֵ�ԣ�
	//���hashmap�д��ڵ�ǰ�ַ�:
	//		1. ��ǰ�ִ�����󳤶�Ϊ��ǰ�±�-hashmap�ж�Ӧ���ַ����±�
	//      2.��ǰ�±��Ϊhashmap�ж�Ӧ���ַ����±�+1
	//      3.���hashmap,  ������Ƚ���
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
    
    //�ٷ��Ļ������ڽⷨ
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
				set.remove(s.charAt(i-1));  //��ָ�����Ҳ��ƶ�һλ
			}
    		while (right+1<len && !set.contains(s.charAt(right+1))) {  //�����ƶ��Ҳ�ָ�룬ֱ���ַ����������߳����ظ��ַ�
				set.add(s.charAt(right+1));
    			right++;
			}
    		//���´ӵ�ǰ�ַ���ʼ��ȡ��������Ӵ�����
    		res=Math.max(res,right-i+1);
    		
		}
    	return res;
    }
}
