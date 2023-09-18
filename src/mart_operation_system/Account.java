package mart_operation_system;

public class Account {
	public int price;
	public static int balance = 100000000;
	
	public void buyProduct(int price) {
		balance -= price;
	}
	
	public void sellProduct(int price) {
		balance += price;
	}
	
	public void showBalance() {
		System.out.println("남은 잔액은 "+balance+"원 입니다.");
	}
}
