package T233_D;

public class Solution {
	static int count=0;
	//�ݹ��������Ƶģ�����һ���������ᵼ�¶�ջ��������Բ��ʺ�
    public static int countDigitOne0(int n) {
    	countDigitOneHelper(n);
    	return count;
    }
    
    private static void countDigitOneHelper(int n) {
    	if(n==1) {
    		count++;
    		return;
    	}
    	String s=String.valueOf(n);
    	for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i)=='1') {
				count++;
			}
		}
    	countDigitOneHelper(n-1);
    }
    
    
    //����ѭ��
    public static int countDigitOne1(int n) {
    	int cns=0;    	
    	for (int i = 1; i <= n; i++) {
    		String str=String.valueOf(i);
	    	for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j)=='1') {
					cns++;
				}
			}			
		}
    	return cns;
    }
    
}
