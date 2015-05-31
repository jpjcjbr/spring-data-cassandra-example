package example;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.cql.CqlIdentifier;
import org.springframework.data.cassandra.core.CassandraAdminOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import example.domain.Event;
import example.domain.EventRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CassandraConfiguration.class)
public class PopulateCassandraTest {

    private static final long NUMBER_OF_CATEGORIES = 100L;

	private static final long CHUNK_SIZE = 10000L;

	private static final long TOTAL_EVENTS = 2000000L;

	@Autowired
    private CassandraAdminOperations adminTemplate;

    @Autowired
    private EventRepository eventRepository;
    
    public void setUp() {
    	adminTemplate.truncate(CqlIdentifier.cqlId("event"));
    }

    @Test
    public void repositoryStoresAndRetrievesEvents() {
    	List<Event> events = new ArrayList<Event>();
    	
    	long time = System.currentTimeMillis();
    	
    	for(long i = 1; i <= TOTAL_EVENTS; i++) {
    		Event e = new Event();
    		e.setSku(i);
    		e.setCategory1(i % NUMBER_OF_CATEGORIES);
    		e.setCategory2(NUMBER_OF_CATEGORIES - (i % NUMBER_OF_CATEGORIES));
    		e.setCategory3(i % NUMBER_OF_CATEGORIES);
    		e.setCategory4(i % NUMBER_OF_CATEGORIES);
    		
			events.add(e);
    		
    		if(i % CHUNK_SIZE == 0) {
    			System.out.println("processing " + i);
    			eventRepository.save(events);
    			events.clear();
    		}
    	}
    	
        System.out.println(System.currentTimeMillis() - time);
    }
}