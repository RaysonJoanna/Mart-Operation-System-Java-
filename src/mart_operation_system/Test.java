package mart_operation_system;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Account account = new Account();
		Warehouse warehouse = new Warehouse();
		CustomerData customerData = CustomerData.getInstance();
	
		//기존 고객 설정
		Membership mem1 = new Membership("강모래","01012345678",30000);
		Membership mem2 = new Membership("길금천","01023456789",1250000);
		Membership mem3 = new Membership("흥대로","01034567890",36200);
		Membership mem4 = new Membership("김자갈","01045678901",12500000);
		
		customerData.custList.put(1, mem1);
		customerData.custList.put(2, mem2);
		customerData.custList.put(3, mem3);
		customerData.custList.put(4, mem4);
		
		//기존 물건 설정
		Product product1 = new Product("모래콜라 500ml", 88001, 20, 2000, 1200);
		Product product2 = new Product("깍깍 크러스트", 88002, 10, 7000, 5000);
		Product product3 = new Product("사다수 500ml", 88003, 50, 1200, 800);
		Product product4 = new Product("계란가득 샌드위치", 88004, 2, 3500, 2700);
		
		warehouse.productList.put(88001, product1);
		warehouse.productList.put(88002, product2);
		warehouse.productList.put(88003, product3);
		warehouse.productList.put(88004, product4);
		
		while(true) {
			System.out.println("\n1.바나나우유 2000ml (900원)\n2.모래라면 5개입 (3000원)\n"
					+"3.계란과자 (700원)\n4.잘닦여수세미 (400원)\n5.구매사항 없음\n");
			System.out.println("물건 구매 양식에 올바르게 입력해주세요");
			System.out.println("______________________________");
			System.out.println("구매할 물건 번호 : ");
			
			int choice1 = sc.nextInt();
			
			if(choice1 == 5)
				break;
			
			System.out.println("구매할 물건 수량 : ");
			int choice2 = sc.nextInt();
			
			System.out.println("구매한 물건 판매가 책정 : ");
			int choice3 = sc.nextInt();
			
			if(choice1 == 1) {
				Product product5 = new Product("바나나우유 200ml", 88005, choice2, 900, choice3 );
				warehouse.productList.put(product5.productNum, product5);
				account.buyProduct(900*choice2);
			} else if(choice1 == 2) {
				Product product6 = new Product("모래라면 5개입",88005, choice2, 3000, choice3);
				warehouse.productList.put(product6.productNum, product6);
				account.buyProduct(3000*choice2);
			} else if(choice1 == 3) {
				Product product7 = new Product("계란과자", 88007, choice2, 700, choice3);
				warehouse.productList.put(product7.productNum, product7);
				account.buyProduct(700*choice2);
			}  else if(choice1 == 4) {
				Product product8 = new Product("잘닦여수세미", 88008, choice2, 400, choice3);
				warehouse.productList.put(product8.productNum, product8);
				account.buyProduct(400*choice2);
			}
		}
		
		account.showBalance();
		
		int i=0;
		while(true) {
			System.out.println("_______________________\n");
			System.out.println("신규 고객을 등록하시겠습니까?");
			System.out.println("    1.예  |  2.아니요");
			System.out.println("_______________________\n");
			
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println("고객의 이름을 입력하세요.");
				String write1 = sc.nextLine();
				sc.nextLine();
				boolean register = true;
				
				while(register) {
				
					System.out.println("고객의 전화번호를 등록하세요(-없이)");
					String write2 = sc.nextLine();
					
					if(write2.length() == 11) {
						Membership mem5 = new Membership(write1,write2,0);
						customerData.custList.put(5+i, mem5);
						System.out.println("등록을 완료했습니다.");
						i++;
						register = false;
					} else {
						System.out.println("-없이 전화번호 11자리를 입력해주세요.");
					}
				}
				
			} else if(choice == 2) {
				break;
			} else {
				System.out.println("숫자 1이나 2를 입력하세요.");
				
			}
		}
		
		
		//판매부분
		System.out.println("바나나 우유 2개 계산 요청");
		System.out.println("____________________\n");
		
		warehouse.showProduct();
		
		System.out.println("\n재고가 없다면 물건번호에 99999를 입력하세요.\n");
		System.out.println("판매할 물건 번호 : ");
		int sell = sc.nextInt();
		if(sell == 88005) {
			System.out.println("판매할 물건 수량 : ");
			int amount = sc.nextInt();		
			if(amount == 2) {
				account.sellProduct(warehouse.productList.get(sell).sellPrice*amount);
				warehouse.productList.get(sell).amount -= amount;
			} else System.out.println("수량이 맞지 않습니다.");
		} else if(sell == 99999) {
			System.out.println("재고가 없어 물건을 판매하지 못했습니다. ");
		}
		else System.out.println("물건번호가 잘못 입력되었습니다.");
		
		warehouse.showProduct();
		account.showBalance();
	}
}
