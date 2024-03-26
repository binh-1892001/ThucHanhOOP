package business.design;

import business.entity.Category;

import javax.script.ScriptEngine;
import java.util.Scanner;

public class CategoryBusiness {
	private static Category[] categories = new Category[100];
	// [null,null,null,...]
	
	// 1. lấy ra mảng findAll()
	public Category[] findAll() {
		return categories;
	}
	
	// 2. tìm kiếm thông tin thông qua id findById()
	public int findIndexCategoryById(int id) {
		for (int i = 0; i < categories.length; i++) {
			if (categories[i] != null && categories[i].getCatalogId() == id) {
				return i;
			}
		}
		return -1;
	}
	
	// 3. vừa thêm mới và cập nhật
	public void save(Category newCategory) {
		
		// thêm mới
		for (int i = 0; i < categories.length; i++) {
			if (categories[i] == null) {
				categories[i] = newCategory;
				break;
			}
		}
		
		// cập nhật
//			for (int i = 0; i < categories.length; i++) {
//				if (categories[i] != null && categories[i].getCatalogId() == newCategory.getCatalogId()) {
//					categories[i] = newCategory;
//					break;
//				}
//			}
	
	}
	
	public void updateCategory(int categoryIdUpdate, Scanner sc) {
		int indexCategoryUpdate = findIndexCategoryById(categoryIdUpdate);
		if (indexCategoryUpdate > -1) {
			// trường hợp có tồn tại
			boolean isExit = false;
			int choice = 0;
			do {
				System.out.println("1. cập nhật tên");
				System.out.println("2. cập nhật mô tả");
				System.out.println("3. cập nhật trạng thái");
				System.out.println("4. thoát");
				choice = Integer.parseInt(sc.nextLine());
				switch (choice) {
					case 1:
						categories[indexCategoryUpdate].setCatalogName(sc.nextLine());
						break;
					case 2:
						categories[indexCategoryUpdate].setDescriptions(sc.nextLine());
						break;
					case 3:
						categories[indexCategoryUpdate].setCatalogStatus(Boolean.parseBoolean(sc.nextLine()));
						break;
					case 4:
						break;
					default:
						System.err.println("vui lòng chọn từ 1 đến 4");
				}
				
				
			} while (choice != 4);
		} else {
			System.err.println("danh mục không tồn tại");
		}
	}
	
	public void deleteById(int id) {
		// tìm kiếm xem category theo id có tồn tại hay không
		int indexCategoryDelete = findIndexCategoryById(id);
		if (indexCategoryDelete > -1) {
			categories[indexCategoryDelete] = null;
		} else {
			System.err.println("danh mục không tồn tại");
		}
	}
	
}
