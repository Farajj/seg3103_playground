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
		assertEquals("Fizz", fizz.fizzbuzzNum(3));
        
    }
}
 
 @Test
    void test_3() {
		assertEquals("Fizz", fizz.fizzbuzzNum(6));
        
    }

 @Test
    void test_4() {
		assertNotEquals("Fizzbuzzzzzzzzz", fizz.fizzbuzzNum(15));
    }

 @Test
    void test_5() {
		assertEquals("Buzz", fizz.fizzbuzzNum(7));
        
    }
}
