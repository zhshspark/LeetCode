package T205_S;

import java.util.HashMap;
import java.util.Map;


public class Solution {
	//费了点力气，虽然能实现，但是效率不高
    public static boolean isIsomorphic(String s, String t) {
    	int lenS=s.length();
    	int lenT=t.length();
    	Map<Character, Character> map=new HashMap<Character, Character>();
    	//先看s中的字符在t中的映射
    	for (int i = 0; i < lenS; i++) {
			if (map.containsKey(s.charAt(i))) {
				if (map.get(s.charAt(i))!=t.charAt(i)) {
					return false;
				}
			}
			else {
				map.put(s.charAt(i), t.charAt(i));
			}
		}
    	//清空map，再看t中的字符在s中的映射情况
    	map.clear();
    	for (int i = 0; i < lenT; i++) {
			if (map.containsKey(t.charAt(i))) {
				if (map.get(t.charAt(i))!=s.charAt(i)) {
					return false;
				}
			}
			else {
				map.put(t.charAt(i), s.charAt(i));
			}
		}
    	return true;
    }
    
    //大佬的解法,虽然一遍for循环，但是效率不高
    public static boolean isIsomorphic1(String s, String t) {
    	if (s.length()<1) {  //题目中假设s,t的长度是相等的，否则需要再判断一下。
			return true;
		}
    	Map<Character, Integer> mpS=new HashMap<Character, Integer>();
    	Map<Character, Integer> mpT=new HashMap<Character, Integer>();
    	
    	for (int i = 0; i < s.length(); i++) {
    		if (mpS.containsKey(s.charAt(i))) {
				if (!mpT.containsKey(t.charAt(i))) {
					return false;
				}
				else {
					if(mpS.get(s.charAt(i))!=mpT.get(t.charAt(i))) {
						return false;
					}
				}
			}
    		else {
    			if (mpT.containsKey(t.charAt(i))) {
					return false;
				}
				mpS.put(s.charAt(i),i);
				mpT.put(t.charAt(i),i);
			}
		}
    	return true;
    }
    
    //大佬的解法，不用Map,这个效率也不高
    public static boolean isIsomorphic2(String s, String t) 
    {
    	if (s.length()<1) {  //题目中假设s,t的长度是相等的，否则需要再判断一下。
			return true;
		}
    	for (int i = 0; i < s.length(); i++) {
			if (getIndex(s, s.charAt(i))!=getIndex(t, t.charAt(i))) {
				return false;
			}
		}
    	return true;
    }
    private static int getIndex(String s,char c) {
    	for (int i = 0; i < s.length(); i++) {
			if (c==s.charAt(i)) {
				return i;
			}
		}
    	return -1;
    }
}
