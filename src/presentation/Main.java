package presentation;

import business.design.CategoryBusiness;
import business.entity.Category;

import java.nio.channels.ScatteringByteChannel;
import java.util.Scanner;

public class Main {
	
	//	private static final Category[] categories = new Category[100];
//	private static final Product[] products = new Product[100];
	
	private static CategoryBusiness categoryBusiness = new CategoryBusiness();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("****************** SHOP MENU *******************\n" +
							"1. Quản lý danh mục sản phẩm\n" +
							"2. Quản lý sản phẩm\n" +
							"3. Thoát\n");
			System.out.print("Vui lòng lựa chọn: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case 1:
					showMenuCategory(sc);
					break;
				case 2:
					showMenuProduct();
					break;
				case 3:
					System.exit(0);
				default:
					break;
			}
		}
	}
	
	public static void showMenuCategory(Scanner sc) {
		while (true) {
			System.out.println("******************** CATEGORIES MENU ***********\n" +
							"1. Nhập thông tin các danh mục\n" +
							"2. Hiển thị thông tin các danh mục\n" +
							"3. Cập nhật thông tin danh mục\n" +
							"4. Xóa danh mục\n" +
							"5. Cập nhật trạng thái danh mục\n" +
							"6. Thoát");
			System.out.print("Vui lòng lựa chọn: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case 1:
					addNewCategory(sc);
					break;
				case 2:
					showAllCategory();
					break;
				case 3:
					updateInfoCategory(sc);
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					return;
				default:
					break;
			}
		}
	}
	
	public static void addNewCategory(Scanner sc) {
		System.out.print("bạn muốn thêm bao nhiêu category: ");
		int n = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < n; i++) {
			Category category = new Category();
			category.inputData(sc, categoryBusiness.findAll());
			categoryBusiness.save(category);
		}
	}
	
	public static void showAllCategory() {
		for (Category category : categoryBusiness.findAll()) {
			if (category != null) {
				category.displayData();
			}
		}
	}
	
	public static void updateInfoCategory(Scanner sc) {
		System.out.println("Vui lòng nhập id muốn sửa: ");
		int categoryIdUpdate = Integer.parseInt(sc.nextLine());
		categoryBusiness.updateCategory(categoryIdUpdate, sc);
	}
	
	public static void showMenuProduct() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("******************* PRODUCT MANAGEMENT *****************\n" +
							"1. Nhập thông tin các sản phẩm\n" +
							"2. Hiển thị thông tin các sản phẩm\n" +
							"3. Sắp xếp các sản phẩm theo giá\n" +
							"4. Cập nhật thông tin sản phẩm theo mã sản phẩm\n" +
							"5. Xóa sản phẩm theo mã sản phẩm\n" +
							"6. Tìm kiếm các sản phẩm theo tên sản phẩm\n" +
							"7. Tìm kiếm sản phẩm trong khoảng giá a – b (a,b nhập từ bàn\n" +
							"phím)\n" +
							"8. Thoát");
			System.out.print("Vui lòng lựa chọn: ");
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				case 8:
					return;
				default:
					break;
			}
		}
	}
}




