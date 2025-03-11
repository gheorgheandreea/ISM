package ro.ulbs.paradigme.lab2.simplechained;


import ro.ulbs.paradigme.lab2.doublechained.DoubleChainedNode;

public class SimpleChainedList{
        private SimpleChainedNode head;

    public void addValue(int value) {
        if (head == null) {
            head = new SimpleChainedNode(value);
            return;
        }
        SimpleChainedNode tail = head;
        while (tail.getNextNode() != null) {
            tail = tail.getNextNode();
        }
        tail.setNextNode(new SimpleChainedNode(value));
    }

    public SimpleChainedNode getNodeByValue(int value) {
        SimpleChainedNode tail = head;
        while (tail != null) {
            if (tail.getValue() == value) {
                return tail;
            }
            tail = tail.getNextNode();
        }
        return null;
    }

    public void removeNodeByValue(int value) {
        if (head == null) return;
        if (head.getValue() == value) {
            head = head.getNextNode();
        } else {
            SimpleChainedNode pnode = head;
            SimpleChainedNode node = head.getNextNode();
            while (node != null) {
                if (node.getValue() == value) {
                    pnode.setNextNode(node.getNextNode());
                }
                pnode = node;
                node = node.getNextNode();
            }
        }
    }

    public void listNodes() {
        SimpleChainedNode temp = head;
        System.out.println();
        System.out.print("lista simplu inlantuita: ");
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNextNode();
        }
        System.out.println();
    }
    public int sum() {
        int suma = 0;
        SimpleChainedNode node = head;
        while (node != null) {
            suma += node.getValue();
            node = node.getNextNode();
        }
        return suma;
    }
    public boolean isSorted() {
        SimpleChainedNode temp = head;
        while (temp != null && temp.getNextNode() != null) {
            if (temp.getValue() > temp.getNextNode().getValue()) {
                return false;
            }
            temp = temp.getNextNode();
        }
        return true;
    }
}



