package cgginterns.hibernate.map12;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Brand {

	@Id
	@Column(name="brand_id")
	private int brandId;
	
	@Column(name="brand_name")
	private String brandName;
	
	@OneToMany
	@JoinColumn(name="b_id")
	List<Product> products;
	
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public Brand(int brandId, String brandName) {
		super();
		this.brandId = brandId;
		this.brandName = brandName;
	}
	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBrandId() {
		return brandId;
	}
	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	@Override
	public String toString() {
		return "Brand [brandId=" + brandId + ", brandName=" + brandName + "]";
	}
	
	
}
