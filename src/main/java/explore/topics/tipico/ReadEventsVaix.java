package explore.topics.tipico;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Comparator;

public class ReadEventsVaix {
    public static void main(String[] args) {

        try {
            ObjectMapper mapper = new ObjectMapper();
            String json = "{\n" +
                    "    \"count\": 32,\n" +
                    "    \"results\": [\n" +
                    "        {\n" +
                    "            \"event_id\": \"235317810\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.941712245376274\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235316810\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.8978707022048601\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"215204210\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.8957597084993956\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"234929510\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.8421629370363247\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235320210\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.8218115444804562\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235393510\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.7638502365851936\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235318610\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.7479651362545112\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235316710\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.7463647595985331\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235317710\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.7141056239850829\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235319510\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.7113935557182031\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235163710\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.7101368018917885\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235358210\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.7040808031790462\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"233123110\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.6632227699004642\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"233122610\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.652412117069033\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235233510\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.6252439989026891\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"233122910\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.5939026102331971\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"234836510\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.4939255979131455\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"233586610\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.48439813052931313\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235388810\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.44014760076379433\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235356210\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.43842691910728004\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"234831010\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.2952876094256347\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235373710\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.21400406412586137\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235320310\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.20926083642833382\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235025310\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.1912641511898009\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235356110\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.15844089066254963\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235324210\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.14402741047360612\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"234831210\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.10411745247729187\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"233247910\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.09056627447615007\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"234831110\",\n" +
                    "            \"sport\": \"boxing\",\n" +
                    "            \"confidence\": 0.08894601722703666\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"220026710\",\n" +
                    "            \"sport\": \"basketball\",\n" +
                    "            \"confidence\": 0.06265415683684927\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235208810\",\n" +
                    "            \"sport\": \"winter-sports\",\n" +
                    "            \"confidence\": 0.04732907485807725\n" +
                    "        },\n" +
                    "        {\n" +
                    "            \"event_id\": \"235388610\",\n" +
                    "            \"sport\": \"handball\",\n" +
                    "            \"confidence\": 0.03506798504992514\n" +
                    "        }\n" +
                    "    ]\n" +
                    "}";
            VaixEventsDTO vaixEventsDTO = mapper.readValue(json, VaixEventsDTO.class);
            vaixEventsDTO.getRecommendationEventList().stream()
                    .sorted(Comparator.comparing(VaixEvents::getEventId))
                    .forEach(p -> System.out.println(p.getEventId()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
