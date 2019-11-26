package explore.topics.testlive;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toCollection;

public class Channels {
    public static void main(String[] args) {
        Map<String, Product> productsByName = new HashMap<>();
        Product eBike = new Product("E-Bike", "A bike with a battery");
        Product roadBike = new Product("Road bike", "A bike for competition");
        Product defaultProduct = new Product("Tester1", "The first null key");
        productsByName.put(null, defaultProduct);
        productsByName.put(eBike.getName(), eBike);
        productsByName.put(roadBike.getName(), roadBike);

        iterateOverHM(productsByName);

    }

    private static void iterateOverHM(Map<String, Product> productsByName) {
        productsByName.keySet()
                .forEach(key-> System.out.println(productsByName.get(key)));

        productsByName.entrySet()
                .forEach(entry-> System.out.println("Key:" + entry.getKey() + " and value:" + entry.getValue()));
    }
}

class Product {

    private String name;
    private String description;
    private List<String> tags;

    public Product(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }

    // standard getters/setters/constructors

    public Product addTagsOfOtherProdcut(Product product) {
        this.tags.addAll(product.getTags());
        return this;
    }

    @Override
    public String toString() {
        return description;
    }
}

//

//    List<Integer> channels = Arrays.asList(
//            212, 204, 109, 151, 326, 379, 739, 401,
//            562, 947, 216, 132, 152, 587, 432, 337,
//            232, 228, 480, 617, 487, 627, 106, 329,
//            215, 400, 548, 660, 426, 946, 572, 131,
//            501, 644, 669, 351, 405, 298, 589, 653,
//            442, 235, 995, 626, 647, 433, 371, 648,
//            124, 625, 317, 343, 507, 336, 229, 871,
//            120, 341, 335, 402, 224, 318, 129, 150,
//            138, 417, 311, 331, 403, 314, 622, 140,
//            820, 117, 225, 659, 482, 566, 404, 148, 319);
//        Collections.sort(channels);
//                System.out.println(channels);