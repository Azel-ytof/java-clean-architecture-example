package org.azelytof.boundary;

public interface OutputBoundary<T extends OutputMessage> {

    void success(T message);

    void error(T message, Exception e);

}
