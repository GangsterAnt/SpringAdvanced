package hello.advanced.trace.logTrace;

import hello.advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus traceStatus);

    void exception(TraceStatus traceStatus, Exception e);
}
