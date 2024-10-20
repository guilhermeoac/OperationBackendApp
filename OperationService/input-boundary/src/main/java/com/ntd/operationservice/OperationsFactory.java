package com.ntd.operationservice;

public interface OperationsFactory {

    OperationService getInstance(String type);
}
