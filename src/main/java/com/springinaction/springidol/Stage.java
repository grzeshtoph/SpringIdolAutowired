package com.springinaction.springidol;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

/**
 * A singleton stage for performers.
 */
public final class Stage {
    private static final Logger LOG = LoggerFactory.getLogger(Stage.class);
    private String stageName;

    private Stage() {
    }

    public static Stage getInstance() {
        return StageInstanceHolder.INSTANCE;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public void init() {
        LOG.debug("Stage '{}' created", stageName);
    }

    private static final class StageInstanceHolder {
        private static final Stage INSTANCE = new Stage();
    }
}
