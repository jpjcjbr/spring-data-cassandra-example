package example.domain;

import org.springframework.data.cassandra.repository.CassandraRepository;

public interface EventRepository extends CassandraRepository<Event> {
}
