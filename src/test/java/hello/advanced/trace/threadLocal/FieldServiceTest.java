package hello.advanced.trace.threadLocal;

import hello.advanced.DomainUtil;
import hello.advanced.trace.threadLocal.code.FieldService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field_no_sync_issue() {
        log.info("main Start");
        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        DomainUtil.sleep(2000); // no sync issue. wait for threadA is done.
        threadB.start();

        DomainUtil.sleep(3000); // wait for main thread.
        log.info("main end");
    }

    @Test
    void field_with_sync_issue() {
        log.info("main Start");
        Runnable userA = () -> fieldService.logic("userA");
        Runnable userB = () -> fieldService.logic("userB");

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        DomainUtil.sleep(100); // sync issue. do not wait for threadA is done.
        threadB.start();

        DomainUtil.sleep(3000); // wait for main thread.
        log.info("main end");
    }
}
