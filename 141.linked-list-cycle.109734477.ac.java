/*
 * [141] Linked List Cycle
 *
 * https://leetcode.com/problems/linked-list-cycle
 *
 * algorithms
 * Easy (35.34%)
 * Total Accepted:    201.2K
 * Total Submissions: 569.2K
 * Testcase Example:  '[]\nno cycle'
 *
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * 
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 */
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode s=head;//s is slower, 1 step
        if(head==null)  return false;
        ListNode f=head.next;//f is faster, 2 steps
        while(f!=null){//if f==null, then the list has an end, of course no cycle
            if(s==f)    return true;
            s=s.next;
            if(f.next==null)    return false;
            f=f.next.next;
        }
        return false;   
    }
}
