package example.domain;

import java.io.Serializable;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Event implements Serializable {

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
    private Long indicator1 = 1L;
    
    @Column
    private Long indicator2 = 1L;
    
    @Column
    private Long indicator3 = 1L;
    
    @Column
    private Long indicator4 = 1L;
    
    @Column
    private Long indicator5 = 1L;
    
    @Column
    private Long indicator6 = 1L;
    
    @Column
    private Long indicator7 = 1L;
    
    @Column
    private Long indicator8 = 1L;
    
    @Column
    private Long indicator9 = 1L;
    
    @Column
    private Long indicator10 = 1L;
    
    @Column
    private Long indicator11 = 1L;
    
    @Column
    private Long indicator12 = 1L;
    
    @Column
    private Long indicator13 = 1L;
    
    @Column
    private Long indicator14 = 1L;
    
    @Column
    private Long indicator15 = 1L;
    
    @Column
    private Long indicator16 = 1L;
    
    @Column
    private Long indicator17 = 1L;
    
    @Column
    private Long indicator18 = 1L;
    
    @Column
    private Long indicator19 = 1L;
    
    @Column
    private Long indicator20 = 1L;

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

	public Long getIndicator1() {
		return indicator1;
	}

	public void setIndicator1(Long indicator1) {
		this.indicator1 = indicator1;
	}

	public Long getIndicator2() {
		return indicator2;
	}

	public void setIndicator2(Long indicator2) {
		this.indicator2 = indicator2;
	}

	public Long getIndicator3() {
		return indicator3;
	}

	public void setIndicator3(Long indicator3) {
		this.indicator3 = indicator3;
	}

	public Long getIndicator4() {
		return indicator4;
	}

	public void setIndicator4(Long indicator4) {
		this.indicator4 = indicator4;
	}

	public Long getIndicator5() {
		return indicator5;
	}

	public void setIndicator5(Long indicator5) {
		this.indicator5 = indicator5;
	}

	public Long getIndicator6() {
		return indicator6;
	}

	public void setIndicator6(Long indicator6) {
		this.indicator6 = indicator6;
	}

	public Long getIndicator7() {
		return indicator7;
	}

	public void setIndicator7(Long indicator7) {
		this.indicator7 = indicator7;
	}

	public Long getIndicator8() {
		return indicator8;
	}

	public void setIndicator8(Long indicator8) {
		this.indicator8 = indicator8;
	}

	public Long getIndicator9() {
		return indicator9;
	}

	public void setIndicator9(Long indicator9) {
		this.indicator9 = indicator9;
	}

	public Long getIndicator10() {
		return indicator10;
	}

	public void setIndicator10(Long indicator10) {
		this.indicator10 = indicator10;
	}

	public Long getIndicator11() {
		return indicator11;
	}

	public void setIndicator11(Long indicator11) {
		this.indicator11 = indicator11;
	}

	public Long getIndicator12() {
		return indicator12;
	}

	public void setIndicator12(Long indicator12) {
		this.indicator12 = indicator12;
	}

	public Long getIndicator13() {
		return indicator13;
	}

	public void setIndicator13(Long indicator13) {
		this.indicator13 = indicator13;
	}

	public Long getIndicator14() {
		return indicator14;
	}

	public void setIndicator14(Long indicator14) {
		this.indicator14 = indicator14;
	}

	public Long getIndicator15() {
		return indicator15;
	}

	public void setIndicator15(Long indicator15) {
		this.indicator15 = indicator15;
	}

	public Long getIndicator16() {
		return indicator16;
	}

	public void setIndicator16(Long indicator16) {
		this.indicator16 = indicator16;
	}

	public Long getIndicator17() {
		return indicator17;
	}

	public void setIndicator17(Long indicator17) {
		this.indicator17 = indicator17;
	}

	public Long getIndicator18() {
		return indicator18;
	}

	public void setIndicator18(Long indicator18) {
		this.indicator18 = indicator18;
	}

	public Long getIndicator19() {
		return indicator19;
	}

	public void setIndicator19(Long indicator19) {
		this.indicator19 = indicator19;
	}

	public Long getIndicator20() {
		return indicator20;
	}

	public void setIndicator20(Long indicator20) {
		this.indicator20 = indicator20;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category1 == null) ? 0 : category1.hashCode());
		result = prime * result + ((category2 == null) ? 0 : category2.hashCode());
		result = prime * result + ((category3 == null) ? 0 : category3.hashCode());
		result = prime * result + ((category4 == null) ? 0 : category4.hashCode());
		result = prime * result + ((indicator1 == null) ? 0 : indicator1.hashCode());
		result = prime * result + ((indicator10 == null) ? 0 : indicator10.hashCode());
		result = prime * result + ((indicator11 == null) ? 0 : indicator11.hashCode());
		result = prime * result + ((indicator12 == null) ? 0 : indicator12.hashCode());
		result = prime * result + ((indicator13 == null) ? 0 : indicator13.hashCode());
		result = prime * result + ((indicator14 == null) ? 0 : indicator14.hashCode());
		result = prime * result + ((indicator15 == null) ? 0 : indicator15.hashCode());
		result = prime * result + ((indicator16 == null) ? 0 : indicator16.hashCode());
		result = prime * result + ((indicator17 == null) ? 0 : indicator17.hashCode());
		result = prime * result + ((indicator18 == null) ? 0 : indicator18.hashCode());
		result = prime * result + ((indicator19 == null) ? 0 : indicator19.hashCode());
		result = prime * result + ((indicator2 == null) ? 0 : indicator2.hashCode());
		result = prime * result + ((indicator20 == null) ? 0 : indicator20.hashCode());
		result = prime * result + ((indicator3 == null) ? 0 : indicator3.hashCode());
		result = prime * result + ((indicator4 == null) ? 0 : indicator4.hashCode());
		result = prime * result + ((indicator5 == null) ? 0 : indicator5.hashCode());
		result = prime * result + ((indicator6 == null) ? 0 : indicator6.hashCode());
		result = prime * result + ((indicator7 == null) ? 0 : indicator7.hashCode());
		result = prime * result + ((indicator8 == null) ? 0 : indicator8.hashCode());
		result = prime * result + ((indicator9 == null) ? 0 : indicator9.hashCode());
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
		Event other = (Event) obj;
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
		if (indicator1 == null) {
			if (other.indicator1 != null)
				return false;
		} else if (!indicator1.equals(other.indicator1))
			return false;
		if (indicator10 == null) {
			if (other.indicator10 != null)
				return false;
		} else if (!indicator10.equals(other.indicator10))
			return false;
		if (indicator11 == null) {
			if (other.indicator11 != null)
				return false;
		} else if (!indicator11.equals(other.indicator11))
			return false;
		if (indicator12 == null) {
			if (other.indicator12 != null)
				return false;
		} else if (!indicator12.equals(other.indicator12))
			return false;
		if (indicator13 == null) {
			if (other.indicator13 != null)
				return false;
		} else if (!indicator13.equals(other.indicator13))
			return false;
		if (indicator14 == null) {
			if (other.indicator14 != null)
				return false;
		} else if (!indicator14.equals(other.indicator14))
			return false;
		if (indicator15 == null) {
			if (other.indicator15 != null)
				return false;
		} else if (!indicator15.equals(other.indicator15))
			return false;
		if (indicator16 == null) {
			if (other.indicator16 != null)
				return false;
		} else if (!indicator16.equals(other.indicator16))
			return false;
		if (indicator17 == null) {
			if (other.indicator17 != null)
				return false;
		} else if (!indicator17.equals(other.indicator17))
			return false;
		if (indicator18 == null) {
			if (other.indicator18 != null)
				return false;
		} else if (!indicator18.equals(other.indicator18))
			return false;
		if (indicator19 == null) {
			if (other.indicator19 != null)
				return false;
		} else if (!indicator19.equals(other.indicator19))
			return false;
		if (indicator2 == null) {
			if (other.indicator2 != null)
				return false;
		} else if (!indicator2.equals(other.indicator2))
			return false;
		if (indicator20 == null) {
			if (other.indicator20 != null)
				return false;
		} else if (!indicator20.equals(other.indicator20))
			return false;
		if (indicator3 == null) {
			if (other.indicator3 != null)
				return false;
		} else if (!indicator3.equals(other.indicator3))
			return false;
		if (indicator4 == null) {
			if (other.indicator4 != null)
				return false;
		} else if (!indicator4.equals(other.indicator4))
			return false;
		if (indicator5 == null) {
			if (other.indicator5 != null)
				return false;
		} else if (!indicator5.equals(other.indicator5))
			return false;
		if (indicator6 == null) {
			if (other.indicator6 != null)
				return false;
		} else if (!indicator6.equals(other.indicator6))
			return false;
		if (indicator7 == null) {
			if (other.indicator7 != null)
				return false;
		} else if (!indicator7.equals(other.indicator7))
			return false;
		if (indicator8 == null) {
			if (other.indicator8 != null)
				return false;
		} else if (!indicator8.equals(other.indicator8))
			return false;
		if (indicator9 == null) {
			if (other.indicator9 != null)
				return false;
		} else if (!indicator9.equals(other.indicator9))
			return false;
		if (sku == null) {
			if (other.sku != null)
				return false;
		} else if (!sku.equals(other.sku))
			return false;
		return true;
	}
}
