public class BinaryTree {
    private int [] array;

    public BinaryTree(int [] array) {
        this.array = array;
    }

    public void preorder() {
        String s = "";
        for (int i = 0; i < level() + 1; i++) {
            for (int j = 0; j < (2 ^ i); j++) {

            }
        }
    }

    public void inorder() {
        String s = "[ ";
        for(int i = 0; i < array.length; i++) {
            s += (2 ^ level());
        }
    }

    public void postorder() {

    }

    public boolean bfs(int value) {
        return true;
    }

    public boolean dfs(int value) {
        return true;
    }
    public int level() {
        int level = 0;
        int count = 0;
        while(true) {
            count += (2 ^ level);
            if(array.length -  count < 0)
                break;
            level++;
        }
        level += 1;//level 3
        return level;
    }
}


class BinaryTreeTest {
    public static void main(String[] args) {
        int [] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree tree = new BinaryTree(array);

        tree.preorder();
//        tree.inorder();
//        tree.postorder();
//
//        System.out.println(tree.bfs(2));
//        System.out.println(tree.bfs(10));
//
//        System.out.println(tree.dfs(5));
//        System.out.println(tree.dfs(14));
    }
}