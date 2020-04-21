package VirtualBank.Bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name = "Transaction_Details")
public class Transaction
{
	  @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "tid")
	 private Integer tid;
	 private String account_number_source;
	 private String account_number_target;
	 private String date;
	 private String Floating_amount;
     private  String balance;
     private String amount;
     private String type;
     private String uid;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getAccount_number_source() {
		return account_number_source;
	}
	public void setAccount_number_source(String account_number_source) {
		this.account_number_source = account_number_source;
	}
	public String getAccount_number_target() {
		return account_number_target;
	}
	public void setAccount_number_target(String account_number_target) {
		this.account_number_target = account_number_target;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getFloating_amount() {
		return Floating_amount;
	}
	public void setFloating_amount(String floating_amount) {
		Floating_amount = floating_amount;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Transaction [tid=" + tid + ", account_number_source=" + account_number_source
				+ ", account_number_target=" + account_number_target + ", date=" + date + ", Floating_amount="
				+ Floating_amount + ", balance=" + balance + ", amount=" + amount + ", type=" + type + ", uid=" + uid
				+ "]";
	}
	  
}
