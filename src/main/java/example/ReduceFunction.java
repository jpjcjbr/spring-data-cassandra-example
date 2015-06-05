package example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.function.Function2;

public class ReduceFunction implements Function2<Map<String, Long>, Map<String, Long>, Map<String, Long>>, Serializable {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Long> call(Map<String, Long> event1, Map<String, Long> event2) throws Exception {
		
		return mergeAndAdd(event1, event2);
	}
	
	@SuppressWarnings("unchecked")
	public static <K> Map<K, Long> mergeAndAdd(Map<K, Long>... maps) {
	    Map<K, Long> result = new HashMap<>();
	    for (Map<K, Long> map : maps) {
	        for (Map.Entry<K, Long> entry : map.entrySet()) {
	            K key = entry.getKey();
	            Long current = result.get(key);
	            result.put(key, current == null ? entry.getValue() : entry.getValue() + current);
	        }
	    }
	    return result;
	}
	
}
