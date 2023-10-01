public class ReverseLinkedList206 {

    //  Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public ListNode reverseList1(ListNode head) {
            //assume we have a linkedlist like this 1->2->3
            //if we make 1->null, then we lost 2
            //so we use a temp to link 2(head.next), and then 1->null
            //but when we move temp to 3 and head to 2, we can not point 2->null, it has to be 1
            //so we use a pre to represent 1 after move. so pre can be initialized as null
            //when moving, pre=head, head=temp, temp=head.next
            //when head move to null, we got what we want
            if(head == null || head.next == null){
                return head;
            }
            ListNode pre = null;
            ListNode temp = head.next;
            while(head != null){
                //we reverse link then move in a loop, so in last reverse link
                //temp is null, head->pre, pre still move to head, head move to temp, temp cant move
                //so after head move to temp, if head is null, dont move temp
                head.next = pre;
                pre = head;
                head = temp;
                if(head != null) {
                    temp = head.next;
                }
            }
            //since in the last loop, pre move to head, head move to null, pre will be the new head
            return pre;
        }

        public ListNode reverseList(ListNode head) {
            //method above has repeat code, try to optimize
            //temp can be null at first, move temp in the loop
            //corner case can also integrate to main code by setting while
            ListNode pre = null;
            ListNode temp = null;
            while(head != null){
                //move this first to avoid judging if head is null since head has not been moved
                temp = head.next;
                //reverse
                head.next = pre;
                //move head and pre, move pre first since pre is linked
                pre = head;
                head = temp;
            }
            //because we return pre, even if head== null, we still return null
            return pre;
        }
    }
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        ReverseLinkedList206 reverseLinkedList = new ReverseLinkedList206();
        ReverseLinkedList206.Solution solution = reverseLinkedList.new Solution();

        // Create a sample linked list
        ListNode head = reverseLinkedList.new ListNode(1);
        head.next = reverseLinkedList.new ListNode(2);
        head.next.next = reverseLinkedList.new ListNode(3);
        head.next.next.next = reverseLinkedList.new ListNode(4);
        head.next.next.next.next = reverseLinkedList.new ListNode(5);

        System.out.println("Original Linked List:");
        printList(head);

        // Reverse the linked list
        ListNode reversedHead = solution.reverseList(head);

        System.out.println("Reversed Linked List:");
        printList(reversedHead);
    }
}
