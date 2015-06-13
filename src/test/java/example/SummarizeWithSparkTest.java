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
        conf.setMaster("spark://anil:7077");
//        conf.setMaster("spark://MacBook-Pro.local:7077");
        conf.setAppName("TesteJP");
        conf.set("spark.cassandra.connection.host", "172.17.9.172");
//        conf.set("spark.cassandra.auth.username", "cassandra");
//        conf.set("spark.cassandra.auth.password", "cassandra");
		JavaSparkContext sc = new JavaSparkContext(conf);
		sc.addJar("target/spring-data-cassandra-example-1.0-SNAPSHOT-jar-with-dependencies.jar");
		
		System.out.println("Spark context created");
		
		long time = System.currentTimeMillis();
		
		Map<String, Long> reduce = CassandraJavaUtil.javaFunctions(sc).cassandraTable("events", "event")
				.map(new MapFunction())
				.reduce(new ReduceFunction());
        
        System.out.println("reduced in " + (System.currentTimeMillis() - time));
        System.out.println("result = " + reduce);
	}
}