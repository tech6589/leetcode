/*
 * [206] Reverse Linked List
 *
 * https://leetcode.com/problems/reverse-linked-list
 *
 * algorithms
 * Easy (45.79%)
 * Total Accepted:    262.9K
 * Total Submissions: 574.1K
 * Testcase Example:  '[]'
 *
 * Reverse a singly linked list.
 * 
 * click to show more hints.
 * 
 * Hint:
 * A linked list can be reversed either iteratively or recursively. Could you
 * implement both?
 * 
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* Stack Solution
import java.util.Stack;
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)  return null;
        Stack<ListNode> nodes=new Stack<>();
        while(head.next!=null){
            nodes.push(head);
            head=head.next;
        }
        ListNode cur=head;
        while(nodes.empty()==false){
            cur.next=nodes.pop();
            cur=cur.next;
        }
        cur.next=null;//set the tail to null otherwise it will point to the node before it forming a loop, then leetcode won't end its test function, throwing memory limit exceeded
        return head;
    }
}*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null)  return null;
        ListNode cur=head.next;
        ListNode prev=head;
        while(cur!=null){
            ListNode next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }
        head.next=null;//now head is the tail, assign its next null otherwise it will points to the the node next to last, forming a loop
        return prev;
    }
}
