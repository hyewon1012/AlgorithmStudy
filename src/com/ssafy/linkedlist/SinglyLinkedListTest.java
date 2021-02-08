package com.ssafy.linkedlist;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLastNode("������");
		System.out.println(list.getLastNode());
		list.printList();
		
		list.addLastNode("������");
		list.printList();
		
		list.addFirstNode("�����");
		list.printList();
		
		Node preNode = list.getNode("������");
		
		list.insertAfterNode(preNode, "�����");
		list.printList();
		
		System.out.println(list.getPreviousNode(list.getNode("������")));
		
		list.deleteNode("������");
		list.printList();
		
		list.deleteNode("������");
		list.printList();
		
		list.deleteNode("�����");
		list.printList();
		
		list.deleteNode("�����");
		list.printList();
	}

}
