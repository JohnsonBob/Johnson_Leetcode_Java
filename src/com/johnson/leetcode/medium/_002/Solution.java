package com.johnson.leetcode.medium._002;

import java.util.ArrayList;

public class Solution {

    /*public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> a1 = new ArrayList<>();
        ArrayList<Integer> a2 = new ArrayList<>();
        parse(l1, a1);
        parse(l2, a2);

        int sum = 0;
        ListNode listNode = null;
        ListNode tempListNode = null;
        int tens = 0;

        for (int i = 0; i < a1.size() || i < a2.size() || tens != 0; i++) {
            sum = 0;
            try {
                sum += (Integer) a1.get(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                sum += (Integer) a2.get(i);
            } catch (Exception e) {
                e.printStackTrace();
            }
            sum += tens;
            ListNode temp = null;
            if (sum >= 10) {
                temp = new ListNode(sum % 10);
                tens = 1;
            } else {
                temp = new ListNode(sum);
                tens = 0;
            }


            if (listNode == null) {
                listNode = temp;
            } else {
                if (tempListNode == null) {
                    listNode.next = temp;
                } else {
                    tempListNode.next = temp;
                }
                tempListNode = temp;
            }
        }
        return listNode;
    }

    private void parse(ListNode listNode, ArrayList<Integer> list) {
        list.add(listNode.val);
        if (listNode.next != null)
            parse(listNode.next, list);
    }*/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode t1 = l1, t2 = l2, t3 = new ListNode(0), t4 = t3;
        int sum = 0;
        while (t1 != null || t2 != null) {
            sum = sum / 10;
            if (t1 != null) {
                sum += t1.val;
                t1 = t1.next;
            }
            if (t2 != null) {
                sum += t2.val;
                t2 = t2.next;
            }
            t4.next = new ListNode(sum % 10);
            t4 = t4.next;
        }
        if (sum / 10 != 0) t4.next = new ListNode(1);
        return t3.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = ListNode.createTestData(new Integer[]{5});
        ListNode listNode2 = ListNode.createTestData(new Integer[]{5});

        ListNode listNode = solution.addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        private static ListNode createTestData(Integer[] data) {
            ListNode solution = new ListNode(0);
            ListNode temp = solution;
            for (Integer item : data) {
                temp.next = new ListNode(item);
                temp = temp.next;
            }
            return solution.next;
        }

        @Override
        public String toString() {
            ListNode listNode = this;
            StringBuilder result = new StringBuilder();
            while (listNode != null) {
                result.append(listNode.val);
                if (listNode.next != null) result.append("->");
                listNode = listNode.next;
            }
            return result.toString();
        }
    }
}
