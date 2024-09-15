public class LinkedList {
    public Node headNode;

    public void addNode(int x, int y) {
        // create new node with x and y params
        Node newNode = new Node(x, y);
        // set nextNode on new node object to existing headNode object
        newNode.nextNode = headNode;
        // assign new node object to headNode variable
        headNode = newNode;
    }

    public void removeNode() {
        // needs to change current head node that is in nextNode variable
        headNode = headNode.nextNode;
        // needs to return that previous head node to the method caller

        // essentially, taking head node out of linked list and returning it
            // and setting next node in line as the new head node
    }

    public Node getHeadNode() {
        return headNode;
    }
}
