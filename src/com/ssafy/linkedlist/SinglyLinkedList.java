package com.ssafy.linkedlist;

public class SinglyLinkedList {
	
	private Node head;
	
	//���� ����Ʈ�� ù��° ���ҷ� �����ϱ�
	public void addFirstNode(String data) {
		Node newNode = new Node(data, head); // ���鸮��Ʈ��� null�� ������, �ƴ϶�� ù ����� reference�� ���´�
		head = newNode;
	}
	
	// ���Ḯ��Ʈ�� ������ ���� ã��
	public Node getLastNode() {
		Node currNode = head;
		if(currNode != null) {
			while(currNode.link != null) {
				currNode = currNode.link;
			}
		}
		return currNode;
	}
	
	//���� ����Ʈ�� ������ ���� �����ϱ�
	public void addLastNode(String data) {
		if(head == null) {
			addFirstNode(data);
			return;
		}
		Node lastNode = getLastNode();
		Node newNode = new Node(data);
		lastNode.link = newNode;
	}
	
	public void insertAfterNode(Node preNode, String data) {
		if(preNode == null) {
			System.out.println("�����尡 ���� ������ �Ұ����մϴ�.");
			return;
		}
		Node newNode = new Node(data, preNode.link);
		preNode.link = newNode;
		
	}
	
	public Node getNode(String data) {
		for(Node currNode=head; currNode != null; currNode = currNode.link) {
			if(currNode.data.equals(data)) {
				return currNode;
			}
		}
		return null;
	}
	
	public Node getPreviousNode(Node target) {
		Node currNode = head, nextNode = null;
		if(currNode != null) {
			while( (nextNode = currNode.link) != null) {
				if(nextNode == target) {
					return currNode;
				}
				currNode = nextNode;
			}
		}
		return null;
	}
	
	public void deleteNode(String data) {
		if(head==null) {
			System.out.println("���鸮��Ʈ���� ������ �Ұ����մϴ�.");
			return;
		}
		Node targetNode = getNode(data);
		if(targetNode == null) return;
		
		Node preNode = getPreviousNode(targetNode);
		
		if(preNode == null && targetNode == head) {
			head = targetNode.link;
		}else {
			preNode.link = targetNode.link;
		}
		
		targetNode.link = null;
	}
	
	public void printList() {
		System.out.print("L = ( ");
		for(Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.data + " ");
		}
		System.out.println(" )");
	}
}
