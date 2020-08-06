package explore.topics.livecode;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */
public class FunctionIndexing {
    public static void main(String[] args) {
        List<String> paramType1 = Arrays.asList("string", "int");
        List<String> paramType2 = Arrays.asList("string", "string");

        Function function1 = new Function("funct1", paramType1);
        Function function2 = new Function("funct2", paramType2);
        Function function3 = new Function("funct3", paramType2);
        FunctionIndexing app = new FunctionIndexing();
        app.register(Set.of(function1, function2, function3));
        Set<Function> printResult = app.find(paramType2);
        System.out.println(printResult);

    }

    Map<List<String>, Set<Function>> functionDataStore = new HashMap<>();

    public void register(Set<Function> funcs) {
        funcs.forEach(f -> {
            List<String> params = f.params;
            // parametersBeforeVarrgas
            // parametersAfter (1+)
            if(functionDataStore.containsKey(params)) {
                Set<Function> existingSet = functionDataStore.get(params);
                existingSet.add(f);
            } else {
                Set<Function> saveSet = new HashSet<>();
                saveSet.add(f);
                functionDataStore.put(params, saveSet);
            }
        });
    }

    public Set<Function> find(List<String> args) {
        Set<Function> returnSet = new HashSet<>();
        if(functionDataStore.containsKey(args)) {
            Set<Function> functCurrent = functionDataStore.get(args);
            returnSet.addAll(functCurrent);
        }
        return returnSet;
    }


}



/*
 * Click `Run` to execute the snippet below!

 f1(i, i...)
 f1(i...)
 f2(s, i)
 f3(s, i)

 find([i, i, i]) -> [f1]
 find([s, i]) -> [f2, f3]

 */


class Function {
    String name;
    List<String> params;
    boolean vararg;

    public Function(String name, List<String> params) {
        this.name = name;
        this.params = params;
    }

    @Override
    public String toString() {
        return "name:" + name + " and parameters " + params;
    }

}




