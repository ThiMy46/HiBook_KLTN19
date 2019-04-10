package ute.hibook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String book() {
		return "listbook";
	}

	@GetMapping({"/cart"})
	public String cartPage() {
		return "cart";
	}
	
	@GetMapping({"/search"})
	public String searchPage() {
		return "listbook";
	}

	@GetMapping({"/detail-book/{idBook}"})
	public String detailBook(@PathVariable int idBook, Model model) {
		System.out.println(idBook);
		model.addAttribute("idBook", idBook);
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
	public String updateUserPage() {
		return "user/updateinfo";
	}

	/*====PAGE ADMIN===== */

	@GetMapping({"/add-book"}) 
	public String addBookAdmin() { 
		return "admin/addbook"; 
	}
	@GetMapping({"/add-user"}) 
	public String addUserAdmin() { 
		return "admin/adduser"; 
	}
	@GetMapping({"/author-manage"}) 
	public String authorManageAdmin() { 
		return "admin/author"; 
	}
	@GetMapping({"/bill-manage"}) 
	public String billManageAdmin() { 
		return "admin/bill"; 
	}
	@GetMapping({"/book-manage"}) 
	public String manageBookAmin() { 
		return "admin/book"; 
	}
	@GetMapping({"/dashboard"}) 
	public String dashboardManageAdmin() { 
		return "admin/dashboard"; 
	}
	@GetMapping({"/detail-bill-manage"}) 
	public String detailBillManageAdmin() { 
		return "admin/detailbill"; 
	}
	@GetMapping({"/orderstatus-manage"}) 
	public String orderstatusManageAdmin() { 
		return "admin/orderstatus"; 
	}
	@GetMapping({"/payment-manage"}) 
	public String paymentManageAdmin() { 
		return "admin/payment"; 
	}
	@GetMapping({"/supplier-manage"}) 
	public String supplierManageAdmin() { 
		return "admin/supplier"; 
	}
	@GetMapping({"/transport-manage"}) 
	public String transportManageAdmin() { 
		return "admin/transport"; 
	}
	@GetMapping({"/typebook-manage"}) 
	public String typebookManageAdmin() { 
		return "admin/typebook"; 
	}
	@GetMapping({"/user-manage"}) 
	public String userManageAdmin() { 
		return "admin/user"; 
	}
	@GetMapping({"/userreview-manage"}) 
	public String userreviewManageAdmin() { 
		return "admin/userreview"; 
	}

}
