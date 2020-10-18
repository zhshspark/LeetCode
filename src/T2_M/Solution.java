package T2_M;

public class Solution {
	//数是逆序存储的，每个节点值存储一位数字，需要考虑进位，
	 public static class ListNode {  //必须加static，否则Main里面会报错
		 int val;
		 ListNode next;
		 public ListNode() {
			 
		 }
		 public ListNode(int val) { 
			 this.val = val; 
		 }
		 public ListNode(int val, ListNode next) { 
			 this.val = val; 			 
			 this.next = next; 
		 }
	}
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if (l1==null) {
			return l2;
		}
    	if(l2==null) {
    		return l1;
    	}
        ListNode dummy=new ListNode(-1);
        ListNode prev=dummy;

        ListNode currL1=l1;
        ListNode currL2=l2;
        int a=0,b=0;
        int iCarry=0;
        while(currL1!=null ||currL2!=null) {
        	a=currL1==null?0:currL1.val;
        	b=currL2==null?0:currL2.val;        	
        	ListNode tmp=new ListNode((a+b+iCarry)%10);
        	iCarry=(a+b+iCarry)/10;
        	prev.next=tmp;
        	prev=tmp;
        	currL1=currL1==null?null:currL1.next;
        	currL2=currL2==null?null:currL2.next;
        }
        if(iCarry!=0) {
        	ListNode tmp=new ListNode(iCarry);
        	prev.next=tmp;
        }
        return dummy.next;
    }
}
