package hello.advanced.trace.template;

import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic01;
import hello.advanced.trace.template.code.SubClassLogic02;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateMethodTest {

    @Test
    public void testWithoutTemplateMethod() {
        logic01();
        logic02();
    }

    private void logic01() {
        long startTime = System.currentTimeMillis();
        log.info("business logic 01 run");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime == {}", resultTime);
    }

    private void logic02() {
        long startTime = System.currentTimeMillis();
        log.info("business logic 02 run");
        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime == {}", resultTime);
    }

    @Test
    public void templateMethodWithAbstractClass() {
        AbstractTemplate template01 = new SubClassLogic01();
        template01.execute();
        AbstractTemplate template02 = new SubClassLogic02();
        template02.execute();
    }

    @Test
    public void templateMethodWithAnonymous() {
        AbstractTemplate template01 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Business logic with anonymous class 01");
            }
        };

        AbstractTemplate template02 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("Business logic with anonymous class 02");
            }
        };

        template01.execute();
        log.info("class name 01 == {}", template01.getClass());
        //TemplateMethodTest$1 <- This class's temporary class name is here
        template02.execute();
        log.info("class name 02 == {}", template01.getClass());
        //TemplateMethodTest$2 <- This class's temporary class name is here
    }
}
