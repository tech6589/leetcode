/*
 * [21] Merge Two Sorted Lists
 *
 * https://leetcode.com/problems/merge-two-sorted-lists
 *
 * algorithms
 * Easy (39.21%)
 * Total Accepted:    259.9K
 * Total Submissions: 662.9K
 * Testcase Example:  '[]\n[]'
 *
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3=new ListNode(0);//no meaning for 0 ,this node won't be returned, its next will be returned
        ListNode cur=l3;
        //reuse the node
        while((l1!=null)&&(l2!=null)){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
            }else{
                cur.next=l2;
                l2=l2.next;
            }
            cur=cur.next;
        }
        //for longer list
        if(l1==null){
            cur.next=l2;
        }else{
            cur.next=l1;
        }
        return l3.next;
    }
}
