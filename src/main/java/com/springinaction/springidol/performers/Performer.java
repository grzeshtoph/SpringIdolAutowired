package com.springinaction.springidol.performers;

import com.springinaction.springidol.PerformanceException;
import org.springframework.beans.factory.BeanNameAware;

/**
 * The main interface for sprigng performer beans.
 */
public interface Performer extends BeanNameAware {
    /**
     * Performs the trick.
     *
     * @throws com.springinaction.springidol.PerformanceException sole checked exception
     */
    void perform() throws PerformanceException;
}
