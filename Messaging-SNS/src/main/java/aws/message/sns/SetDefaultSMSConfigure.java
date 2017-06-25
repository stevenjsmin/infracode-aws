package aws.message.sns;

import aws.BaseAWS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.GetSMSAttributesRequest;
import com.amazonaws.services.sns.model.SetSMSAttributesRequest;

import java.util.Map;

/**
 * AWS SNS의 SMS서비스 테스트
 * <p>
 * Created by Steven on 25/6/17.
 */
public class SetDefaultSMSConfigure extends BaseAWS {

    public void setDefaultSmsAttributes() {
        AmazonSNSClient snsClient = getSNSClient();

        SetSMSAttributesRequest setRequest = new SetSMSAttributesRequest()
                .addAttributesEntry("DefaultSenderID", "Melfood")
                .addAttributesEntry("MonthlySpendLimit", "1")
                .addAttributesEntry("DeliveryStatusIAMRole", "arn:aws:iam::371698615055:role/SNSSuccessFeedback")
                .addAttributesEntry("DeliveryStatusSuccessSamplingRate", "10")
                .addAttributesEntry("DefaultSMSType", "Promotional")
                .addAttributesEntry("UsageReportS3Bucket", "logging.melfood.com.au");

        snsClient.setSMSAttributes(setRequest);

        Map<String, String> myAttributes = snsClient.getSMSAttributes(new GetSMSAttributesRequest()).getAttributes();
        System.out.println("My SMS attributes:");

        for (String key : myAttributes.keySet()) {
            System.out.println(key + " = " + myAttributes.get(key));
        }

    }

}
