import java.util.List;

public class RemoveNthFromTheEnd {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))));

        RemoveNthFromTheEnd obj = new RemoveNthFromTheEnd();
        head = obj.removeNthFromEnd(head,1);
        obj.print(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(n ==1 && head.next == null) {
            return null;
        }
        int len = length(head);
        System.out.println(len);
        print(head);

        int targetIndex = len - n + 1;
        if(n<=len) {
            if(targetIndex == 1) {
                head = head.next;
                return head;
            }
            int currentIndex = 1;

            ListNode parent, current, next =null;
            parent = head;
            while(currentIndex != targetIndex) {
                current = parent.next;
                next = current.next;
                currentIndex++;
                if(currentIndex != targetIndex)
                    parent = current;
            }

            parent.next = next;

        }

        return head;
    }

    private void print(ListNode node) {
        if(node ==null) {
            System.out.print(" ");
            return;
        }
        System.out.print(node.val+" ");
        print(node.next);
    }

    private int length(ListNode node) {
        int count = 0;
        while(node != null) {
            count++;
            node = node.next;
        }
        return count;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    
}
