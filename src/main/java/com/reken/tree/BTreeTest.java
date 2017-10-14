package com.reken.tree;

/**
 * Created by rhao on 17/10/13.
 */
class BNode {
    private BNode left;
    private BNode right;
    private Integer value;

    public BNode(Integer value){
        this.value = value;
        this.left = null;
        this.right = null;
    }


    public void insert(BNode node) {
        if (this.value==null){
            this.value = node.value;
            return;
        }
        if(this.value>=node.value){
            this.left.insert(node);
        }
        if(this.value<node.value){
            this.right.insert(node);
        }

    }
}

public class BTreeTest {
    public static void main(String[] args) {
        BNode tree = new BNode(null);
        Integer[] data = new Integer[]{5, 6, 5, 7, 1, 2, 4};
        createTree(data, tree);
    }

    public static void createTree(Integer[] data, BNode tree) {
        for (int index = 0; index < data.length; index++) {
            System.out.println(data[index]);
            BNode newNode = new BNode(data[index]);
            tree.insert(newNode);
        }
    }
}
