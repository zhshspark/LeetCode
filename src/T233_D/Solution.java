package T233_D;

public class Solution {
	static int count=0;
	//递归是有限制的，超过一定层数，会导致堆栈溢出，所以不适合
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
    
    
    //暴力循环
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
