package T205_S;

import java.util.HashMap;
import java.util.Map;


public class Solution {
	//���˵���������Ȼ��ʵ�֣�����Ч�ʲ���
    public static boolean isIsomorphic(String s, String t) {
    	int lenS=s.length();
    	int lenT=t.length();
    	Map<Character, Character> map=new HashMap<Character, Character>();
    	//�ȿ�s�е��ַ���t�е�ӳ��
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
    	//���map���ٿ�t�е��ַ���s�е�ӳ�����
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
    
    //���еĽⷨ,��Ȼһ��forѭ��������Ч�ʲ���
    public static boolean isIsomorphic1(String s, String t) {
    	if (s.length()<1) {  //��Ŀ�м���s,t�ĳ�������ȵģ�������Ҫ���ж�һ�¡�
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
    
    //���еĽⷨ������Map,���Ч��Ҳ����
    public static boolean isIsomorphic2(String s, String t) 
    {
    	if (s.length()<1) {  //��Ŀ�м���s,t�ĳ�������ȵģ�������Ҫ���ж�һ�¡�
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
