
public class BinaryTree implements Tree{
    private int [] array;
    public boolean isFound; //전역변수니까 초기값 false

    public BinaryTree(int [] array) {
        this.array = array;
    }

    @Override
    public void preorder() {
        preorderHelper(0);
        System.out.println("");
    }

    private void preorderHelper(int index) {
        System.out.println(array[index] + " ");

        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < array.length) {
            preorderHelper(left);
        }
        if(right < array.length) {
            preorderHelper(right);
        } //리컬시브하게
    }

    @Override
    public void inorder() {
        inorderHelper(0);
        System.out.println("");
    }

    private void inorderHelper(int index) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < array.length) {
            inorderHelper(left);
        }
        System.out.println(array[index] + " ");

        if(right < array.length) {
            inorderHelper(right);
        }

    }

    @Override
    public void postorder() {
        postorderHelper(0);
        System.out.println("");
    }

    public void postorderHelper(int index) {
        //좌측 끝으로 갔다가 더이상 볼 거 없으면 메소드콜할 곳으로 돌아가고 우측끝으로 갔다가 메소드 콜한 곳으로 돌아가서 노드 출력
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if(left < array.length) {//좌측 노드가 계속 존재하면
            postorderHelper(left);//계속 리컬시브하게 왼쪽으로 가
        }
        //더이상 왼쪽 오른쪽 으로 갈 게없으면 노드 찍고 메소드 콜 한 이곳으로 돌아오겟지
        if(right < array.length) {
            postorderHelper(right); //오른쪽으로 순회공연 가
        }

        //왼쪽 오른쪽 다없으면 노드찍어
        System.out.println(array[index] + " ");
    }

    @Override
    public boolean bfs(int value) {// 너비 우선 탐색
        for(int elem : array) { //array의 요소 다 뜯어볼거구
            if(elem == value) {
                return true; //일치하면 트루리턴해
            }
        }
        return false;
    }

    @Override
    public boolean dfs(int value) {
        isFound = false;
        dfsHelper(0, value);
        return isFound;
    }

    private void dfsHelper(int index, int value) {
        if(isFound) {
            return;
        }//리컬시브하게 할 거니까 isFound가 treu가 되면 끝내라고 이미 찾은 시점이니까 근데 이게 왜 필요해? 92번쨰 줄에서 다 처리되는데 -> 없어도 되긴하는데 더 빨리 끝낼 수 있어 -> 아니야 빙시야 이거 없으면 안끝나

        if(array[index] == value) {
            isFound = true;
            return; //index 가 0인 시점에서 값을 찾앗으면 isFound true로 만들고 종료
        }

        int left = index * 2 + 1;
        int right = index * 2 + 2;
        if(left < array.length) {
            dfsHelper(left, value); //isFound = true로 못 만들었어? -> left로 가 죽쭉쭊 가 가다가 isFound = true 로 만들면 메소드 콜 한 지점으로 돌아가
        }
        if(right < array.length) {
            dfsHelper(right, value);
        }
    }

}
class BinaryTreeTest {
    public static void main(String[] args) {
        int [] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree tree = new BinaryTree(array);
//
//        tree.preorder();
//        tree.inorder();
//        tree.postorder();
//        System.out.println(tree.isFound);

//        System.out.println(tree.bfs(2));
//        System.out.println(tree.bfs(10));

        System.out.println(tree.dfs(5));
        System.out.println(tree.dfs(14));

    }
}