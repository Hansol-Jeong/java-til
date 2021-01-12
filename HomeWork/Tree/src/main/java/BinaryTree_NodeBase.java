import lombok.*;

@AllArgsConstructor
@Setter
@Getter
class Node {
    private int value;
    public Node left;
    public Node right;

    public Node(Node left, Node right) {
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree_NodeBase implements Tree{
    private Node root;
    private boolean isFound;
    public Node[] nodeArray;

    public BinaryTree_NodeBase(int [] array) {//초기화 박는 과정 배열을 받으면 그걸 index 기준으로 binaryTree로 변환
        nodeArray = init(array);
    }

    @Override
    public void preorder() {
        preorderHelper(root);
        System.out.println();
    }
    public void preorderHelper(Node root) {//나중에 root노드 지정해 주면 되겠지
        //노드 -> 왼족 -> 오른쪽
        System.out.print(root.getValue() + " ");

        //리컬시브하게!!
        if(root.getLeft() != null) {//left값이 있어요! 그러면 left로 가서노드값을 찍어줘야 겠죠?
//            currNode = currNode.getLeft();//왼쪽 왔다 리컬시브하게하라고
            preorderHelper(root.getLeft());
        } //계속 왼쪾으로 가다가 왼쪽 값 없으면 메소드콜한 이 지점으로 다시 오겠지

        if(root.getRight() != null) {
            preorderHelper(root.getRight());
        }
    }

    @Override
    public void inorder() {
        inorderHelper(root);
        System.out.println();
    }

    public void inorderHelper(Node root) {

        //리컬시브하게!!
        if(root.getLeft() != null) {
            inorderHelper(root.getLeft());
        }

        System.out.print(root.getValue() + " ");

        if(root.getRight() != null) {
            inorderHelper(root.getRight());
        }
    }


    @Override
    public void postorder() {
        postorderHelper(root);
        System.out.println();
    }

    public void postorderHelper(Node root) {
//        Node currNode = root;


        //리컬시브하게!!
        if(root.getLeft() != null) {
            inorderHelper(root.getLeft());
        }

        if(root.getRight() != null) {
            inorderHelper(root.getRight());
        }

        System.out.print(root.getValue() + " ");
    }

    @Override
    public boolean bfs(int value) {
        for(Node elem : nodeArray) {
            if(elem.getValue() == value)
                return true;
        }
        return false;
    }

    @Override
    public boolean dfs(int value) {
        isFound = false;

        dfsHelper(root, value);
        return isFound;
    }

    public void dfsHelper(Node root, int value) {
        if(isFound)
            return; //메소드의 종료를 위해 리컬시브 다 종료시킴

        if(root.getValue() == value) {
            isFound = true;
            return; //찾으면 끝내고
        }
        //못찾으면
        if(root.getLeft() != null) {
            dfsHelper(root.getLeft(), value);//왼쪽가서 값이랑 맞는지 다시 비교해봐
        }
        if(root.getRight() != null) {
            dfsHelper(root.getRight(), value);//왼쪽가서 값이랑 맞는지 다시 비교해봐
        }
    }

    public Node[] init(int [] array) {

        Node [] nodeArray = new Node[array.length];// 해당 배열의 길이만큼 노드 배열을 만들고
        for(int i = 0; i < nodeArray.length; i++) {// 이렇게 나눠서 하면돼 -> 예상: nodeArray[]배열 값 내부가 null이어서 참조를 못했나?
            nodeArray[i] = new Node(array[i], null, null);
        }
        for(int i = 0; i < nodeArray.length; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < array.length) {
                nodeArray[i].setLeft(nodeArray[left]);
            }
            if(right < array.length) {
                nodeArray[i].setRight(nodeArray[right]);
            }
        }
 /*       for (int i = 0; i < nodeArray.length; i++) { //left right 설정이 안되잖아? 왜ㅏㅇ노디느대럼ㄷ러ㅣㅁㅈ덜
            nodeArray[i] = new Node(array[i], null, null);
           *//* nodeArray[i] = new Node.NodeBuilder()
                    .value(array[i])
                    .left(null)
                    .right(null).build();//root노드만 정의하고 left right 는 null로 줬어*//*
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if(left < array.length) {
//                nodeArray[i].setLeft(nodeArray[left]);//nodeArray[0]의 left 는 nodeArray[1]
                nodeArray[i].left = nodeArray[left];
            }
            if(right < array.length) {
//                nodeArray[i].setRight(nodeArray[right]);
                nodeArray[i].right = nodeArray[right];
            }
        }*/
        root = nodeArray[0];
        return nodeArray;
    }
}
class BinaryTreeTest_NodeBase {
    public static void main(String[] args) {
        int [] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree_NodeBase tree = new BinaryTree_NodeBase(array);

        tree.preorder();
        tree.inorder();
        tree.postorder();

        System.out.println(tree.bfs(2));
        System.out.println(tree.bfs(10));

        System.out.println(tree.dfs(5));
        System.out.println(tree.dfs(14));
    }
}