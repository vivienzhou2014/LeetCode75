public class DeletetheMiddleNodeofaLinkedList2095 {

     // Definition for singly-linked list.
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    class Solution {
        public ListNode deleteMiddle1(ListNode head) {
        //use fast&slow pointers, slow is node.next, fast is node.next.next
        //when fast is pointing to null or the end, then slow is pointing to middle
        //but we need to delete middle, so slow stops when pointing to node before middle
        //so fast stops when node.next.next.next is null or node.next.next is null
        //then middle node.next == node.next.next
        if(head.next == null){
            return head;
        }else if(head.next.next == null){
            head.next = null;
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next.next != null && fast.next.next.next != null){
                fast = fast.next.next;
                slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
        }
        public ListNode deleteMiddle(ListNode head) {
            //use a preSlow pointer to store the node before slow to avoid
            if(head.next == null){
                return null;
            }

            ListNode fast = head;
            ListNode slow = head;
            ListNode preSlow = null;

            while(fast != null && fast.next != null){
                fast = fast.next.next;
                preSlow = slow;
                slow = slow.next;
            }

            preSlow.next = preSlow.next.next;
            return head;
        }
    }

    public void main(String[] args) {
        ListNode head = new ListNode();
        head.val = 2;
        head.next.val = 1;
        Solution solution = new Solution();
        System.out.println(solution.deleteMiddle(head));
    }
}
