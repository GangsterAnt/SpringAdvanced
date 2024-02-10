package hello.advanced.trace.threadLocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
    private ThreadLocal<String> nameStore = new ThreadLocal<>(); //This must be removed. It might cause memory leak.

    public String logic(String name) {
        log.info("Save name -> {}, nameStore -> {}", name, nameStore.get());
        nameStore.set(name);
        sleep(1000);
        log.info("Read nameStore -> {}", nameStore.get());
        return nameStore.get();
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
