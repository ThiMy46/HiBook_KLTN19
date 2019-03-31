package ute.hibook.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the detailbill database table.
 * 
 */
@Embeddable
public class DetailbillPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private int idBook;

	@Column(insertable=false, updatable=false)
	private int idBill;

	public DetailbillPK() {
	}
	public int getIdBook() {
		return this.idBook;
	}
	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}
	public int getIdBill() {
		return this.idBill;
	}
	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetailbillPK)) {
			return false;
		}
		DetailbillPK castOther = (DetailbillPK)other;
		return 
			(this.idBook == castOther.idBook)
			&& (this.idBill == castOther.idBill);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idBook;
		hash = hash * prime + this.idBill;
		
		return hash;
	}
}