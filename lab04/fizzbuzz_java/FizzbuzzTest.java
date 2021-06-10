import static org.junit.jupiter.api.Assertions.*;


class FizzbuzzTest {

    Fizzbuzz fizz = new Fizzbuzz();

    @Test
    void test_1() {
		assertEquals("Fizzbuzz", fizz.fizzbuzzNum(15));
        
    }
}

 @Test
    void test_2() {
		assertEquals("3", fizz.fizzbuzzNum(3));
        
    }
}