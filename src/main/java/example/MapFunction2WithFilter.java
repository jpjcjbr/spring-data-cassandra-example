package example;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.spark.api.java.function.Function;

import com.datastax.spark.connector.japi.CassandraRow;

public class MapFunction2WithFilter implements Function<CassandraRow, Map<String, Long>>, Serializable {
	
	private static final long serialVersionUID = 1L;
	private Collection<Long> acceptedCategories = new HashSet<>();

	public MapFunction2WithFilter(Collection<Long> categories) {
		this.acceptedCategories = categories;
	}
	
	public MapFunction2WithFilter() {
	}

	public Map<String, Long> call(CassandraRow v1) {
		HashMap<String, Long> map = new HashMap<String, Long>();
		
		Map<Object, Object> indicators = v1.getMap("indicators");
		
		Collection<Long> rowCategories = new HashSet<>();
		rowCategories.add(v1.getLong("category1"));
		rowCategories.add(v1.getLong("category2"));
		rowCategories.add(v1.getLong("category3"));
		rowCategories.add(v1.getLong("category4"));
		
		if(!acceptedCategories.isEmpty()) {
			rowCategories = CollectionUtils.intersection(rowCategories, acceptedCategories);
		}
		
		if(!rowCategories.isEmpty()) {
			for(Object indicator: indicators.keySet()) {
				Long value = (Long) indicators.get(indicator);
				
				for(Long category: rowCategories) {
					map.put(indicator + "-" + category, value);
				}
			}
		}
		
		return map;
	}
	
}