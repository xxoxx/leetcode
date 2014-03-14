import java.awt.geom.RoundRectangle2D;
import java.util.*;

/**
 * Created by szhu on 2014-03-13.
 */

class UndirectedGraphNode {
     int label;
     ArrayList<UndirectedGraphNode> neighbors;
     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 };

public class CloneUndirectedGraph {

    public static void main(String []args){
        UndirectedGraphNode [] graph = {new UndirectedGraphNode(1), new UndirectedGraphNode(2), new UndirectedGraphNode(3)};

        graph[0].neighbors.add(graph[1]);
        graph[0].neighbors.add(graph[2]);
        graph[1].neighbors.add(graph[2]);
        CloneUndirectedGraph cloneUndirectedGraph = new CloneUndirectedGraph();
        cloneUndirectedGraph.cloneGraph(graph[0]);
    }
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        LinkedList<UndirectedGraphNode> linkedList = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode>  map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        UndirectedGraphNode p = node;
        if(p == null)
            return p;
        linkedList.add(p);
        map.put(p, new UndirectedGraphNode(p.label));
        while(!linkedList.isEmpty()){
            p = linkedList.pop();
            for(UndirectedGraphNode neighbor: p.neighbors){
                if(!map.containsKey(neighbor)){
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    linkedList.add(neighbor);
                }
                map.get(p).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }
}
