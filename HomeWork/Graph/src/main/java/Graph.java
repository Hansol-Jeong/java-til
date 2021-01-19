import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

class Vertex {
    public int value;
//    List<Integer> adjList; //이걸로 코딩하다가 자꾸 의문이들어서 재량껏 바꿧습니다 -> Integer로만 인접 vertex를 구분하면 다른 Vertex객체에 중복 value가 있다면 구분을 못하지 않는가
    //사실 기반코드해석이안되는점도있긴합니다
    List<Vertex> adjList; //이렇게 해야 vertex들을 비교할 수 있을거같다고생각을 했습니다.

    public Vertex(int value, List<Vertex> adjList) {
        this.value = value;
        this.adjList = adjList;
    }
}
public class Graph {
    List<Vertex> vertexList = new ArrayList<>();
    List<Vertex> visitedVertex = new ArrayList<>();
    boolean isFound = false;

    public void insert(int value, Vertex [] adjVertices) {
        List<Vertex> adjList = new ArrayList<>();

        for (Vertex idx: adjVertices) {
            adjList.add(idx);
        }
        Vertex v = new Vertex(value, adjList);

        for(Vertex adjV: v.adjList) {

            vertexList.get(vertexList.indexOf(adjV)).adjList.add(v);
        }
        vertexList.add(v);
    }
    public boolean bfs(int ind, int value) {
        Queue<Vertex> vertexQueue = new LinkedList<>();
        Vertex readyVertex = vertexList.get(ind);
        vertexQueue.offer(readyVertex);
        visitedVertex.add(readyVertex);
        while(vertexQueue.size() != 0) {
            Vertex pollingVertex = vertexQueue.poll();
            if (pollingVertex.value == value) {
                visitedVertex = new ArrayList<>();
                return true;
            }
            for (Vertex forInspection : pollingVertex.adjList) {
                    if(!visitedVertex.contains(forInspection)) {
                        vertexQueue.offer(forInspection);
                        visitedVertex.add(forInspection);
                    }
                visitedVertex = visitedVertex.stream().distinct().collect(Collectors.toList());
            }
        }
        visitedVertex = new ArrayList<>();
        return false;
    }
    public boolean dfs(int ind, int value) {
        isFound = false;
        Vertex currVertex = vertexList.get(ind);

        if(currVertex.value == value) {
            isFound = true;
            return true;
        }


        if(visitedVertex.size() == vertexList.size()) {
            visitedVertex = new ArrayList<>();
            return false;
        }

            if(!visitedVertex.contains(currVertex)) {
                visitedVertex.add(currVertex);
                for(int i = 0; i < currVertex.adjList.size(); i++) {
                    if(!visitedVertex.contains(currVertex.adjList.get(i))) {
                        ind = vertexList.indexOf(currVertex.adjList.get(i));
                        dfs(ind, value);
                        if (isFound) {
                            visitedVertex = new ArrayList<>();
                            return true;
                        }
                    }
                }
            }
            return false;
    }

    public static void main(String[] args) {
        Graph g = new Graph();

        Vertex [] array1 = {};
        g.insert(0, array1);

        g.insert(1,new Vertex[] {g.vertexList.get(0)});

        g.insert(2, new Vertex [] {g.vertexList.get(1)});

        g.insert(3, new Vertex[] {g.vertexList.get(0), g.vertexList.get(2)});

        g.insert(4, new Vertex[] {g.vertexList.get(3)});

        System.out.println(g.bfs(0, 2));
        System.out.println(g.bfs(0, 6));
        System.out.println(g.dfs(0, 2));
        System.out.println(g.dfs(0, 6));
    }
}
