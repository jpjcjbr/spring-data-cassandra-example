package example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.api.java.function.Function2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastax.spark.connector.japi.CassandraJavaUtil;
import com.datastax.spark.connector.japi.CassandraRow;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfiguration.class)
public class SummarizeWithSparkTest {

	@Test
	public void test() {
		SparkConf conf = new SparkConf(true);
        conf.setMaster("local[8]");
        conf.setAppName("TesteJP");
//        conf.set("spark.cassandra.connection.host", "45.55.242.193");
//        conf.set("spark.cassandra.auth.username", "cassandra");
//        conf.set("spark.cassandra.auth.password", "cassandra");
		JavaSparkContext sc = new JavaSparkContext(conf);
		
		System.out.println("Spark context created");
		
		long time = System.currentTimeMillis();
		
		Map<String, Long> reduce = CassandraJavaUtil.javaFunctions(sc).cassandraTable("events", "event")
				.map(new MapFunction())
				.reduce(new ReduceFunction());
        
        System.out.println("reduced in " + (System.currentTimeMillis() - time));
        System.out.println("result = " + reduce);
	}
}

class MapFunction implements Function<CassandraRow, Map<String, Long>>, Serializable {
	
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

class ReduceFunction implements Function2<Map<String, Long>, Map<String, Long>, Map<String, Long>>, Serializable {

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
