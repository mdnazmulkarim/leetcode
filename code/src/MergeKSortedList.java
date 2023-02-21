

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

        int MAX_VAL = 1000000;
        ListNode listNode = new ListNode(MAX_VAL);
        ListNode retValue = listNode;

        if(lists.length == 0) {
            return null;
        }

        boolean empty = true;
        for(int m =0; m< lists.length; m++) {
            if(lists[m] != null) {
                empty = false;
            }
        }

        if(empty) {
            return null;
        }


        int currentValue = MAX_VAL;
        int lowestIndex=0;
        boolean completed = false;
        int count =0;

        while(!completed ) {
            int k = 0;
            for(int i=0; i< lists.length; i++) {
                if(lists[i] != null && lists[i].val< currentValue){
                    lowestIndex = i;
                    currentValue =  lists[i].val;
                    k++;
                }
            }
            if(currentValue != MAX_VAL) {
                listNode = add(listNode, currentValue);
                count++;
            }
            if(lists[lowestIndex]!= null && lists[lowestIndex].next != null) {
                lists[lowestIndex] = lists[lowestIndex].next;
            } else {
                lists[lowestIndex] = null;
            }

            currentValue = MAX_VAL;
            lowestIndex = 0;
            if(k==0) {
                completed = true;
            }

        }

        return retValue;
    }

    private ListNode add(ListNode node, int value) {
        if (node == null) {
            node = new ListNode(value);
        } else if (node.val == 1000000) {
            node.val = value;
        } else {
            node.next = new ListNode(value);
            return node.next;
        }
        return node;
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
