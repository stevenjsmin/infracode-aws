package aws;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNSClient;

/**
 * Created by Steven on 25/6/17.
 */
public class BaseAWS {


    /**
     * Get SNSClient Object
     *
     * @return
     */
    protected AmazonSNSClient getSNSClient() {
        AWSCredentials auth = this.getAWSAuth();
        AmazonSNSClient snsClient = new AmazonSNSClient(auth);
        snsClient.setRegion(Region.getRegion(Regions.AP_SOUTHEAST_2));
        return snsClient;
    }

    private AWSCredentials getAWSAuth() {
        String accessKey = System.getProperty("ACCESS_KEY");
        String secretKey = System.getProperty("SECRET_KEY");
        AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);
        return credentials;
    }
}
