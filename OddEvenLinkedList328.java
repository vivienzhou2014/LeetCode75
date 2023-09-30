public class OddEvenLinkedList328 {

//      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode oddEvenList(ListNode head) {
            //set two head, head1 for odd, head2 for even
            //link the end of headl to head2
            if(head == null){
                return null;
            }
            ListNode head1 = head;
            ListNode head2 = head.next;
            ListNode headEven = head2;
            while(head1.next != null && head2.next != null){
                head1.next = head1.next.next;
                head2.next = head2.next.next;
                head1 = head1.next;
                head2 = head2.next;
            }
            head1.next = headEven;
            return head;

        }
    }
}
