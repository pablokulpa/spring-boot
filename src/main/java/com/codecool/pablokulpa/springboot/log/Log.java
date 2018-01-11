package com.codecool.pablokulpa.springboot.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Log {

    private Logger logger;
    private static final Marker MARKER = MarkerManager.getMarker("MARKER");

    public Logger getLogger() {
        return logger;
    }

    public void setLogger(Class cls) {
        logger = LogManager.getLogger(cls.getSimpleName());
    }

    public void getLog(String message){
        logger.info(MARKER,message);
    }
}
