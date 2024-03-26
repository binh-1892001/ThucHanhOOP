package business.entity;

import java.util.Scanner;

public class Category {
	private static int id = 0;
	private int catalogId;
	private String catalogName;
	private String descriptions;
	private boolean catalogStatus = true;
	
	public Category() {
		this.catalogId = ++id;
	}
	
	public Category(int catalogId, String catalogName, String descriptions, boolean catalogStatus) {
		this.catalogId = catalogId;
		this.catalogName = catalogName;
		this.descriptions = descriptions;
		this.catalogStatus = catalogStatus;
	}
	
	public int getCatalogId() {
		return catalogId;
	}
	
	public void setCatalogId(int catalogId) {
		this.catalogId = catalogId;
	}
	
	public String getCatalogName() {
		return catalogName;
	}
	
	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}
	
	public String getDescriptions() {
		return descriptions;
	}
	
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	public boolean isCatalogStatus() {
		return catalogStatus;
	}
	
	public void setCatalogStatus(boolean catalogStatus) {
		this.catalogStatus = catalogStatus;
	}
	
	public void inputData(Scanner scanner, Category[] arrCategories) {
		System.out.print("Nhập tên catalog: ");
		while (true) {
			this.catalogName = scanner.nextLine();
			// kiểm tra bỏ trống hay không và check trùng lên
			if (catalogName.trim().isEmpty() && existCatalogName(arrCategories) && catalogName.length() > 50) {
				System.err.println("Vui lòng nhập lại: ");
			} else {
				break;
			}
		}
		System.out.print("Nhập tên Description: ");
		// nhập description
		while (true) {
			this.descriptions = scanner.nextLine();
			// kiểm tra bỏ trống hay không và check trùng lên
			if (this.descriptions.trim().isEmpty()) {
				System.err.println("Vui lòng nhập lại: ");
			} else {
				break;
			}
		}
	}
	
	public void displayData() {
		System.out.printf("[ ID: %d | CatalogName: %s | Description: %s | CatalogStatus: %s ]\n",
						this.catalogId,
						this.catalogName,
						this.descriptions,
						(this.catalogStatus ? "Hoạt động" : "Không hoạt động")
		);
	}
	
	public boolean existCatalogName(Category[] categories) {
		for (int i = 0; i < categories.length; i++) {
			if (categories[i].getCatalogName().equals(this.catalogName)) {
				return true;
			}
		}
		return false;
	}
}
