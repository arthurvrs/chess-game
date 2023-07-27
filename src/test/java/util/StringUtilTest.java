package util;

import junit.framework.TestCase;
import org.junit.jupiter.api.Test;

public class StringUtilTest extends TestCase {

    @Test
    public void testNewLine() {
        assertEquals("\n", StringUtil.getNEWLINE());
    }

}