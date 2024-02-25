package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic02 extends AbstractTemplate {
    @Override
    public void call() {
        log.info("Business logic 02 run");
    }

    ;
}
