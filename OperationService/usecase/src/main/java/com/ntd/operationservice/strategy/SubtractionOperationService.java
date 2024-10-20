package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class SubtractionOperationService extends AbstractOperationService{
    public SubtractionOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).subtract(convertParameter(secondParam)).toString());
        } catch (Exception e) {
            logger.error("SubtractionOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
