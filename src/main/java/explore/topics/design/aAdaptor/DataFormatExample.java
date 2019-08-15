package explore.topics.design.aAdaptor;

// the adapter pattern makes two incompatible interfaces compatible without changing their existing code.
// Adapter patterns use a single class (the adapter class) to join functionality of independent or incompatible interfaces/classes.
// This pattern converts the (incompatible) interface of a class (the adaptee) into another interface (the target) that clients require.

/*
The adapter class implements the expected interface and keeps a reference to an object of the class you want to reuse.
The methods defined by the interface call one or more methods on the referenced object and return a value of the expected type.
By doing that, the adapter class fulfills the expected contract by implementing the interface and enables you to reuse existing, incompatible implementations.

*/
public class AdpatorApp {
    public static void main(String[] args) {
        System.out.println("-------BEFORE ADAPTOR-------------");
        DataFormat format = new JsonDataFormat();
        // Client Call
        format.processData("JSON", "UTF-8");

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("-------AFTER ADAPTOR-------------");
        // 6.	Clients should use the adapter via the client interface.
        // This will let you change or extend the adapters without affecting the client code.
        ProtoBufType typ = new ProtoBufType();
        DataFormat formatAdaptor = new DataFormatAdaptor(typ);
        formatAdaptor.processData("PROTO", "UTF-8");
    }
}

// Implementer Interface
interface DataFormat {
    // client interface
    void processData(String type, String encoding);
}

// Concrete Implementer
class JsonDataFormat implements DataFormat {
    @Override
    public void processData(String type, String encoding) {
        System.out.println("DataFormat is JSON.");
    }
}

enum DataType { PROTO, JSON, XML };

// Adaptee
class ProtoBufType { // A useful service class, which you can’t change (often 3rd-party, legacy or with lots of existing dependencies).
    public void processData(DataType dataType) {
        System.out.println("DataFormat is ProtoBuf.");
    }
}

class DataFormatAdaptor implements DataFormat {
    private final ProtoBufType protoBufType;

    public DataFormatAdaptor(ProtoBufType protoBufType) {
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