package com.springinaction.springidol;

import com.google.common.base.Strings;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

/**
 * Test case for {@link PerformanceException}.
 */
public class PerformanceExceptionTest {
    @Test
    public void createTest() {
        PerformanceException pe = new PerformanceException();
        assertTrue(Strings.isNullOrEmpty(pe.getMessage()));
    }
}
