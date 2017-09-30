/*
 * [83] Remove Duplicates from Sorted List
 *
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list
 *
 * algorithms
 * Easy (39.94%)
 * Total Accepted:    199.5K
 * Total Submissions: 499.5K
 * Testcase Example:  '[]'
 *
 * 
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
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
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode l=head;
        ListNode r=head.next;
        while(r!=null){
            if(l.val==r.val){
                r=r.next;
            }else{
                l.next=r;
                l=r;
                r=r.next;
            }
        }
        l.next=null;
        return head;
    }
}
