import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class for testing hamming distance JUnit 5
 */
class Hamming_DistanceTest {
    /**
     * A test to check if the result is equal to the number got from website http://www.wolframalpha.com/widgets/view.jsp?id=bf56e5c5eba0a8a7a5a6bb9ab5c0169b
     */
    @Test
    public void Test(){

        assertEquals(4, new Hamming_Distance("0110101","1110010").getDistance());
        assertEquals(4, new Hamming_Distance("101101010","011101100").getDistance());
        assertEquals(6, new Hamming_Distance("0011001","1100111").getDistance());
        assertEquals(2, new Hamming_Distance("001","111").getDistance());
        assertEquals(5, new Hamming_Distance("11100111","00100000").getDistance());
    }
}