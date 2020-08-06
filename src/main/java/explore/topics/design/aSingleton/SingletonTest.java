package explore.topics.design.aSingleton;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SingletonTest {
    @Autowired
    NotifySingletonB singletonB1;

    @Autowired
    NotifySingletonB singletonB2;

    @Test
    public void test() {
        NotifySingleton singleton1 = NotifySingleton.getInstance();
        NotifySingleton singleton2 = NotifySingleton.getInstance();
        Assert.assertNotNull(singleton1);
        Assert.assertSame(singleton1, singleton2);

        Assert.assertNotNull(singletonB1);
        Assert.assertSame(singletonB1, singletonB2);

    }
}
