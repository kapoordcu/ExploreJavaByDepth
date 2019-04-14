package explore.topics.design.state;

import java.util.Random;

/*
PROBLEM IT SOLVES
    A monolithic object's behavior is a function of its state, and it must change its behavior at run-time depending on that state.
    Or, an application is characterized by large and numerous case statements that vector flow of control based on the state of the application.
*/

/*
INTENT
    Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
    An object-oriented state machine
    wrapper + polymorphic wrappee + collaboration
*/

public class StateApp {
    public static void main(String[] args) {
        AccountContext stateContext = new AccountContext();
        stateContext.doTransaction(String.valueOf(new Random().nextInt()));
        stateContext.doTransaction(String.valueOf(new Random().nextInt()));

        stateContext.setAccountState(new ActiveAccount());
        stateContext.doTransaction(String.valueOf(new Random().nextInt()));

    }
}
