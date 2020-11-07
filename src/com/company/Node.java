package com.company;

import static com.company.Main.DOWN;
import static com.company.Main.UP;

public class Node {
    public int item;
    public Node next;

    public Node() {
        next = null;
    }

    public Node(int val) {
        item = val;
        next = null;
    }

    public static Node createRandomNode() {
        Node newNode = new Node();
        newNode.item = (int) (Math.random() * (UP - DOWN + 1)) + DOWN;
        return newNode;
    }
}
