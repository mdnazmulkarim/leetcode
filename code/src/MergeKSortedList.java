import java.util.ArrayList;
import java.util.List;

public class MergeKSortedList {
    public static void main(String[] args) {
        MergeKSortedList.ListNode node1 = new MergeKSortedList.ListNode(1);
        node1.next = new MergeKSortedList.ListNode(4, new MergeKSortedList.ListNode(5 ));

        MergeKSortedList.ListNode node2 = new MergeKSortedList.ListNode(1);
        node2.next = new MergeKSortedList.ListNode(3, new MergeKSortedList.ListNode(4 ));

        MergeKSortedList.ListNode node3 = new MergeKSortedList.ListNode(2);
        node3.next = new MergeKSortedList.ListNode(6,new MergeKSortedList.ListNode(8));




        ListNode[] listNodes = new ListNode[]{node1, node2, node3};

        ListNode node = new MergeKSortedList().mergeKLists(listNodes);

        while(node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }

    public ListNode mergeKLists(ListNode[] lists) {

       // System.out.println(lists.length);
        ListNode listNode = new ListNode();
        int currentValue = getCurrentValue(lists);
        if(currentValue == 1000000) {
            System.out.println(currentValue);
            return listNode;
        }
        System.out.println(currentValue);
        ListNode node = listNode;
        List<Integer> list = new ArrayList<>();
        currentValue = 1000000;
        int index=0;
        boolean completed = false;
        while(!completed) {
            int k = 0;
            for(int i=0; i< lists.length; i++) {
                if(lists[i] != null && lists[i].val< currentValue){
                    index = i;
                    currentValue =  lists[i].val;
                    k++;
                }
            }
            if(k==0) {
                completed = true;
            }
            list.add(currentValue);
            lists[index] = lists[index].next;
        }

        System.out.println(list);

        return listNode;
    }

    private int getCurrentValue(ListNode[] lists) {
        for(int i = 0; i< lists.length; i++) {
            if(lists[i] != null) {
                return lists[i].val;
            }
        }
         return 1000000;
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
