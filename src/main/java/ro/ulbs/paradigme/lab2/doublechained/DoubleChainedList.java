package ro.ulbs.paradigme.lab2.doublechained;

public class DoubleChainedList {
    private DoubleChainedNode head;

    public void addValue(int value) {
        DoubleChainedNode newNode = new DoubleChainedNode(value);
        if (head == null) {
            head = newNode;
        } else {
            DoubleChainedNode tail = head;
            while (tail.getNextNode() != null) {
                tail = tail.getNextNode();
            }
            tail.setNextNode(newNode);
            newNode.setPrevNode(tail);
        }
    }

    public DoubleChainedNode getNodeByValue(int value) {
        DoubleChainedNode node = head;
        while (node != null) {
            if (node.getValue() == value) {
                return node;
            }
            node = node.getNextNode();
        }
        return null;
    }

    public void removeNodeByValue(int value) {
        if (head == null) return;
        if (head.getValue() == value) {
            head = head.getNextNode();
            head.setPrevNode(null);
        } else {
            DoubleChainedNode temp = head;
            while (temp != null && temp.getValue() != value) {
                temp = temp.getNextNode();
            }
            if (temp != null) {
                if (temp.getPrevNode() != null) {
                    temp.getPrevNode().setNextNode(temp.getNextNode());
                }
                if (temp.getNextNode() != null) {
                    temp.getNextNode().setPrevNode(temp.getPrevNode());
                }
            }
        }
    }

    public void listNodes() {
        DoubleChainedNode temp = head;
        System.out.print(" Lista dublu inlantuita: ");
        while (temp != null) {
            System.out.print(temp.getValue() + " ");
            temp = temp.getNextNode();
        }
        System.out.println();
    }

    public int sum() {
        int suma = 0;
        DoubleChainedNode node = head;
        while (node != null) {
            suma += node.getValue();
            node = node.getNextNode();
        }
        return suma;
    }

        public boolean isSorted () {
            DoubleChainedNode temp = head;
            while (temp != null && temp.getNextNode() != null) {
                if (temp.getValue() > temp.getNextNode().getValue()) {
                    return false;
                }
                temp = temp.getNextNode();
            }
            return true;
        }

}
