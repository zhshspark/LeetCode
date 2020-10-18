package T2_M;

import T2_M.Solution.ListNode;

public class Main {

	public static void main(String[] args) {
		//构建两个连边
		int[] arr1= {1,2,3};
		int[] arr2= {7,8,9};
		ListNode head1=createListNode(arr1);
		ListNode head2=createListNode(arr2);
		ListNode res=Solution.addTwoNumbers(head1, head2);
		while (res!=null) {
			System.out.print(res.val+"  ");
			res=res.next;
		}
	}

	//根据数组创建链表
	private static ListNode createListNode(int[] arr1) {
		ListNode dummy=new ListNode(-1);
		ListNode prev=dummy;
		for (int i = 0; i < arr1.length; i++) {
			ListNode tmp=new ListNode(arr1[i]);
			prev.next=tmp;
			prev=tmp;
		}
		return dummy.next;
	}

}
