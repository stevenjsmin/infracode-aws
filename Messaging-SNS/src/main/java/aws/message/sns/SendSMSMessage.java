package aws.message.sns;

import aws.BaseAWS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Steven on 25/6/17.
 */
public class SendSMSMessage extends BaseAWS {

    public void sendMessage(String message, String mobileNumber) {
        AmazonSNSClient snsClient = getSNSClient();
        String phoneNumber = "+61" + StringUtils.substringAfter(mobileNumber, "0");

        Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
        //<set SMS attributes>
        sendSMSMessage(snsClient, message, phoneNumber, smsAttributes);

    }

    public static void sendSMSMessage(AmazonSNSClient snsClient, String message,
                                      String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {

        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber));

        System.out.println(result); // Prints the message ID.
    }
}
