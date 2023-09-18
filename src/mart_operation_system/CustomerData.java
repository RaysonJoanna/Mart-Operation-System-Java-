package mart_operation_system;

import java.util.HashMap;
import java.util.Iterator;

public class CustomerData extends Membership{
	private static CustomerData instance = new CustomerData();
	private CustomerData() {}
	
	public static CustomerData getInstance() {
		if(instance == null) {
			instance = new CustomerData();
		}
		return instance;
	}
	
	HashMap<Integer,Membership> custList = new HashMap<Integer,Membership>();
	
	public void showInfo() {
		Iterator<Integer> ir = custList.keySet().iterator();
		while(ir.hasNext()) {
			int key = ir.next();
			Membership ms = custList.get(key);
			ms.showMem();
		}
		System.out.println();
	}

	@Override
	public int hashCode() {
		return getMemberNum();
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Membership) {
			Membership membership = (Membership)obj;
			if(this.getMemberNum() == membership.getMemberNum()) {
				return true;
			} else 
				return false;
		} 
		return false;
	}
	
	
}
