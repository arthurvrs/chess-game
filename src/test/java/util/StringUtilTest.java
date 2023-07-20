package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    public void testNewLine() {
        assertEquals("\n", StringUtil.getNEWLINE());
    }

}