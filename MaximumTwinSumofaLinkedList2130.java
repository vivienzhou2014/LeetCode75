import java.util.ArrayList;
import java.util.Stack;

public class MaximumTwinSumofaLinkedList2130 {

      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    class Solution {
        public int pairSum1(ListNode head) {
            //use a stack to store int
            //use fast&slow pointer to get to the middle
            //from the middle, add slow.val with each stack pop then compare with max(inital 0 )
            Stack<Integer> sums = new Stack<>();
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null){//when fast is null, slow is in the middle
                sums.push(slow.val);
                //System.out.println("slow:" + slow.val);
                slow = slow.next;
                fast = fast.next.next;
                //add first half of val in sum
            }
            //start pop and add, then compare add with max
            int max = 0;
            while(slow != null) {
                int sum = sums.pop() + slow.val;
                //System.out.println("sum is: " + sum);
                max = sum > max ? sum : max;
                slow = slow.next;
            }
            return max;
        }

        public int pairSum(ListNode head) {
            //to avoid extra space use, we reverse the last half link
            //fast&slow pointer to reach middle
            ListNode fast = head;
            ListNode slow = head;
            while(fast != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            //now slow is the head of last half link
            //set pre and temp
            ListNode pre = null;
            ListNode temp = null;
            while(slow != null){
                //use temp to link the rest of the link
                temp = slow.next;
                //slow->pre
                slow.next = pre;
                //move
                pre = slow;
                slow = temp;
            }
            //pre is the new head of last half link
            int max = 0;
            while(pre != null){
                int sum = head.val + pre.val;
                max = sum > max ? sum : max;
                head = head.next;
                pre = pre.next;
            }
            return max;
        }
    }

    public static void main(String[] args) {
        MaximumTwinSumofaLinkedList2130 solution = new MaximumTwinSumofaLinkedList2130();
        MaximumTwinSumofaLinkedList2130.Solution solver = solution.new Solution();



        // Test case 2: Create a linked list: 5 -> 5 -> 5 -> 5
        MaximumTwinSumofaLinkedList2130.ListNode node4 = solution.new ListNode(5);
        MaximumTwinSumofaLinkedList2130.ListNode node5 = solution.new ListNode(4, node4);
        MaximumTwinSumofaLinkedList2130.ListNode node6 = solution.new ListNode(2, node5);
        MaximumTwinSumofaLinkedList2130.ListNode node7 = solution.new ListNode(1, node6);

        int result2 = solver.pairSum(node7);
        System.out.println("Maximum Twin Sum for Test Case 2: " + result2); // Expected output: 10 (5 + 5)

        // Add more test cases as needed
    }

}
