package comalatech.model;

import java.util.Date;

public class Income {

	
	
	public Income() {
		super();
	}
	
	public Income(Date _date, Double _amount, Double _balance ) {
		this.date = _date;
		this.amount = _amount;
		this.balance = _balance;
	}
	
	private Integer id;
	
	private Date date;
	
	private Double amount;
	
	private Double balance;

	
	
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

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	
	@Override
	public String toString() {
		return "Income [date=" + date + ", amount=" + amount + ", balance="
				+ balance + "]";
	}
	
	
	
}
