package junittest;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Very First Unit Test! Let's go...🤯")
class BankAccountTest {
    private BankAccount account;
    public static int count;

    /**
     * Console print messages don't actually reflect the order of execution
     * What is happening is that the print statements are spooled to an IO thread
     * and so they may appear in the console out of order.
     */
    @BeforeAll
    static void preSetup() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

    @BeforeEach
    void setup() {
        account = new BankAccount("Derrick", "Park", 1000.00, BankAccount.CHECKING);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 100, 200, 10.5, 10.05, 1789.5 })
    void deposit(double amount) {
        double balance = account.deposit(amount, true);
        assertEquals(balance - 1000.00, amount, 0.001, "😡");
        System.out.println("Deposit Test (" + amount + ") : ✔️");
    }

    @Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0.001);
    }

    @Test
    void withdraw_notBranch() {
        // Reflection
        assertThrows(IllegalArgumentException.class, () -> {
            account.withdraw(600.00, false);
        });
    }

    @AfterEach
    void teardown() {
        System.out.println("This executes after each test case. Count = " + (count++) +  "🙀");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("This executes after any test cases ✅ Count = " + count++);
    }

    @Test
    void dummyTest() {
        assertEquals(200, 200);
    }
}