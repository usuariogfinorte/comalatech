package comalatech.jsf;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;

import comalatech.data.IncomeData;
import comalatech.model.Income;



@ManagedBean(name = "incomeController")
@ViewScoped
public class IncomeController {


	private List<Income> listIncome;
	
	private Income selectedIncome = new Income();
	
	private Double amount = new Double(0);

	private IncomeData incomeData;
	
	private boolean btnRemoveAmount = true;
	

	@PostConstruct
	public void init() {       

		incomeData = IncomeData.getInstance();
		this.listIncome = incomeData.getIncomes();
	}
	
	
	
	 public void onClicBtnAddAmount(ActionEvent event) {
	    	
		 	incomeData.addIncome( new Income(new Date(), amount, Double.valueOf(0)) );
		 	this.listIncome = incomeData.getIncomes();
		 	showMessage("Income was added");
		 	
	    }
	 
	 public void onClicBtnRemoveAmount(ActionEvent event) {
		 	incomeData.removeIncome(selectedIncome);
	    	this.listIncome = incomeData.getIncomes();
		 	showMessage("Income was removed");
		 	selectedIncome = null;
		 	btnRemoveAmount = true;
	    }
	 
	 public void onSelectedRowTableAmount(SelectEvent event) {
		 if (selectedIncome==null) {
			 btnRemoveAmount = true;
		 } else {
			 btnRemoveAmount = false;
		 }
	 }
	 
	 public void onClicBtnCancel(ActionEvent event) {
		 	selectedIncome = null;
		 	btnRemoveAmount = true;
	    }
	 
	 public void onClicBtnReset(ActionEvent event) {
			incomeData.resetIncomes();
			this.listIncome = incomeData.getIncomes();
	    }
	 
	 public static void showMessage(String message) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", message ) );
			
	}


	public List<Income> getListIncome() {
		return listIncome;
	}

	public void setListIncome(List<Income> listIncome) {
		this.listIncome = listIncome;
	}



	public Income getSelectedIncome() {
		return selectedIncome;
	}



	public void setSelectedIncome(Income selectedIncome) {
		this.selectedIncome = selectedIncome;
	}



	public Double getAmount() {
		return amount;
	}



	public void setAmount(Double amount) {
		this.amount = amount;
	}



	public boolean isBtnRemoveAmount() {
		return btnRemoveAmount;
	}



	public void setBtnRemoveAmount(boolean btnRemoveAmount) {
		this.btnRemoveAmount = btnRemoveAmount;
	}

	

}
