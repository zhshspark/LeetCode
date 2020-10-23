package T389_S;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	
	//�ٶȳ�����,16ms
	public static char findTheDifference0(String s, String t) {
        if(s.length()<1) return t.charAt(0);
        Map<Character, Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<s.length();i++){
        	char c=s.charAt(i);
            map.put(c,map.getOrDefault(c, 0)+1);
        }
        
        for(int i=0;i<t.length();i++){
        	char c=t.charAt(i);
        	if(!map.containsKey(c)) return c;
            if (map.get(c)<2) {
				map.remove(c);
			}
            else {
				map.put(c, map.get(c)-1);
			}
        }
        return map.keySet().iterator().next();
    }
	
	//��������,3ms
	public static char findTheDifference1(String s,String t) {
		//��Ϊ����Сд��ĸ
		int[] arr=new int[26];
		for (int i = 0,j=0; i < s.length()||j<t.length(); i++,j++) {
			if (i<s.length()) {
				arr[s.charAt(i)-'a']++;
			}
			arr[t.charAt(j)-'a']--;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=0)
				return (char) (i+'a');
		}
		
		return 'a';
	}
	
	//���������㷨, 2ms
	public static char findTheDifference2(String s,String t) {
		char ans=t.charAt(t.length()-1);
		for (int i = 0; i < s.length(); i++) {
			ans^=s.charAt(i);
			ans^=t.charAt(i);
		}
		return ans;
	}
	
	
	//��������㷨���������Ż���1�ֽⷨ������if�ж�, 2ms
	public static char findTheDifference3(String s,String t) {
		//��Ϊ����Сд��ĸ
		int[] arr=new int[26];
		arr[t.charAt(t.length()-1)-'a']--;
		for (int i = 0; i < s.length(); i++) {
			arr[s.charAt(i)-'a']++;
			arr[t.charAt(i)-'a']--;
		}
		
		for (int i = 0; i <26; i++) {
			if(arr[i]!=0)
				return (char) (i+'a');
		}
		
		return 'a';
	}
	
}
