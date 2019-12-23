package explore.topics.design.aAdaptor;

// the adapter pattern makes two incompatible interfaces compatible without changing their existing code.
// Adapter patterns use a single class (the adapter class) to join functionality of independent or incompatible interfaces/classes.
// This pattern converts the (incompatible) interface of a class (the adaptee) into another interface (the target) that clients require.

import java.util.Arrays;

/*
The adapter class implements the expected interface and keeps a reference to an object of the class you want to reuse.
The methods defined by the interface call one or more methods on the referenced object and return a value of the expected type.
By doing that, the adapter class fulfills the expected contract by implementing the interface and enables you to reuse existing, incompatible implementations.
*/
public class DataFormatExample {
    public static void main(String[] args) {
        System.out.println("-------BEFORE ADAPTOR-------------");
        DataFormat format = new JsonDataFormat();
        // Client Call
        format.processData("JSON", "UTF-8");
        Arrays.asList(null);
        System.out.println("-------AFTER ADAPTOR-------------");
        // Clients should use the adapter via the client interface.
        // This will let you change or extend the adapters without affecting the client code.
        ProtoBufAdaptee adaptee = new ProtoBufAdaptee();
        DataFormat dataAdaptor = new DataFormatAdaptor(adaptee);
        dataAdaptor.processData("PROTO", "UTF-8");
    }
}

// Target Interface == client Interface
interface DataFormat {
    void processData(String type, String encoding);
}

// Concrete Implementation, IGNORE
class JsonDataFormat implements DataFormat {
    @Override
    public void processData(String type, String encoding) {
        System.out.println("DataFormat is JSON.");
    }
}

enum DataType { PROTO, JSON, XML };

// Adaptee - Incompatible Interface
class ProtoBufAdaptee {
    public void processData(DataType dataType) {
        System.out.println("DataFormat is ProtoBuf.");
    }
}

// Adaptor Class
class DataFormatAdaptor implements DataFormat {
    private final ProtoBufAdaptee protoBufType;

    public DataFormatAdaptor(ProtoBufAdaptee protoBufType) {
        this.protoBufType = protoBufType;
    }

    @Override
    public void processData(String type, String encoding) {
        protoBufType.processData(DataType.PROTO);
    }
}
/*
    Advantages of Adapter design pattern
        It allows more flexibility in design.
        They handle logic by wrapping a new interface around that of an existing class so you can use new APIs (with different interfaces)
            and avoid breaking existing implementations.
        It absolutely interconnects two incompatible interfaces.
    Disadvantages of Adapter design pattern
        It unnecessarily increases the size of the code as class inheritance is less used and lot of code is needlessly duplicated between classes.
        Sometimes many adaptations are required along an adapter chain to reach the type which is required.
*/