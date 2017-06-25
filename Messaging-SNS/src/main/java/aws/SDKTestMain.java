package aws;

import aws.message.sns.SetDefaultSMSConfigure;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Steven on 25/6/17.
 */
public class SDKTestMain {
    private static final Logger logger = LoggerFactory.getLogger(SDKTestMain.class);

    public static void main(String[] args) {

        logger.info("Set default configuration for SMS of AWS SNS");
        SetDefaultSMSConfigure configure = new SetDefaultSMSConfigure();
        configure.setDefaultSmsAttributes();


    }
}
