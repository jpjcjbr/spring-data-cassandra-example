package example;

import java.util.Map;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.datastax.spark.connector.japi.CassandraJavaUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfiguration.class)
public class SummarizeWithSpark2Test {

	@Test
	public void test() {
		SparkConf conf = new SparkConf(true);
		conf.setMaster("spark://cassandra:7077");
        conf.setAppName("TesteJP");
        conf.set("spark.cassandra.connection.host", "104.131.184.53");
//        conf.set("spark.cassandra.auth.username", "cassandra");
//        conf.set("spark.cassandra.auth.password", "cassandra");
		JavaSparkContext sc = new JavaSparkContext(conf);
		sc.addJar("target/spring-data-cassandra-example-1.0-SNAPSHOT-jar-with-dependencies.jar");
		
		System.out.println("Spark context created");
		
		long time = System.currentTimeMillis();
		
		Map<String, Long> reduce = CassandraJavaUtil.javaFunctions(sc).cassandraTable("events", "event2")
//				.map(new MapFunction2(Sets.newHashSet(1L)))
				.map(new MapFunction2WithFilter())
				.reduce(new ReduceFunction());
        
        System.out.println("reduced in " + (System.currentTimeMillis() - time));
        System.out.println("result = " + reduce);
	}
}