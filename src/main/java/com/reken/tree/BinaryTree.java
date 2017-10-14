package com.reken.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rhao on 17/10/14.
 */

public class BinaryTree {

    private Node root;

    class Node  implements TreePrinter.PrintableNode {
        private Node left;
        private Node right;
        private int data;

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public String getText() {
            return String.valueOf(data);
        }

        public Node(int data) {
            this.left = null;
            this.right = null;
            this.data = data;
        }
    }

    public BinaryTree(){
        root = null;
    }

    /**
     * 递归创建二叉树
     * @param node
     * @param data
     */
    public void buildTree(Node node, int data){
        if(root == null){
            root = new Node(data);
        }else{
            if(data < node.data){
                if(node.left == null){
                    node.left = new Node(data);
                }else{
                    buildTree(node.left,data);
                }
            }else{
                if(node.right == null){
                    node.right = new Node(data);
                }else{
                    buildTree(node.right,data);
                }
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrder(Node node){
        if(node != null){
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 中序遍历
     * @param node
     */
    public void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrder(Node node){
        if(node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.println(node.data);
        }
    }

    public void print() {
        print("", this.root, false);
    }

    public void print(String prefix, Node n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }


    public static void main(String[] args) {
        int[] a = {8,4,12,2,6,10,14,1,3,5,7,9,11,13,20,15};
        BinaryTree bTree = new BinaryTree();
        for (int i = 0; i < a.length; i++) {
            bTree.buildTree(bTree.root, a[i]);
        }
        System.out.println("preorder:");
        bTree.preOrder(bTree.root);
        System.out.println("Inorder:");
        bTree.inOrder(bTree.root);
        System.out.println("Postorder:");
        bTree.postOrder(bTree.root);
        TreePrinter.print(bTree.root);
        bTree.print();
    }
}





