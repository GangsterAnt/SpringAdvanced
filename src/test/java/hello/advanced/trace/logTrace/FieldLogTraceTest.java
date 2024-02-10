package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceId;
import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FieldLogTraceTest {

    FieldLogTrace sut = new FieldLogTrace();

    @Test
    void Test2Level() {
        TraceStatus hello1 = sut.begin("hello1");
        TraceStatus hello2 = sut.begin("hello2");
        sut.end(hello2);
        sut.end(hello1);
    }

    @Test
    void Test2LevelException() {
        TraceStatus hello1 = sut.begin("hello1");
        TraceStatus hello2 = sut.begin("hello2");
        sut.exception(hello2, new IllegalStateException());
        sut.exception(hello1, new IllegalStateException());
    }

}