package _220711;

public class Account {
	private String owner;
	private String number;
	private int balance;
	
	public Account() {
		owner = "홍길동";
		number = "123-456789";
		balance = 10000;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}
	
	public void deposit(int money) {
		balance += money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	
	public static void main(String[] args) {
		Account acc = new Account();
		System.out.println("계좌 " + acc.getNumber() + " (예금주 : " + acc.getOwner()+ ")");
		System.out.println("잔액 : " + acc.getBalance() + "원");
		System.out.println("20000원 입금합니다.");
		acc.deposit(20000);
		System.out.println("잔액 : " + acc.getBalance() + "원");
		System.out.println("45000원 출금합니다.");
		acc.withdraw(45000);
		System.out.println("잔액 : " + acc.getBalance() + "원");
		
	}
}
