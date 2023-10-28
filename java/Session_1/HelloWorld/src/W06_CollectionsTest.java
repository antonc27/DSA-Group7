import org.junit.Test;

import static org.junit.Assert.*;

public class W06_CollectionsTest {
    @Test
    public void twoSum() {
        assertArrayEquals(new int[] {0, 1}, W06_Collections.twoSum(new int[] {2,7,11,15}, 9));
        assertArrayEquals(new int[] {1, 2}, W06_Collections.twoSum(new int[] {3,2,4}, 6));
        assertArrayEquals(new int[] {0, 1}, W06_Collections.twoSum(new int[] {3,3}, 6));
    }
}