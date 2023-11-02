package comperatorInterface;

import java.util.Comparator;

import test.model.Customer;

// muốn so sánh theo field nào thì tạo class đó ra rồi imlement lại interface comperator rồi get filed cần so sánh ra rồi so sánh
public class CompareByEmail implements Comparator<Customer>{

	@Override
	public int compare(Customer o1, Customer o2) {
		// TODO Auto-generated method stub
		return o1.getEmail().compareTo(o2.getEmail());
	}

	


}
