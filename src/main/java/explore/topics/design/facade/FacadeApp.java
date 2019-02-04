package explore.topics.design.facade;

/*
Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
This pattern involves a single class which provides simplified methods required by client and delegates calls
to methods of existing system classes.

Wrap a complicated subsystem with a simpler interface.

http://csharp-video-tutorials.blogspot.com/2018/02/facade-design-pattern.html
*/

import org.springframework.beans.factory.annotation.Autowired;

public class FacadeApp {

    @Autowired
    protected static RecommendationFacade recommendationFacade;

    public static void main(String[] args) {
        recommendationFacade.getEventIds("VAIX", false);
    }
}
