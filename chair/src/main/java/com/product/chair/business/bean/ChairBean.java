package com.product.chair.business.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="ProductDB")
public class ChairBean 
{
	
	@Id
	@Getter
	@Setter
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long chairId;
	@NonNull
	private String chairName;
	@NonNull
	private String Color;
	@NonNull
	private double leasePrice;
	@NonNull
	private Boolean available = true;
	
	ChairBean()
	{
		
	}

	public ChairBean(Long chairId, @NonNull String chairName, @NonNull String color, @NonNull double leasePrice,
			@NonNull Boolean available) {
		super();
		this.chairId = chairId;
		this.chairName = chairName;
		Color = color;
		this.leasePrice = leasePrice;
		this.available = available;
	}
	

	public Long getChairId() {
		return chairId;
	}

	public void setChairId(Long chairId) {
		this.chairId = chairId;
	}

	public String getChairName() {
		return chairName;
	}

	public void setChairName(String chairName) {
		this.chairName = chairName;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public double getLeasePrice() {
		return leasePrice;
	}

	public void setLeasePrice(double leasePrice) {
		this.leasePrice = leasePrice;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "ChairBean [chairId=" + chairId + ", chairName=" + chairName + ", Color=" + Color + ", leasePrice="
				+ leasePrice + ", available=" + available + "]";
	}
	
	
}
