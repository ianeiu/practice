package com.wm.sf;

/**
 * @Description: 前中后序遍历
 * @author: wm
 * @date: 2018年12月19日 上午10:10:16
 * @version: 1.0
 */
public class ErgodicQZH {

	public static void main(String[] args) {
		Node node = new Node("Node");
		Node nodeL = new Node("nodeL");
		Node nodeR = new Node("nodeR");
		
		Node nodeLL = new Node("nodeLL");
		Node nodeLR = new Node("nodeLR");
		Node nodeRL = new Node("nodeRL");
		Node nodeRR = new Node("nodeRR");
		
		Node nodeLLL = new Node("nodeLLL");
		
		nodeLL.left = nodeLLL;
		nodeL.left = nodeLL;
		nodeL.right = nodeLR;
		nodeR.left = nodeRL;
		nodeR.right = nodeRR;
		node.left = nodeL;
		node.right = nodeR;
		
		preOrder(node);
		System.out.println();
		System.out.println("------------");
		inOrder(node);
		System.out.println();
		System.out.println("------------");
		posOrder(node);
	}
	
	/**
     * 前序遍历
     * @param node
     */
	public static void preOrder(Node node){
		if(node == null) return;
		System.out.print(node.value + " ");
		
		preOrder(node.left);
		preOrder(node.right);
		
	}
	
	/**
     * 中序遍历
     * @param node
     */
    public static void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }
    
    /**
     * 后序遍历
     * @param node
     */
    public static void posOrder(Node node){
        if(node == null){
            return;
        }
        posOrder(node.left);
        posOrder(node.right);
        System.out.print(node.value + " ");
    }
	
}

class Node{
	String value;
	Node left;
	Node right;
	
	public Node(String i){
		this.value = i;
	}
}
