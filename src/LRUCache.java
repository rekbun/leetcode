/*
http://oj.leetcode.com/problems/lru-cache/
 */
import java.util.HashMap;

    class CacheNode {
		int val;
		int key;
		CacheNode next;
		CacheNode prev;
		public CacheNode(int key,int val,CacheNode prev,CacheNode next) {
			this.val=val;
			this.key=key;
			this.prev=prev;
			this.next=next;
		}
	}
	public class LRUCache {
		HashMap<Integer,CacheNode> map;
		int size;
		CacheNode start;
		CacheNode end;
		public LRUCache(int capacity) {
			map=new HashMap<Integer,CacheNode>();
			size=capacity;
		}

		public int get(int key) {
			if(map.containsKey(key)) {
				CacheNode node=map.get(key);
				if(map.size()>1 && node!=start) {
					if(end==node) {
						end=node.prev;
					}
					if(node.prev!=null) node.prev.next=node.next;
					if(node.next!=null) node.next.prev=node.prev;
					node.next=start;
					start.prev=node;
					start=node;
				}
				return map.get(key).val;
			}else {
				return -1;
			}
		}

		public void set(int key, int value) {
			if(!map.containsKey(key)) {
				if(map.size()==size) {
					CacheNode node=end;
					if(node.prev!=null) node.prev.next=null;
					if(size==1) {
						start=null;
						end=null;
					}else {
						end=end.prev;
					}
					map.remove(node.key);
				}
				if(start==null) {
					start=new CacheNode(key,value,null,null);
					map.put(key,start);
					end=start;
				}else {
					CacheNode node=new CacheNode(key,value,end,null);
					node.next=start;
					node.prev=null;
					start.prev=node;
					start=node;
					map.put(key,node);
				}
			}else {
				map.get(key).val=value;
				get(key);
			}
		}
	}
