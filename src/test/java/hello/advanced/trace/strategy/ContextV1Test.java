package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.ContextV1;
import hello.advanced.trace.strategy.code.StrategyLogic1;
import hello.advanced.trace.strategy.code.StrategyLogic2;
import hello.advanced.trace.template.code.AbstractTemplate;
import hello.advanced.trace.template.code.SubClassLogic01;
import hello.advanced.trace.template.code.SubClassLogic02;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {
    @Test
    public void strategyV0() {
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


    /*
    전략 패턴 사용
     */
    @Test
    void strategyV1() {
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
    }
}
