import org.junit.Test;

import static org.junit.Assert.*;

public class W04_StringsTest {
    @Test
    public void isAnagram() {
        assertEquals(true, W04_Strings.isAnagram("anagram", "nagaram"));
        assertEquals(false, W04_Strings.isAnagram("rat", "car"));
    }
}