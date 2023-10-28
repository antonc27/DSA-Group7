import static org.junit.Assert.*;

public class W03_ArraysTest {

    @org.junit.Test
    public void numIdenticalPairs() {
        assertEquals(4, W03_Arrays.numIdenticalPairs(new int[]{1, 2, 3, 1, 1, 3}));
        assertEquals(6, W03_Arrays.numIdenticalPairs(new int[]{1,1,1,1}));
        assertEquals(0, W03_Arrays.numIdenticalPairs(new int[]{1,2,3}));
    }
}