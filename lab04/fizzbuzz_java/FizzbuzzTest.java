import static org.junit.jupiter.api.Assertions.*;


class FizzbuzzTest {

    Fizzbuzz fizz = new Fizzbuzz();

    @Test
    void test_1() {
		assertEquals("15", fizz.fizzbuzzNum(15));
        
    }
}