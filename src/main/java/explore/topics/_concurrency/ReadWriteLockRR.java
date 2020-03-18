package explore.topics._concurrency;

import java.util.HashMap;
import java.util.Map;

public class ReadWriteLockRR {
    private Map<Thread, Integer> readingThreads = new HashMap<Thread, Integer>();
    private int w = 0;
    private int wr = 0;

    public synchronized void lockRead() throws InterruptedException{
        Thread clThread = Thread.currentThread();
        while (!canGrantReadAccess(clThread)) {
            Thread.onSpinWait();
        }
        readingThreads.put(clThread, getAccessCount(clThread) + 1);
    }

    private Integer getAccessCount(Thread clThread) {
        Integer accessCount = readingThreads.get(clThread);
        if(accessCount == null) {
            return 0;
        }
        return accessCount.intValue();
    }

    // read reentrance is only granted if no threads are currently writing to the resource
    private boolean canGrantReadAccess(Thread clThread) {
        if(w > 0) {
            return false;
        }
        if(isReader(clThread))  {
            return true;
        }
        //if the calling thread already has read access this takes precedence over any writeRequests.
        if(wr > 0)      {
            return false;
        }
        return true;
    }

    private boolean isReader(Thread clThread) {
        return readingThreads.get(clThread)!=null;
    }
}
