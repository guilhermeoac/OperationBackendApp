package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import com.ntd.operationservice.exception.ApplicationException;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@Primary
public class GeneralOperationService extends AbstractOperationService {

    public GeneralOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        throw new ApplicationException("operation.not.register", "Operation is not registered!", HttpStatus.NOT_ACCEPTABLE);
    }
}
