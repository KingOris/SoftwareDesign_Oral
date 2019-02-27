import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * A class for testing Cosine_Similarity using JUnit 5
 */
class Cosine_SimilarityTest {
    /**
     * A test to check if the result is equal to the number got from website https://t4tutorials.com/cosine-similarity-examples-formula-and-calculations/
     */
    @Test
    public void Test(){
        //Five test for cosine similarity
        assertEquals(0.8781, new Cosine_Similarity("1 2 3","2 6 3").getSimilarity());
        assertEquals(0.9941, new Cosine_Similarity("4 5 6 7","2 3 4 5").getSimilarity());
        assertEquals(0.9616, new Cosine_Similarity("4 5 6 7 8","2 3 4 5 9").getSimilarity());
        assertEquals(0.9976, new Cosine_Similarity("1 3 6","2 4 9").getSimilarity());
        assertEquals(0.9173, new Cosine_Similarity("1.5 4.7 5.5","1.5 6.7 3.2").getSimilarity());
    }
}