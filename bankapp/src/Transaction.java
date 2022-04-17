import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TRANSACTIONDB")
public class Transaction {
	
	@Id
	@Column(name="TID")
	private int tid;
	
	@Column(name="USERNAME")
	private String username;
	
	@Column(name="TX_DATE")
	private Date tx_date;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="AMOUNT")
	private double amount;
	
	@Column(name="NOTES")
	private String notes;
	
	@Column(name="STATUS")
	private String status;
	
	public Transaction() {}

	public Transaction(String username, Date tx_date, String type, double amount, String notes,
			String status) {
		super();
		this.username = username;
		this.tx_date = tx_date;
		this.type = type;
		this.amount = amount;
		this.notes = notes;
		this.status = status;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getTx_date() {
		return tx_date;
	}

	public void setTx_date(Date tx_date) {
		this.tx_date = tx_date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", username=" + username + ", tx_date=" + tx_date + ", type=" + type
				+ ", amount=" + amount + ", notes=" + notes + ", status=" + status + "]";
	}
	
}
