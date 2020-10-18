package T19_M;

import java.util.HashMap;
import java.util.Map;

public class Solution {
	//�Լ����һ��ɨ�裬����Hashmap������Ч�ʲ��ߣ�����
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //һ��ɨ�裬��ȡÿ���ڵ㼰�����
        int i=0;
        ListNode curr=head;
        Map<Integer,ListNode> hm=new HashMap<Integer,ListNode>();
        while(curr!=null){
            i++;
            hm.put(i,curr);
            curr=curr.next;
            
        }
        if(i==n) //ɾ����һ���ڵ�
            return head.next;
        else if(n==1){  //ɾ��β���ڵ�
            hm.get(i-n).next=null;
            return head;
        }
        else{
            hm.get(i-n).next=hm.get(i-n).next.next;
            return head;
        }
    }
    
    //˫ָ�뷨,Ч��ȷʵ�ߣ�
    //���ǿ�����������趨��˫ָ�� p �� q �Ļ����� q ָ��ĩβ�� NULL��
    //p �� q ֮�������Ԫ�ظ���Ϊ n ʱ����ôɾ���� p ����һ��ָ��������Ҫ��
    	//��������ڵ� dummyHead ָ�� head
    	//�趨˫ָ�� p �� q����ʼ��ָ������ڵ� dummyHead
    	//�ƶ� q��ֱ�� p �� q ֮�������Ԫ�ظ���Ϊ n
    	//ͬʱ�ƶ� p �� q��ֱ�� q ָ���Ϊ NULL
    	//�� p ����һ���ڵ�ָ�����¸��ڵ�
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
