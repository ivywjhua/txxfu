package org.wjhua.twquiz.domain2;

class Node {
	Node next;
	String value;
}

public class TestLinkedNodeMain {

	public boolean testLinkedListCircle(Node aNode) {
		if (null == aNode) {
			return false;
		}

		if (null == aNode.next) {
			return false;
		}

		if (aNode.next == aNode) {
			return true;
		}

		Node firstNode = aNode.next;
		Node secondNode = aNode.next.next;

		while (null != firstNode && null != secondNode) {
			firstNode = firstNode.next;
			if (null == firstNode) {
				break;
			}
			firstNode = firstNode.next;
			secondNode = secondNode.next;
			if (firstNode == secondNode) {
				firstNode.next = null;
				break;
			}
		}

		return firstNode == secondNode;
	}
	
	
}
