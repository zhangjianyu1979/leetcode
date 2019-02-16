/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        while((l1!= null)&&(l2!= null)){
            if(l1.val < l2.val){
                node.next = l1;
                node = l1;// 顺序很重要，和下一行互换就超时了
                l1 = l1.next;
            }else{
                node.next = l2;
                node = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null)
            node.next = l1;
        else
            node.next = l2;

        return head.next;
    }
}
