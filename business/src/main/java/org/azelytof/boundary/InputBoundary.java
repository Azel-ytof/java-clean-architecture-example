package org.azelytof.boundary;

public interface InputBoundary<T extends InputMessage> {

    void execute(T message);

}
