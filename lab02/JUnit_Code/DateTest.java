import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_sample() {
    Date d = new Date(2020,5,3);
    assertEquals(new Date(2020,5,4), d.nextDate());
  }

  @Test
  void testCase1() {
    Date d = new Date(1700,6,20);
    assertEquals(new Date(1700,6,21), d.nextDate());
  }

  @Test
  void testCase2() {
    Date d = new Date(2005,4,15);
    assertEquals(new Date(2005,4,16), d.nextDate());
  }

  @Test
  void testCase3() {
    Date d = new Date(1901,7,20);
    assertEquals(new Date(1901,7,21), d.nextDate());
  }

  @Test
  void testCase4() {
    Date d = new Date(3456,3,27);
    assertEquals(new Date(3456,3,28), d.nextDate());
  }

  @Test
  void testCase5() {
    Date d = new Date(1500,2,17);
    assertEquals(new Date(1500,2,18), d.nextDate());
  }

  @Test
  void testCase6() {
    Date d = new Date(1700,6,29);
    assertEquals(new Date(1700,6,30), d.nextDate());
  }

  @Test
  void testCase7() {
    Date d = new Date(1800,11,29);
    assertEquals(new Date(1800,11,30), d.nextDate());
  }

  @Test
  void testCase8() {
    Date d = new Date(3453,1,29);
    assertEquals(new Date(3453,1,30), d.nextDate());
  }

  @Test
  void testCase9() {
    Date d = new Date(444,2,29);
    assertEquals(new Date(444,3,1), d.nextDate());
  }

  @Test
  void testCase10() {
    Date d = new Date(2005,4,30);
    assertEquals(new Date(2005,5,1), d.nextDate());
  }

  @Test
  void testCase11() {
    Date d = new Date(3453,1,30);
    assertEquals(new Date(3453,1,31), d.nextDate());
  }

  @Test
  void testCase12() {
    Date d = new Date(3456,3,30);
    assertEquals(new Date(3456,3,31), d.nextDate());
  }

  @Test
  void testCase13() {
    Date d = new Date(1901,7,31);
    assertEquals(new Date(1901,8,1), d.nextDate());
  }

  @Test
  void testCase14() {
    Date d = new Date(3453,1,31);
    assertEquals(new Date(3453,2,1), d.nextDate());
  }

  @Test
  void testCase15() {
    Date d = new Date(3456,12,31);
    assertEquals(new Date(3457,1,1), d.nextDate());
  }

  @Test
  void testCase16() {
    assertThrows(IllegalArgumentException.class,
            ()->new Date(1500,2,31));
  }

  @Test
  void testCase17() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            ()->new Date(1500,2,29));
  }

  @Test
  void testCase18() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            ()->new Date(-1,10,20));
  }

  @Test
  void testCase19() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            ()->new Date(1458,15,12));
  }

  @Test
  void testCase20() {
    IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
            ()->new Date(1975,6,-50));
  }

}