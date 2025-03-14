package ro.ulbs.paradigme.lab2.simplechained;

import ro.ulbs.paradigme.lab2.api.Node;

public class SimpleChainedNode implements Node {
    private int value;
    private SimpleChainedNode nextNode;

    @Override
    public int getValue() {
        return value;
    }
    @Override
    public void setValue(int val) {
        this.value = val;
    }
    public SimpleChainedNode getNextNode() {
        return nextNode;
    }
    public void setNextNode(SimpleChainedNode n) {
        this.nextNode = n;
    }
    public SimpleChainedNode(int value) {
        this.value = value;
    }
}
