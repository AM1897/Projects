package bank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void setUp() {
        account = new Account(100, "123456789");
    }
    @Test
    public void deposit_validAmount_IncreasesBalance() {
        account.deposit(50);
        Assertions.assertEquals(150, account.getBalance());
    }
    @Test
    public void deposit_negativeAmount_ThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.deposit(-50);
        });
    }
    @Test
    public void withdraw_validAmount_DecreasesBalance() {
        account.withdraw(50);
        Assertions.assertEquals(50, account.getBalance());
    }
    @Test
    public void withdraw_AmountGreaterThanBalance_ThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(150);});
    }
    @Test
    public void withdraw_negativeAmount_ThrowsException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(-50);});
    }
    @Test
    public void getBalance_validAccount_ReturnsBalance() {
        Assertions.assertEquals(100, account.getBalance());
    }
    @Test
    public void getAccountNumber_validAccount_ReturnsAccountNumber() {
        Assertions.assertEquals("123456789", account.getAccountNumber());
    }


}
