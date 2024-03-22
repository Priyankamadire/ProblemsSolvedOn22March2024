/* 234. Palindrome Linked List
Solved
Easy
Topics
Companies
Given the head of a singly linked list, return true if it is a 
palindrome
 or false otherwise.

 

Example 1:


Input: head = [1,2,2,1]
Output: true
Example 2:


Input: head = [1,2]
Output: false
 

Constraints:

The number of nodes in the list is in the range [1, 105].
0 <= Node.val <= 9
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class POTD {
    public boolean isPalindrome(ListNode head) {
          if(head==null || head.next==null){
            return true;
        }
        ListNode fast = head,slow = head;
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode nh = rev(slow.next);
        ListNode f = head;
        ListNode s = nh;
        while(s!=null){
            if(f.val!=s.val){
                rev(nh);
                return false;
            }
            f=f.next;
            s=s.next;
        }
        rev(nh);
        return true;
 
    }
    public ListNode rev(ListNode head)
    {
        if(head==null || head.next==null){
            return head;
        }
        ListNode nn = rev(head.next);
        ListNode t = head.next;
        t.next=head;
        head.next=null;
        return nn;
    }
}
