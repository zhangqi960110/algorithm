package algorithm.tree;

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

    private BinaryNode<AnyType> root;

    private static class BinaryNode<AnyType> {
        AnyType element;
        BinaryNode<AnyType> left;
        BinaryNode<AnyType> right;

        BinaryNode(AnyType theElement) {
            this(theElement, null, null);
        }

        BinaryNode(AnyType theElement, BinaryNode<AnyType> lt,
                   BinaryNode<AnyType> rt) {
            element = theElement;
            left = lt;
            right = rt;
        }
    }

    public BinarySearchTree() {
        makeEmpty();
    }

    /**
     * 使树为空树
     */
    public void makeEmpty() {
        root = null;
    }

    /**
     * 该树是否为空树
     *
     * @return 是否空
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * 该树是否存在含有参数值的节点
     *
     * @param value
     *            元素值
     * @return 是否含该元素
     */
    public boolean contains(AnyType value) {
        return contains(value, root);
    }

    /**
     * 某个节点及它的子节点是否存在含有参数值的节点
     *
     * @param value
     *            元素值
     * @param node
     *            节点
     * @return
     */
    private boolean contains(AnyType value, BinaryNode<AnyType> node) {
        if (node == null) {
            return false;
        }
        int compareResult = value.compareTo(node.element);
        if (compareResult < 0) { // 插入节点值小于节点值，则递归查找左子树下
            return contains(value, node.left);
        } else if (compareResult > 0) { // 插入节点值大于节点值，则递归查找右子树下
            return contains(value, node.right);
        } else {
            return true;
        }
    }

    /**
     * 查找该树最小元素值
     *
     * @return 最小元素值
     */
    public AnyType findMin() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return findMin(root).element;
    }

    /**
     * 查找某节点及其子树中的最小元素
     *
     * @param node
     *            父节点
     * @return 最小元素所在节点
     */
    private BinaryNode<AnyType> findMin(BinaryNode<AnyType> node) {
        if (node == null) {
            return null;
        } else if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    /**
     * 查找该树最大元素值
     *
     * @return 最大元素值
     */
    public AnyType findMax() {
        if (isEmpty()) {
            throw new NullPointerException();
        }
        return findMavalue(root).element;
    }

    /**
     * 查找某节点及其子树中的最大元素
     *
     * @param node
     *            父节点
     * @return 最大元素
     */
    private BinaryNode<AnyType> findMavalue(BinaryNode<AnyType> node) {
        if (node == null) {
            return null;
        } else if (node.right == null) {
            return node;
        }
        return findMavalue(node.right);
    }

    /**
     * 向树中插入某元素
     *
     * @param value
     *            插入元素值
     */
    public void insert(AnyType value) {
        root = insert(value, root);
    }

    /**
     * 向某个节点下插入元素
     *
     * @param value
     *            元素值
     * @param node
     *            父节点
     * @return 元素插入的节点
     */
    private BinaryNode<AnyType> insert(AnyType value, BinaryNode<AnyType> node) {
        if (node == null) {
            return new BinaryNode<AnyType>(value);
        }
        int compareResult = value.compareTo(node.element);
        if (compareResult < 0) {
            node.left = insert(value, node.left);
        } else if (compareResult > 0) {
            node.right = insert(value, node.right);
        }
        return node;
    }

    /**
     * 向树中删除某元素
     *
     * @param value
     *            元素值
     */
    public void remove(AnyType value) {
        root = remove(value, root);
    }

    /**
     * 在某个节点下删除元素
     *
     * @param value
     *            元素值
     * @param node
     *            父节点
     * @return 删除元素的节点
     */
    private BinaryNode<AnyType> remove(AnyType value, BinaryNode<AnyType> node) {
        if (node == null) {
            return node;
        }
        int compareResult = value.compareTo(node.element);
        if (compareResult < 0) {
            node.left = remove(value, node.left);
        } else if (compareResult > 0) {
            node.right = remove(value, node.right);
        } else if (node.left != null && node.right != null) {
            node.element = findMin(node.right).element;
            node.right = remove(node.element, node.right);
        } else {
            node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    /**
     * 遍历输出树
     */
    public void printTree() {
        if (isEmpty()) {
            System.out.println("Empty tree");
        } else {
            printTree(root);
        }
    }

    /**
     * 先序遍历输出某节点下元素
     *
     * @param node
     *            节点
     */
    private void printTree(BinaryNode<AnyType> node) {
        if (node != null) {
            printTree(node.left);
            printTree(node.right);
            System.out.print(node.element + " ");

        }
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(3);
        tree.insert(6);
        tree.insert(9);
        tree.insert(5);
        tree.insert(1);
        tree.printTree();
        tree.remove(2);
        tree.remove(6);
        tree.insert(5);
        tree.insert(7);
        System.out.println("\n------------");
        tree.printTree();
    }
}