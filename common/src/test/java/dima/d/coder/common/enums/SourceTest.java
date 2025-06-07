package dima.d.coder.common.enums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SourceTest {

    @Test
    void valueOfSource() {

        assertEquals("ONE_SOURCE", Source.ONE_SOURCE.name());
        assertEquals(0, Source.ONE_SOURCE.ordinal());

        assertEquals("TWO_SOURCE", Source.TWO_SOURCE.name());
        assertEquals(1, Source.TWO_SOURCE.ordinal());
    }
}