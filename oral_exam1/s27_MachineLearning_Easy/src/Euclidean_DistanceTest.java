import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class for testing Euclidean distance JUnit 5
 */
class Euclidean_DistanceTest {
    /**
     * A test to check if the result is equal to the number got from website http://www.wolframalpha.com/widgets/view.jsp?id=bf56e5c5eba0a8a7a5a6bb9ab5c0169b
     */
    @Test
    public void Test(){
        //Five test for euclidean distance
        assertEquals(4.1231, new Euclidean_Distance("1 2 3","2 6 3").getDistance());
        assertEquals(7.0285, new Euclidean_Distance("2.5 3.6 3","8.3 6.2 6").getDistance());
        assertEquals(1.7321, new Euclidean_Distance("1 2 3","2 3 4").getDistance());
        assertEquals(10, new Euclidean_Distance("7 8 9 10","2 3 4 5").getDistance());
        assertEquals(9.6954, new Euclidean_Distance("7 8 9 10","5 3 2 6").getDistance());
    }

}