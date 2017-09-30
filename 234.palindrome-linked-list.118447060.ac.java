/*
 * [234] Palindrome Linked List
 *
 * https://leetcode.com/problems/palindrome-linked-list
 *
 * algorithms
 * Easy (32.91%)
 * Total Accepted:    121.3K
 * Total Submissions: 368.7K
 * Testcase Example:  '[]'
 *
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// Use pointers to find the middle and tail, then I get head, middle and tail
// Slow and fast, fast walks twice than slow pointer.
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode prev=null;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            ListNode next=slow.next;
            slow.next=prev;
            prev=slow;
            slow=next;
        }
        // 
        // 1 -> 2 -> 3 -> 4 -> 3 -> 2 -> 1
        //           p    s              f
        // 1 -> 2 -> 3 -> 4 -> 4 -> 3 -> 2 -> 1 -> null
        //                p    s                    f
        if(fast!=null) slow=slow.next;
        //compare, from prev to null, from slow to null
        while(prev!=null){
            if(prev.val!=slow.val)  return false;
            prev=prev.next;
            slow=slow.next;
        }
        return true;
    }
}
