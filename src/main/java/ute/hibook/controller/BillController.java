package ute.hibook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ute.hibook.dto.BillDTO;
import ute.hibook.dto.BookDTO;
import ute.hibook.dto.CartDTO;
import ute.hibook.dto.DetailbillDTO;
import ute.hibook.dto.OrderstatusDTO;
import ute.hibook.dto.PaymentDTO;
import ute.hibook.dto.TransportDTO;
import ute.hibook.dto.UserDTO;
import ute.hibook.service.impl.BillServiceImpl;
import ute.hibook.service.impl.CartServiceImpl;
import ute.hibook.service.impl.DetailbillServiceImpl;
import ute.hibook.service.impl.OrderstatusServiceImpl;
@RestController
@RequestMapping(value = "/api/v1")
public class BillController {
	@Autowired
	BillServiceImpl billSer;
	@Autowired
	CartServiceImpl cartSer;
	@Autowired
	DetailbillServiceImpl detailbillSer;
	@Autowired
	OrderstatusServiceImpl statusSer;
	
	@GetMapping(value="/bills")
	public ResponseEntity<List<BillDTO>> getallBill(){
		List<BillDTO> bills= billSer.getAllBill();
		if(bills.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
	}
	
	@GetMapping(value="/bills/{idBill}")
	public ResponseEntity<BillDTO> getBillById(@PathVariable int idBill){
		BillDTO billDTO= billSer.getBillById(idBill);
		if(billDTO == null) {
			return new ResponseEntity<BillDTO>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<BillDTO>(billDTO,HttpStatus.OK);
	}
	
	@GetMapping(value = "/users/{idUser}/bills")
	public ResponseEntity<?> getBillByIdUser(@PathVariable int idUser){
		List<BillDTO> bills= billSer.getBillsByIdUser(idUser);
		if(bills.isEmpty()) {
			return new ResponseEntity<List<BillDTO>>(HttpStatus.NOT_FOUND);
		}
		 return new ResponseEntity<List<BillDTO>>(bills,HttpStatus.OK);
	}
	
	@PostMapping(value="/bills")
	public ResponseEntity<?> addBill(@RequestParam String nameReceiver, @RequestParam String numberphone,
			 @RequestParam String deliveryAdress, @RequestParam String dateCreate,
			 @RequestParam int total, @RequestParam int idUser,
			 @RequestParam int idPayment, @RequestParam int idTransport){
		BillDTO billDTO=new BillDTO();
		billDTO.setNameReceiver(nameReceiver);
		billDTO.setNumberphone(numberphone);
		billDTO.setDeliveryAdress(deliveryAdress);
		billDTO.setDateCreate(dateCreate);
		billDTO.setTotal(total);
		UserDTO user=new UserDTO();
		user.setIdUser(idUser);
		billDTO.setUser(user);
		
		PaymentDTO payment=new PaymentDTO();
		payment.setIdPayment(idPayment);
		billDTO.setPayment(payment);
		
		TransportDTO transport=new TransportDTO();
		transport.setIdTransport(idTransport);
		billDTO.setTransport(transport);
		
		List<OrderstatusDTO> lstStatus = statusSer.getAllOrderstatus();
		OrderstatusDTO status = lstStatus.get(0);
		billDTO.setOrderstatus(status);
		
		//add bill
		int idBillCurrent = billSer.addBill(billDTO);
		billDTO.setIdBill(idBillCurrent);
		//đổ dữ liệu cart sang detailBill
		List<CartDTO> carts=cartSer.getAllCartOfUser(idUser);
		for (CartDTO cart : carts) {
			DetailbillDTO detailBill=new DetailbillDTO();
			
			BookDTO book =new BookDTO();
			book.setIdBook(cart.getBook().getIdBook());
			
			detailBill.setBook(book);
			detailBill.setBill(billDTO);
			detailBill.setPrice(cart.getPrice());
			detailBill.setQuantityBuy(cart.getQuantity());
			
			detailbillSer.addDetailbill(detailBill);
			cartSer.deleteCart(cart.getIdCart());
			System.out.println("Đặt hàng thành công!");
		}
		return new ResponseEntity<Integer>(idBillCurrent,HttpStatus.OK);
	}
	/*======================Update Status Bill ================= */
	@PutMapping(value="/bills/{idBill}/status/{idStatus}")
	public ResponseEntity<?> updateRoleUser(@PathVariable int idBill, @PathVariable int idStatus){
		boolean update=billSer.updateStatusBill(idBill, idStatus);
		if(!update){
			return new ResponseEntity<Boolean>(false, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}
}
