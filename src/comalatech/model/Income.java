package comalatech.model;

import java.util.Date;

public class Income {

	
	
	public Income() {
		super();
	}
	
	public Income(Date _date, Integer _amount, Integer _balance ) {
		this.date = _date;
		this.amount = _amount;
		this.balance = _balance;
	}
	
	private Integer id;
	
	private Date date;
	
	private Integer amount;
	
	private Integer balance;

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	
	@Override
	public String toString() {
		return "Income [date=" + date + ", amount=" + amount + ", balance="
				+ balance + "]";
	}
	
	
	
}
