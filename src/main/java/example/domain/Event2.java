package example.domain;

import java.io.Serializable;
import java.util.Map;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Event2 implements Serializable {

	private static final long serialVersionUID = 1L;

	@PrimaryKeyColumn(name = "sku", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private Long sku;

    @Column
    private Long category1;
    
    @Column
    private Long category2;
    
    @Column
    private Long category3;
    
    @Column
    private Long category4;
    
    @Column
    private Map<String, Long> indicators;

	public Long getSku() {
		return sku;
	}

	public void setSku(Long sku) {
		this.sku = sku;
	}

	public Long getCategory1() {
		return category1;
	}

	public void setCategory1(Long category1) {
		this.category1 = category1;
	}

	public Long getCategory2() {
		return category2;
	}

	public void setCategory2(Long category2) {
		this.category2 = category2;
	}

	public Long getCategory3() {
		return category3;
	}

	public void setCategory3(Long category3) {
		this.category3 = category3;
	}

	public Long getCategory4() {
		return category4;
	}

	public void setCategory4(Long category4) {
		this.category4 = category4;
	}

	public Map<String, Long> getIndicators() {
		return indicators;
	}

	public void setIndicators(Map<String, Long> indicators) {
		this.indicators = indicators;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category1 == null) ? 0 : category1.hashCode());
		result = prime * result + ((category2 == null) ? 0 : category2.hashCode());
		result = prime * result + ((category3 == null) ? 0 : category3.hashCode());
		result = prime * result + ((category4 == null) ? 0 : category4.hashCode());
		result = prime * result + ((indicators == null) ? 0 : indicators.hashCode());
		result = prime * result + ((sku == null) ? 0 : sku.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event2 other = (Event2) obj;
		if (category1 == null) {
			if (other.category1 != null)
				return false;
		} else if (!category1.equals(other.category1))
			return false;
		if (category2 == null) {
			if (other.category2 != null)
				return false;
		} else if (!category2.equals(other.category2))
			return false;
		if (category3 == null) {
			if (other.category3 != null)
				return false;
		} else if (!category3.equals(other.category3))
			return false;
		if (category4 == null) {
			if (other.category4 != null)
				return false;
		} else if (!category4.equals(other.category4))
			return false;
		if (indicators == null) {
			if (other.indicators != null)
				return false;
		} else if (!indicators.equals(other.indicators))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
    
}
