package ute.hibook.controller;

import java.security.Principal;
import java.util.function.Predicate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ute.hibook.dto.RoleDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.service.impl.UserServiceImpl;

/* 
 * Display page .jsp when use redirect to difference page 
 * */
@Controller
public class PageController {

	@Autowired
	UserServiceImpl userSer;

	/* ====PAGE BOOK===== */
	@GetMapping({ "/", "/login" })
	public String homePage(ModelMap model) {
		/*
		 * Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 * if(auth.getPrincipal() instanceof User) { User
		 * us=(User)(auth.getPrincipal()); get id from email UserDTO user =
		 * userSer.getUserByEmail(us.getUsername()); int id = user.getIdUser();
		 * //System.out.println(id); model.addAttribute("getIdUser", id); }
		 */
		return "home";
	}

	@GetMapping({ "/book" })
	public String book() {
		return "listbook";
	}

	@GetMapping({ "/cart" })
	public String cartPage() {
		return "cart";
	}

	@GetMapping({ "/search" })
	public String searchPage() {
		return "listbook";
	}

	@GetMapping({ "/detail-book/{idBook}" })
	public String detailBook(@PathVariable int idBook, Model model) {
		System.out.println(idBook);
		model.addAttribute("idBook", idBook);
		return "detailbook";
	}

	@GetMapping({ "/detail-bill" })
	public String detailBill() {
		return "detailbill";
	}

	@PostMapping(value = "/register")
	public String registrations(@RequestParam(name = "uname") String uname, @RequestParam(name = "psw") String psw,
			@RequestParam(name = "rpsw") String rpsw, @RequestParam(name = "email") String email, ModelMap model) {

		RoleDTO roleDTO = new RoleDTO();
		roleDTO.setIdRole(1);
		UserDTO userDTObyEmail = userSer.getUserByEmail(email);

		if (userDTObyEmail != null) {
			UserDTO userDTO = new UserDTO();
			userDTO.setEmail(email);
			String hash = BCrypt.hashpw(psw, BCrypt.gensalt(12));
			userDTO.setPassword(hash);
			userDTO.setRole(roleDTO);
			userDTO.setNameUser(uname);

			userSer.addUser(userDTO);
			model.addAttribute("erro", "Đăng ký thành công");
			return "redirect:/";
		} else {
			model.addAttribute("erro", "Email đã tồn tại!!!");
		}
		return "redirect:/register";
	}

	@GetMapping("/loginsuccess")
	public String loginsuccess() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		boolean isAdmin = false, isUser = false;
		if (auth.getPrincipal() instanceof User) {
			User us = (User) (auth.getPrincipal());
			isAdmin = us.getAuthorities().stream().anyMatch(new Predicate<GrantedAuthority>() {

				public boolean test(GrantedAuthority role) {
					return role.getAuthority().equalsIgnoreCase("ROLE_ADMIN");
				}
			});
			isUser = us.getAuthorities().stream().anyMatch(new Predicate<GrantedAuthority>() {

				public boolean test(GrantedAuthority role) {
					return role.getAuthority().equalsIgnoreCase("ROLE_USER");
				}
			});
		} else {
			isAdmin = (auth.getPrincipal()).equals("ROLE_ADMIN");
			isUser = (auth.getPrincipal()).equals("ROLE_USER");
		}

		/* With each role will redirect to page */
		if (isAdmin) {
			return "redirect:/dashboard";
		}
		if (isUser) {

			return "redirect:/";

		}
		return "redirect:/";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:/";// You can redirect wherever you want, but generally it's a good practice to
							// show login screen again.
	}

	@GetMapping(value = "/403")
	public String accessDenied(Model model, Principal principal) {
		return "page403";
	}

	/* ====PAGE USER===== */
	@GetMapping({ "/user-info" })
	public String userInfo(ModelMap model) {
		 Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if(auth.getPrincipal() instanceof User) { 
			 User us=(User)(auth.getPrincipal()); 
			 //get id from email 
			 UserDTO user = userSer.getUserByEmail(us.getUsername()); 
			 int id = user.getIdUser();
			 System.out.println(id); 
			 model.addAttribute("getIdUser", id); 
			 model.addAttribute("info", user);
			 return "user/info";
		}
		return "/";
	}

	@GetMapping({ "/user-bill" })
	public String userBill(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if(auth.getPrincipal() instanceof User) { 
			 User us=(User)(auth.getPrincipal()); 
			 //get id from email 
			 UserDTO user = userSer.getUserByEmail(us.getUsername()); 
			 int id = user.getIdUser();
			 System.out.println(id); 
			 model.addAttribute("getIdUser", id); 
			 model.addAttribute("info", user);
			 return "user/historybill";
		}
		return "/";
	}

	@GetMapping({ "/user-update" })
	public String updateUserPage(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		 if(auth.getPrincipal() instanceof User) { 
			 User us=(User)(auth.getPrincipal()); 
			 //get id from email 
			 UserDTO user = userSer.getUserByEmail(us.getUsername()); 
			 int id = user.getIdUser();
			 System.out.println(id); 
			 model.addAttribute("getIdUser", id); 
			 model.addAttribute("info", user);
			 return "user/updateinfo";
		}
		return "/";
	}

	/* ====PAGE ADMIN===== */

	@GetMapping({ "/add-book" })
	public String addBookAdmin() {
		return "admin/addbook";
	}

	@GetMapping({ "/add-user" })
	public String addUserAdmin() {
		return "admin/adduser";
	}

	@GetMapping({ "/manage-author" })
	public String authorManageAdmin() {
		return "admin/author";
	}

	@GetMapping({ "/manage-bill" })
	public String billManageAdmin() {
		return "admin/bill";
	}

	@GetMapping({ "/manage-book" })
	public String manageBookAmin() {
		return "admin/book";
	}

	@GetMapping({ "/dashboard" })
	public String dashboardManageAdmin() {
		return "admin/dashboard";
	}

	@GetMapping({ "/manage-detail-bill" })
	public String detailBillManageAdmin() {
		return "admin/detailbill";
	}

	@GetMapping({ "/manage-orderstatus" })
	public String orderstatusManageAdmin() {
		return "admin/orderstatus";
	}

	@GetMapping({ "/manage-payment" })
	public String paymentManageAdmin() {
		return "admin/payment";
	}

	@GetMapping({ "/manage-supplier" })
	public String supplierManageAdmin() {
		return "admin/supplier";
	}

	@GetMapping({ "/manage-transport" })
	public String transportManageAdmin() {
		return "admin/transport";
	}

	@GetMapping({ "/manage-typebook" })
	public String typebookManageAdmin() {
		return "admin/typebook";
	}

	@GetMapping({ "/manage-user" })
	public String userManageAdmin() {
		return "admin/user";
	}

	@GetMapping({ "/manage-userreview" })
	public String userreviewManageAdmin() {
		return "admin/userreview";
	}

}
