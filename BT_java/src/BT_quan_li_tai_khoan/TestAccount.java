package BT_quan_li_tai_khoan;

public class TestAccount {
	public static void main(String[] args) {
        Customer customer1 = new Customer(1001, "Tan Ah Teck", 'm');
        System.out.print(customer1);
        Account account1 = new Account(2001, customer1, 1000.00);
        System.out.print(account1);

        account1.deposit(500.00);
        System.out.print(account1);

        account1.withdraw(700.00);
        System.out.print(account1);

        account1.withdraw(1000.00);
        System.out.print(account1);
    }
}
