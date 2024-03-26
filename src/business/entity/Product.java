package business.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Product {
	private String productId;
	private String productName;
	private float price;
	private String description;
	private Date created;
	private int catalogId;
	private int productStatus = 0;
	
	public Product() {
	}
	
	public Product(String productId, String productName, float price, String description, Date created, int catalogId, int productStatus) {
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.description = description;
		this.created = created;
		this.catalogId = catalogId;
		this.productStatus = productStatus;
	}
	
	public String getProductId() {
		return productId;
	}
	
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Date getCreated() {
		return created;
	}
	
	public void setCreated(Date created) {
		this.created = created;
	}
	
	public int getCatalogId() {
		return catalogId;
	}
	
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	
	public int isProductStatus() {
		return productStatus;
	}
	
	public void setProductStatus(int productStatus) {
		this.productStatus = productStatus;
	}
	
	public void inputData(Scanner scanner, Product[] arrProduct, Category[] arrCategories) {
		System.out.println("Nhập vào id product: ");
		while (true) {
			this.productId = scanner.nextLine();
			if (productId.matches("^[C|S|A][0-9]{3}$") && !existProductId(arrProduct)) {
				break;
			} else {
				System.err.println("Vui lòng nhập lại");
			}
		}
		
		// nhập tên
		System.out.println("Nhập vào tên product: ");
		while (true) {
			this.productName = scanner.nextLine();
			if (this.productName.length() >= 10 && this.productName.length() <= 50 && !existProductName(arrProduct)) {
				break;
			} else {
				System.err.println("Vui lòng nhập lại");
			}
		}
		
		// nhập giá
		System.out.println("Nhập giá sản phẩm: ");
		while (true) {
			this.price = Float.parseFloat(scanner.nextLine());
			if (price > 0) {
				break;
			} else {
				System.err.println("Vui lòng nhập lại");
			}
		}
		
		
		// nhập description
		System.out.println("Nhập vào mô tả sản phẩm: ");
		while (true) {
			this.description = scanner.nextLine();
			if (this.description.trim().isEmpty()) {
				System.err.println("Vui lòng nhập lại");
			} else {
				break;
			}
		}
		
		// nhập vào created - date
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		while (true) {
			try {
				this.created = sdf.parse(scanner.nextLine());
				break;
			} catch (ParseException e) {
				System.out.println("Vui lòng nhập lại");
			}
		}
		
		// show categories
		System.out.println("==================================");
		for (Category c : arrCategories) {
			if (c != null) {
				c.displayData();
			}
		}
		System.out.println("==================================");
		System.out.println("Nhập vào catalogId: ");
		while (true) {
			this.catalogId = Integer.parseInt(scanner.nextLine());
			if (existCatalogId(arrCategories)) {
				break;
			} else {
				System.err.println("Vui lòng nhập lại: ");
			}
		}
		
		
		// mặc định status = 0 - Đang bán  vì thêm mới là đang bán hoặc update thì phải là đang bán
	}
	
	public void displayData() {
		String status = null;
		switch (this.productStatus) {
			case 0:
				status = "Đang bán";
				break;
			case 1:
				status = "Hết hàng";
				break;
			case 2:
				status = "Không bán";
				break;
		}
		System.out.printf("[ ID: %s | ProductName: %s | Price: %s | Description: %s | Created: %s | CatalogId: %d | ProductStatus: %s ]\n",
				  this.productId,
				  this.productName,
				  this.price,
				  this.description,
				  this.created.toString(),
				  this.catalogId,
				  status
		);
	}
	
	public boolean existProductId(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null && products[i].getProductId().equals(this.getProductId())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existProductName(Product[] products) {
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null && products[i].getProductName().equals(this.getProductName())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existCatalogId(Category[] categories) {
		for (int i = 0; i < categories.length; i++) {
			if (categories[i] != null && categories[i].getCatalogId() == this.catalogId) {
				return true;
			}
		}
		return false;
	}
}
