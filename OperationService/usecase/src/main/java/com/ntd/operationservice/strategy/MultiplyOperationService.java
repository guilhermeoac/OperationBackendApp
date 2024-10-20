package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class MultiplyOperationService extends AbstractOperationService{
    public MultiplyOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).multiply(convertParameter(secondParam)).toString());
        } catch (Exception e) {
            logger.error("MultiplyOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
