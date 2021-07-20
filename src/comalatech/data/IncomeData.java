package comalatech.data;

import java.util.ArrayList;
import java.util.List;

import comalatech.model.Income;

public class IncomeData {

	private static List<Income> listIncome;
	private static int id = 0;
	
	private IncomeData() {}
	
	public static IncomeData getInstance() {
		
		IncomeData d = new IncomeData();
		if (listIncome == null) {
			listIncome = new ArrayList<Income>();
		}
		return d;
	}
	
	
	public void addIncome(Income income) {
		
		Income lastIncome;
		if (listIncome.isEmpty()) {
			lastIncome = new Income();
			lastIncome.setId(0);
			lastIncome.setBalance(Double.valueOf(0));
		} else {
			lastIncome = listIncome.get( listIncome.size() - 1 );
		}
		
		income.setId( id++ );
		income.setBalance( lastIncome.getBalance() + income.getAmount() );
		listIncome.add(income);
	}
	
	public void removeIncome(Income income) {
		
		
		for (Income in : listIncome ) {
			if (in.getId().intValue() == income.getId() ) {
				listIncome.remove(in);
				break;
			}
		}
		recalculateBalance();
	}
	
	
	private void recalculateBalance() {
		
		boolean first = true;
		double balance = 0;
		for (Income in : listIncome ) {
			if (first) {
				balance = in.getAmount();
				first = false;
			}
			in.setBalance(in.getAmount() + balance);
		}
	}
	
	public void resetIncomes() {
		listIncome = new ArrayList<Income>();
		id=0;
	}
	
	
	public List<Income> getIncomes() {
		return listIncome;
	}
	

	
}
