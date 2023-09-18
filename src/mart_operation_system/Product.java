package mart_operation_system;

public class Product {

	public String productName;	//제품 이름
	public int productNum;		//제품 번호
	public int amount;			//제품 수량
	public int sellPrice;		//판매가
	public int buyPrice;		//구매가
	
	public Product() {}
	
	public Product(String productName, int productNum, 
			int amount, int buyPrice, int sellPrice) {
		this.productName = productName;
		this.amount = amount;
		this.sellPrice = sellPrice;
		this.buyPrice = buyPrice;
		this.productNum = productNum;
	}
	
	public void showProduct() {
		System.out.println(productName+" "+amount+"개 남았습니다.\n"+
			"구매가는 "+buyPrice+"원, 판매가는"+sellPrice+"원 입니다. 제품번호는 "+
				productNum+"입니다.\n");
	}
	
	
	
	
}
