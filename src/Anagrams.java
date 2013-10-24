import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: rakeshkumar
 * Date: 10/23/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Anagrams {
	public ArrayList<String> anagrams(String[] strs) {
		if(strs==null || strs.length==0) {
			return new ArrayList<String>();
		}

		HashMap<String,ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for(int i=0;i<strs.length;i++) {
			char[] array=strs[i].toCharArray();
			Arrays.sort(array);
			String sorted= new String(array);

			if(!map.containsKey(sorted)) {
				map.put(sorted,new ArrayList<String>());
			}
			map.get(sorted).add(strs[i]);

		}

		ArrayList<String> ret= new ArrayList<String>();
		for(ArrayList<String> strlist: map.values()) {
			if(strlist.size()>1) {
				ret.addAll(strlist);
			}
		}

		return ret;
	}
}
