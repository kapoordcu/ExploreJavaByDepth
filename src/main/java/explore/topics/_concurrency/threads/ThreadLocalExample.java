package explore.topics._concurrency.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadLocalExample {

}

class ThreadSafeSimpleDateFromatter {
    public static ThreadLocal<SimpleDateFormat> formatThreadLocal = new ThreadLocal<>()  {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-mm-dd");
        }

        @Override
        public SimpleDateFormat get() {
            return super.get();
        }
    };

    public static ThreadLocal<SimpleDateFormat> formatThreadLocalJava8 =
            ThreadLocal.withInitial(() ->    new SimpleDateFormat("yyyy-mm-dd"));


}

class UserService {
    public String birthDate(String userId) {
        Date d = birthDateFromDB(userId);
        final SimpleDateFormat df = ThreadSafeSimpleDateFromatter.formatThreadLocal.get();
        return df.format(d);
    }



    private Date birthDateFromDB(String userId) {
        return null;
    }
}
