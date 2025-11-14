package DB_Assertions;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import junit.framework.Assert;
import org.bson.Document;
import org.testng.annotations.BeforeClass;

public class ValidatePayoutRules {

//    @BeforeClass
//    public void beforeClass() {
//        MongoClient mongoClient = new MongoClient("localhost", 27118);
//        System.out.println("Database DemoDB connected successfully");
//        MongoDatabase db = mongoClient.getDatabase("payouts");
//        MongoCollection<Document> payoutRules = db.getCollection("PayoutRules");
//    }

    public void ValidatePayoutRules() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27118);
            System.out.println("Database DemoDB connected successfully");
            MongoDatabase db = mongoClient.getDatabase("payouts");
            MongoCollection<Document> payoutRules = db.getCollection("PayoutRules");

            long PRCount = payoutRules.countDocuments();
            System.out.println("Payouts Rule Count : " + PRCount);
            Assert.assertEquals(PRCount, 20420);

////////////////
            Document query = new Document("metaInfo.ruleId", 50705);
            FindIterable<Document> result = payoutRules.find(query);
            for (Document doc : result) {
                System.out.println("Rules search in DB For Loop :" + doc.toJson());

                int actualRuleID = doc.getInteger("metaInfo.ruleId");
                int expectedRuleId = 50705;
                Assert.assertEquals(actualRuleID, expectedRuleId);

                ////////////////
                MongoCollection<Document> earningRules = db.getCollection("EarningRules");
                long ERCount = earningRules.countDocuments();
                System.out.println("Earning Rule Count : " + ERCount);
                Assert.assertEquals(ERCount, 20420);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
