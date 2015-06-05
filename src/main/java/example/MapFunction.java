package example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.api.java.function.Function;

import com.datastax.spark.connector.japi.CassandraRow;

public class MapFunction implements Function<CassandraRow, Map<String, Long>>, Serializable {
	
	private static final long serialVersionUID = 1L;

	public Map<String, Long> call(CassandraRow v1) throws Exception {
		HashMap<String, Long> map = new HashMap<String, Long>();
		
		for(int i = 1; i <= 20; i++) {
			map.put(i + "-" + v1.getLong("category1"), v1.getLong("indicator" + i));
			map.put(i + "-" + v1.getLong("category2"), v1.getLong("indicator" + i));
			map.put(i + "-" + v1.getLong("category3"), v1.getLong("indicator" + i));
			map.put(i + "-" + v1.getLong("category4"), v1.getLong("indicator" + i));
		}
		
		return map;
	}
	
}
