package ro.ulbs.paradigme.lab2.doublechained;

import ro.ulbs.paradigme.lab2.api.Node;

public class DoubleChainedNode implements Node {
    private int value;
    private DoubleChainedNode pnode;
    private DoubleChainedNode nnode;

    @Override
    public int getValue() {

        return value;
    }
    public DoubleChainedNode(int value) {
        this.value = value;
    }
    @Override
    public void setValue(int val) {

        this.value = val;
    }

    public DoubleChainedNode getPrevNode() {

        return pnode;
    }

    public void setPrevNode(DoubleChainedNode prevNode) {

        this.pnode = prevNode;
    }

    public DoubleChainedNode getNextNode() {

        return nnode;
    }

    public void setNextNode(DoubleChainedNode nnode) {

        this.nnode = nnode;
    }
}
