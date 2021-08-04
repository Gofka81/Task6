package com.epam.rd.java.basic.practice6.part5;


public class Tree<E extends Comparable<E>>{

    private Node<E> root;
    private int size = 0;

    public boolean add(E element) {
        if(root == null){
            root = new Node<>(element);
            return true;
        }
        if(isInTree(root,element) != null){
            return false;
        }
        Node<E> temp = root;
        Node<E> parent;
        size++;
        while (true) {
            parent= temp;
            if(temp.data.compareTo(element) >0){
                temp = temp.left;
                if(temp == null){
                    parent.left = new Node<>(element);
                    return true;
                }
            }
            else{
                temp = temp.right;
                if(temp == null){
                    parent.right = new Node<>(element);
                    return true;
                }
            }
        }
    }

    public void add(E[] elements) {
        for(E element :elements){
            add(element);
        }
    }

    public boolean remove(E element) {
        if(isInTree(root,element) != null) {
            root = findAndDelete(root, element);
            size--;
            return true;
        }
        return false;
    }

    public Node<E> findAndDelete(Node<E> root,E element){
        if (root == null)
            return root;

        if (element.compareTo(root.data) < 0)
            root.left = findAndDelete(root.left, element);
        else if (element.compareTo(root.data) > 0)
            root.right = findAndDelete(root.right, element);

        else {

            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = findAndDelete(root.right, root.data);
        }

        return root;
    }

    public E minValue(Node<E> root)
    {
        E minv =  root.data;
        while (root.left != null)
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public Node<E> isInTree(Node<E> root, E element){
        if(root == null || root.data.compareTo(element) == 0){
            return root;
        }
        if(element.compareTo(root.data) > 0){
            return isInTree(root.right,element);
        }
        return isInTree(root.left,element);
    }

    public void print() {
        print2DUtil(root,0);
    }

    public void print2DUtil(Node root, int space)
    {
        if (root == null)
            return;

        space += 2;

        print2DUtil(root.left, space);


        System.out.print("\n");
        for (int i = 2; i < space; i++)
            System.out.print(" ");
        System.out.print(root.data + "\n");

        print2DUtil(root.right, space);
    }

    private static final class Node<E> {
        private Node<E> right;
        private Node<E> left;
        private E data;

        public Node(E data){
            this.data = data;
        }

    }

}
