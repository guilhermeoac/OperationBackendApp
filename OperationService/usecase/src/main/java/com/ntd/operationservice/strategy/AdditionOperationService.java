package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class AdditionOperationService extends AbstractOperationService {

    public AdditionOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).add(convertParameter(secondParam)).toString());
        } catch (Exception e) {
            logger.error("AdditionOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
