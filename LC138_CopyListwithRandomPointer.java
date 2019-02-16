/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null)
            return null;

        RandomListNode node = head;

        while(node != null){ // node.next != null 单个节点时错误
            RandomListNode newNode = new RandomListNode(node.label);
            newNode.next = node.next;
            newNode.random = node.random;
            node.next = newNode;
            node = newNode.next;
        }

        RandomListNode newHead = head.next;
        node = head;

        while((node!=null)){
            if(node.next.random != null)
                node.next.random = node.next.random.next;
            node = node.next.next;
        }

        node = head; // 少了这句，直接报错
        while((node != null)&&(node.next!= null)){
            RandomListNode nextNode = node.next;
            node.next = node.next.next;
            node = nextNode;
        }

        return newHead;
    }
}
