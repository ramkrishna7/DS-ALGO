package trees;

public class SelfLoopingTree {
    private TreeNode root;

    public static void main(String[] args) {
        SelfLoopingTree selfLoopingTree = new SelfLoopingTree();
        selfLoopingTree.buildSelfLoopingTree();
        selfLoopingTree.inorderTraversal(selfLoopingTree.root);
    }

    public void inorderTraversal(TreeNode node) {
        if (isIntermediaryLeafNode(node) || isLeftmostLeafNode(node) || isRightmostLeafNode(node)) {
            printNodeValue(node);
            return;
        }

        if (node.getLeft() != node) {
            inorderTraversal(node.getLeft());
        }

        printNodeValue(node);

        if (node.getRight() != node) {
            inorderTraversal(node.getRight());
        }
    }

    private boolean isLeftmostLeafNode(TreeNode node) {
        return node.getLeft() == node && node.getRight().getLeft() == node;
    }

    private boolean isRightmostLeafNode(TreeNode node) {
        return node.getRight() == node && node.getLeft().getRight() == node;
    }

    private boolean isIntermediaryLeafNode(TreeNode node) {
        return node.getLeft().getRight() == node && node.getRight().getRight() == node;
    }

    private void printNodeValue(TreeNode node) {
        System.out.printf("%s ", node.getValue());
    }

    private void buildSelfLoopingTree() {
        root = new TreeNode(6);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(8));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(4));
        root.getLeft().getLeft().setLeft(new TreeNode(1));
        root.getLeft().getLeft().setRight(root.getLeft().getLeft());
        root.getLeft().getLeft().getLeft().setRight(root.getLeft().getLeft().getLeft());
        root.getLeft().getRight().setLeft(root.getLeft().getRight());
        root.getLeft().getRight().setRight(new TreeNode(5));
        root.getLeft().getLeft().getLeft().setRight(root.getLeft().getRight().getRight());
        root.getLeft().getRight().getRight().setLeft(root.getLeft().getLeft().getLeft());
        root.setRight(new TreeNode(8));
        root.getRight().setLeft(new TreeNode(7));
        root.getRight().setRight(root.getRight());
        root.getRight().getLeft().setLeft(root.getLeft().getRight().getRight());
        root.getRight().getLeft().setRight(root.getRight().getLeft());
        root.getLeft().getRight().getRight().setRight(root.getRight().getLeft());
    }
}

