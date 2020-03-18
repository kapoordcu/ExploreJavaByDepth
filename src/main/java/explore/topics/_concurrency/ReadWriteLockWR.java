package explore.topics._concurrency;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockWR {
    private Map<Thread, Integer> readingThreads =
            new HashMap<Thread, Integer>();

    private int wa    = 0;
    private int wr    = 0;
    private Thread wThread = null;

    public synchronized void lockWrite() throws InterruptedException {
        wr++;
        Thread callingThread = Thread.currentThread();
        while(! canGrantWriteAccess(callingThread)){
            wait();
        }
        wr--;
        wa++;
        wThread = callingThread;
    }

    public synchronized void unlockWrite() throws InterruptedException{
        wa--;
        if(wa == 0){
            wThread = null;
        }
        notifyAll();
    }

    private boolean canGrantWriteAccess(Thread callingThread) {
        if(hasReaders())             return false;
        if(wThread == null)    return true;
        if(!isWriter(callingThread)) return false;
        return true;
    }

    private boolean isWriter(Thread callingThread) {
        return wThread == callingThread;
    }

    private boolean hasReaders() {
        return readingThreads.size() > 0;
    }
}
