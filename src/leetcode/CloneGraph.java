package leetcode;/*
http://oj.leetcode.com/problems/clone-graph/
 */
import java.util.HashMap;

public class CloneGraph {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node==null) {
			return node;
		}

		return cloneGraphUtil(node,new HashMap<Integer,UndirectedGraphNode>());
	}

	public UndirectedGraphNode cloneGraphUtil(UndirectedGraphNode root,HashMap<Integer,UndirectedGraphNode> map) {
		if(root==null) {
			return root;
		}

		map.put(root.label,new UndirectedGraphNode(root.label));

		for(UndirectedGraphNode node:root.neighbors) {
			if(!map.containsKey(node.label)) {
				map.get(root.label).neighbors.add(cloneGraphUtil(node,map));
			}else {
				map.get(root.label).neighbors.add(map.get(node.label));
			}
		}
		return map.get(root.label);
	}
}
