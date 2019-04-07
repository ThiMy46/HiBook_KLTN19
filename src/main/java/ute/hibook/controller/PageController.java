package ute.hibook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/* 
 * Display page .jsp when use redirect to difference page 
 * */
@Controller
public class PageController {

	/*====PAGE BOOK===== */
	@GetMapping({"/","/login","/register"})
	public String homePage() {
		return "home";
	}

	@GetMapping({"/book"})
	public String bookPage() {
		return "listbook";
	}

	@GetMapping({"/cart"})
	public String cartPage() {
		return "cart";
	}

	@GetMapping({"/detail-book"})
	public String detailBook() {
		return "detailbook";
	}

	@GetMapping({"/detail-bill"})
	public String detailBill() {
		return "detailbill";
	}

	/*====PAGE USER===== */
	@GetMapping({"/user-info"})
	public String userInfo() {
		return "user/info";
	}
	@GetMapping({"/user-bill"})
	public String userBill() {
		return "user/historybill";
	}
	@GetMapping({"/update-user"})
	public String updateUser() {
		return "user/updateinfo";
	}

	/*====PAGE ADMIN===== */

	@GetMapping({"/add-book"}) 
	public String addBook() { 
		return "admin/addbook"; 
	}
	@GetMapping({"/add-user"}) 
	public String addUser() { 
		return "admin/adduser"; 
	}
	@GetMapping({"/author"}) 
	public String authorManage() { 
		return "admin/author"; 
	}
	@GetMapping({"/bill"}) 
	public String billManage() { 
		return "admin/bill"; 
	}
	@GetMapping({"/book"}) 
	public String bookManage() { 
		return "admin/book"; 
	}
	@GetMapping({"/dashboard"}) 
	public String dashboardManage() { 
		return "admin/dashboard"; 
	}
	@GetMapping({"/detail-bill-manage"}) 
	public String detailBillManage() { 
		return "admin/detailbill"; 
	}
	@GetMapping({"/order-status"}) 
	public String orderstatusManage() { 
		return "admin/orderstatus"; 
	}
	@GetMapping({"/payment"}) 
	public String paymentManage() { 
		return "admin/payment"; 
	}
	@GetMapping({"/supplier"}) 
	public String supplierManage() { 
		return "admin/supplier"; 
	}
	@GetMapping({"/transport"}) 
	public String transportManage() { 
		return "admin/transport"; 
	}
	@GetMapping({"/typebook"}) 
	public String typebookManage() { 
		return "admin/typebook"; 
	}
	@GetMapping({"/user"}) 
	public String userManage() { 
		return "admin/user"; 
	}
	@GetMapping({"/userreview"}) 
	public String userreviewManage() { 
		return "admin/userreview"; 
	}

}
