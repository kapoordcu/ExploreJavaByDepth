package graphs;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    Map<GraphNode, GraphNode> oldToNew = new HashMap<>();

    public GraphNode cloneGraph(GraphNode node) {
        if(node == null) {
            return null;
        }
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        } else {
            GraphNode copy = new GraphNode(node.val);
            oldToNew.put(node, copy);
            for (GraphNode neighbours : node.neighbors) {
                copy.neighbors.add(cloneGraph(neighbours));
            }
            return copy;
        }
    }
}
