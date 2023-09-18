package mart_operation_system;

import java.util.HashMap;
import java.util.Iterator;

public class Warehouse extends Product{
	HashMap<Integer,Product> productList = new HashMap<Integer,Product>();
	
	public void showProduct() {
		Iterator<Integer> ir = productList.keySet().iterator();
		while(ir.hasNext()) {
			int key = ir.next();
			Product pd = productList.get(key);
			pd.showProduct();
		}
		System.out.println();
	}

	@Override
	public int hashCode() {
		return productNum;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			Product product = (Product)obj;
			if(this.productNum == product.productNum) {
				return true;
			} else 
				return false;
		} 
		return false;
	}
	
}
