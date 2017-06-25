package aws;

import aws.message.sns.SendSMSMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Steven on 25/6/17.
 */
public class SDKTestMain {
    private static final Logger logger = LoggerFactory.getLogger(SDKTestMain.class);

    public static void main(String[] args) {

//        logger.info("Set default configuration for SMS of AWS SNS");
//        SetDefaultSMSConfigure configure = new SetDefaultSMSConfigure();
//        configure.setDefaultSmsAttributes();

        logger.info("Send test Message");
        SendSMSMessage smsClient = new SendSMSMessage();
        smsClient.sendMessage("Test 메시지 입니다", "0422632338");


    }
}
