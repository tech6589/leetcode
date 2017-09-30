/*
 * [160] Intersection of Two Linked Lists
 *
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 *
 * algorithms
 * Easy (30.66%)
 * Total Accepted:    148.8K
 * Total Submissions: 485.5K
 * Testcase Example:  'No intersection: []\n[]'
 *
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * For example, the following two linked lists: 
 * 
 * A:          a1 → a2
 * ⁠                  ↘
 * ⁠                    c1 → c2 → c3
 * ⁠                  ↗            
 * B:     b1 → b2 → b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function
 * returns. 
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 
 * 
 * Credits:Special thanks to @stellari for adding this problem and creating all
 * test cases.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

//Two pointers
// once a reach the end, redirect it to headB
// once b reach the end, redirect it to headA
// since the pointer pointing to the longer list goes more nodes, redirect it to the shorter list, will make two pointers meet when they just finish the preceding nodes if they have a intersection.
// 2+3+3==3+3+2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)    return null;
        ListNode a=headA;
        ListNode b=headB;
        int redirect=0;
        while(a!=b&&redirect<3){
            a=a.next;
            b=b.next;
            if(a==null){
                a=headB;
                redirect++;
            }
            if(b==null){
                b=headA;
                redirect++;
            }    
        }
        if(a==b)    return a;
        else        return null;
        
    }
}
