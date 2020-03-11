package explore.topics._concurrency;

public class ReadWriteLock { // NOT reentrant
    private int r = 0;
    private int w = 0;
    private int wr = 0;

    /**
     * Thread 1 gets read access.
     *
     * Thread 2 requests write access but is blocked because there is one reader.
     *
     * Thread 1 re-requests read access (re-enters the lock), but is blocked because there is a write request
     *
     * RESULT:  a situation similar to deadlock. No threads requesting neither read nor write access would be granted so.
     */
    public synchronized void readLock() {
        while (w>0 || wr>0) {
            Thread.onSpinWait();
        }
        ++r;
    }
    public synchronized void writeLock() {
        ++wr;
        while(r>0 || w>0) {
            Thread.onSpinWait();
        }
        --wr;
        ++w;
    }

    public synchronized void readUnlock() {
        --r;
        notifyAll();
        /**
         * Calling notifyAll() also has another advantage.
         * If multiple threads are waiting for read access and none for write access, and unlockWrite() is called,
         * all threads waiting for read access are granted read access at once - not one by one.
         */
    }

    public synchronized void writeUnlock() {
        --w;
        notifyAll();
    }
}
