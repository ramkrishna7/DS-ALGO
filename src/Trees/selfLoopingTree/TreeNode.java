package selfLoopingTree;

public class TreeNode {
    private int value;
    private TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = this;
        this.right = this;
    }

    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}
