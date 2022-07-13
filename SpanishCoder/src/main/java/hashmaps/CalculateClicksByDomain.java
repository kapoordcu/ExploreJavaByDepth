package hashmaps;

import org.junit.Test;
import java.util.*;
import static org.junit.Assert.assertTrue;

public class CalculateClicksByDomain {
    @Test
    public void testHappyCase() {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        Map<String, Integer> sumByDomain = calculateClicksByDomain(counts);
        assertTrue(sumByDomain.get("com")==1345);
        assertTrue(sumByDomain.get("google.com")==900);
        assertTrue(sumByDomain.get("stackoverflow.com")==10);
        assertTrue(sumByDomain.get("overflow.com")==20);
        assertTrue(sumByDomain.get("yahoo.com")==410);
        assertTrue(sumByDomain.get("mail.yahoo.com")==60);
        assertTrue(sumByDomain.get("mobile.sports.yahoo.com")==10);
        assertTrue(sumByDomain.get("sports.yahoo.com")==50);
        assertTrue(sumByDomain.get("com.com")==5);
        assertTrue(sumByDomain.get("org")==3);
        assertTrue(sumByDomain.get("wikipedia.org")==3);
        assertTrue(sumByDomain.get("en.wikipedia.org")==2);
        assertTrue(sumByDomain.get("m.wikipedia.org")==1);
        assertTrue(sumByDomain.get("mobile.sports")==1);
        assertTrue(sumByDomain.get("sports")==1);
        assertTrue(sumByDomain.get("uk")==1);
        assertTrue(sumByDomain.get("co.uk")==1);
        assertTrue(sumByDomain.get("google.co.uk")==1);
    }

    public Map<String, Integer> calculateClicksByDomain(String[] counts) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for(String record : counts) {
            processRecordToCountClicks(record, frequencyMap);
        }
        return frequencyMap;
    }

    public void processRecordToCountClicks(String record, Map<String, Integer> frequencyMap) {
        String[] splitRecord = record.split(",");
        if(splitRecord.length >= 2) {
            String count = splitRecord[0];
            String[] domainsAndSubdomain = findDomainsAndSubdomain(splitRecord[1]);
            for(String value: domainsAndSubdomain) {
                if(!frequencyMap.containsKey(value)) {
                    frequencyMap.put(value, Integer.parseInt(count));
                } else {
                    frequencyMap.put(value, frequencyMap.get(value) + Integer.parseInt(count));
                }
            }
        }
    }

    public String[] findDomainsAndSubdomain(String domainString) {
        List<String> subDomain = new ArrayList<>();
        //mobile.sports.yahoo.com
        while(domainString.contains(".")) {
            subDomain.add(domainString);
            domainString = domainString.substring(domainString.indexOf('.')+1);
        }
        subDomain.add(domainString);
        return subDomain.stream()
                .toArray(String[]::new);
    }
}


/*
You are in charge of a display advertising program. Your ads are displayed on websites all over the internet. You have some CSV input data that counts how many times that users have clicked on an ad on each individual domain. Every line consists of a click count and a domain name, like this:

counts = [ "900,google.com",
     "60,mail.yahoo.com",
     "10,mobile.sports.yahoo.com",
     "40,sports.yahoo.com",
     "300,yahoo.com",
     "10,stackoverflow.com",
     "20,overflow.com",
     "5,com.com",
     "2,en.wikipedia.org",
     "1,m.wikipedia.org",
     "1,mobile.sports",
     "1,google.co.uk"]

Write a function that takes this input as a parameter and returns a data structure containing the number of clicks that were recorded on each domain AND each subdomain under it. For example, a click on "mail.yahoo.com" counts toward the totals for "mail.yahoo.com", "yahoo.com", and "com". (Subdomains are added to the left of their parent domain. So "mail" and "mail.yahoo" are not valid domains. Note that "mobile.sports" appears as a separate domain near the bottom of the input.)

Sample output (in any order/format):

calculateClicksByDomain(counts) =>
com:                     1345
google.com:              900
stackoverflow.com:       10
overflow.com:            20
yahoo.com:               410
mail.yahoo.com:          60
mobile.sports.yahoo.com: 10
sports.yahoo.com:        50
com.com:                 5
org:                     3
wikipedia.org:           3
en.wikipedia.org:        2
m.wikipedia.org:         1
mobile.sports:           1
sports:                  1
uk:                      1
co.uk:                   1
google.co.uk:            1

n: number of domains in the input
(individual domains and subdomains have a constant upper length)
*/