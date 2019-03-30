package explore.topics.immutability;

// Make all fields final and private
// Mutate field methods avoid
// By stopping of override by subclasses, class final (Make constructor private and creates its instances in factory methods)
// If instance fields of the class include references to mutable objects , do not directly expose those objects  -- If external mutable objects is passed to constructors , store copy of those objects

// Not ALL must be followed
public class ImmutableApp { // Object States cannot be modified after they are created
//    PROS: Object of the class cannot be corrupted by thread interference or observed in inconsistent state
//    CONS: A new object must be created each time you want the object with different state, resulting in object proliferation(rapid increase in the number or amount of something)
    public static void main(String[] args) {

    }
}

class StaticFields {
    /*
    static members of the class are class variable
    static methods don't need the instance to be created. They can be refereed to using Object reference but such usage is discouraged
    Static methods cannot directly access/call instance members, must use object references


    */
}