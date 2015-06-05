package example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import example.domain.Event2;
import example.domain.Event2Repository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfiguration.class)
public class PopulateCassandra2Test {

    private static final long NUMBER_OF_CATEGORIES = 100L;

	private static final long CHUNK_SIZE = 10000L;

	private static final long TOTAL_EVENTS = 2000000L;

	@Autowired
    private CassandraAdminOperations adminTemplate;

    @Autowired
    private Event2Repository event2Repository;
    
    @Before
    public void setUp() {
    	adminTemplate.truncate(CqlIdentifier.cqlId("event2"));
    }

    @Test
    public void repositoryStoresAndRetrievesEvents() {
    	List<Event2> events = new ArrayList<Event2>();
    	
    	long time = System.currentTimeMillis();
    	
    	Map<String, Long> map = getMap();
    	
    	for(long i = 1; i <= TOTAL_EVENTS; i++) {
    		Event2 e = new Event2();
    		e.setSku(i);
    		e.setCategory1(i % NUMBER_OF_CATEGORIES);
    		e.setCategory2(NUMBER_OF_CATEGORIES - (i % NUMBER_OF_CATEGORIES));
    		e.setCategory3(i % NUMBER_OF_CATEGORIES);
    		e.setCategory4(i % NUMBER_OF_CATEGORIES);
    		
			e.setIndicators(map);
    		
			events.add(e);
    		
    		if(i % CHUNK_SIZE == 0) {
    			System.out.println("processing " + i);
    			event2Repository.save(events);
    			events.clear();
    		}
    	}
    	
        System.out.println(System.currentTimeMillis() - time);
    }

	private Map<String, Long> getMap() {
		Map<String, Long> hashMap = new HashMap<String, Long>();
		
		for(int i = 1; i <= 20; i++) {
			hashMap.put("indicator" + i, 1L);
		}
		
		return hashMap;
	}
}