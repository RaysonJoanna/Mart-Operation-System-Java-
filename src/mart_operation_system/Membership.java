package mart_operation_system;

public class Membership {
	
	private String name;			// 고객이름
	private String phone_number;	// 고객전화번호
	private int total;				// 고객 총 사용 금액
	private String grade;			// 고객 등급
	private int point;				// 고객 포인트
	private double pointRatio;		// 등급별 포인트 적립 비율 
	private double discountRatio;	// 할인비율
	private int memberNum;			// 고객번호
	
	public Membership() {}
	
	public Membership(String name, String phone_number, int total) {
		this.name = name;
		this.phone_number = phone_number;
		this.total = total;
		this.grade = upgradeGrade(total);
	}
	
	public String upgradeGrade(int total) {
		if(total<0) {
			System.out.println("<오류> 누적금액이 0보다 작습니다");
		} else if(total<200000) {
			grade = "Bronze";
		} else if(total<1000000) {
			grade = "Silver";
		} else {
			grade= "Gold";
		}
		return grade;
	}
	
	public void purchase(int price) {

		point += price*pointRatio;
		price *= (1-discountRatio); 
	}
	
	public void gradeDetail() {
		if(grade.equals("Bronze")) {
			pointRatio = 0.01;
		} else if(grade.equals("Silver")) {
			pointRatio = 0.03;
		} else if(grade.equals("Gold")) {
			pointRatio = 0.05;
			discountRatio = 0.15;
		}
	}
	
	public void showMem() {
		System.out.println(name+"고객님은 "+grade+"등급입니다.\n고객님의 누적 결제 금액은"+
				total+"원이고, 적립 포인트는"+point+"입니다.\n");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public double getPointRatio() {
		return pointRatio;
	}

	public void setPointRatio(double pointRatio) {
		this.pointRatio = pointRatio;
	}

	public double getDiscountRatio() {
		return discountRatio;
	}

	public void setDiscountRatio(double discountRatio) {
		this.discountRatio = discountRatio;
	}

	public int getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(int memberNum) {
		this.memberNum = memberNum;
	}
	
	
}
