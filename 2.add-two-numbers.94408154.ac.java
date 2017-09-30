/*
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers
 *
 * algorithms
 * Medium (27.89%)
 * Total Accepted:    355.4K
 * Total Submissions: 1.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode newListNode=new ListNode(0);
        ListNode curListNode=newListNode;
        ListNode preListNode=null;
        while((l1!=null)&&(l2!=null)){
            curListNode.val=(l1.val+l2.val+carry)%10;
            carry=(l1.val+l2.val+carry)/10;
            curListNode.next=new ListNode(0);
            preListNode=curListNode;
            curListNode=curListNode.next;
            l1=l1.next;
            l2=l2.next;
        }
        ListNode longerList;
        if(l1!=null){
            longerList=l1;
        }else if(l2!=null){
            longerList=l2;
        }else{//l1, l2 are null, which shows they have the same length
            if(carry!=0)
                curListNode.val=carry;
            else
                preListNode.next=null;
            return newListNode;
        }
        while(longerList!=null){
            curListNode.val=(longerList.val+carry)%10;
            carry=(longerList.val+carry)/10;
            curListNode.next=new ListNode(0);
            preListNode=curListNode;
            curListNode=curListNode.next;
            longerList=longerList.next;
        }
        if(carry!=0)
            curListNode.val=carry;
        else
            preListNode.next=null;
        return newListNode;
    }
}
