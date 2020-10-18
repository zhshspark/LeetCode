package T19_M;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	//自己想的一遍扫描，借助Hashmap，但是效率不高！！！
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //一趟扫描，获取每个节点及其序号
        int i=0;
        ListNode curr=head;
        Map<Integer,ListNode> hm=new HashMap<Integer,ListNode>();
        while(curr!=null){
            i++;
            hm.put(i,curr);
            curr=curr.next;
            
        }
        if(i==n) //删除第一个节点
            return head.next;
        else if(n==1){  //删除尾部节点
            hm.get(i-n).next=null;
            return head;
        }
        else{
            hm.get(i-n).next=hm.get(i-n).next.next;
            return head;
        }
    }
    
    //双指针法,效率确实高！
    //我们可以设想假设设定了双指针 p 和 q 的话，当 q 指向末尾的 NULL，
    //p 与 q 之间相隔的元素个数为 n 时，那么删除掉 p 的下一个指针就完成了要求。
    	//设置虚拟节点 dummyHead 指向 head
    	//设定双指针 p 和 q，初始都指向虚拟节点 dummyHead
    	//移动 q，直到 p 与 q 之间相隔的元素个数为 n
    	//同时移动 p 与 q，直到 q 指向的为 NULL
    	//将 p 的下一个节点指向下下个节点
    public ListNode removeNthFromEnd0(ListNode head, int n) {
    	ListNode dummy=new ListNode();
    	dummy.next=head;
    	ListNode p=dummy,q=dummy;
    	while(n>0) {
			q=q.next;
			n--;
		}
    	
    	while (q!=null) {
			p=p.next;
			q=q.next;
		}
    	
    	p.next=p.next.next;
    	return dummy.next;
    }

     //Definition for singly-linked list.
     public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}
