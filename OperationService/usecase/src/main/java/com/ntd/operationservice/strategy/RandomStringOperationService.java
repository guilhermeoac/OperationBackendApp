package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.RandomOrgService;
import com.ntd.operationservice.dto.OperationResultDTO;
import org.springframework.stereotype.Service;

@Service
public class RandomStringOperationService extends AbstractOperationService{

    private final RandomOrgService randomOrgService;
    public RandomStringOperationService(OperationRepository operationRepository, RandomOrgService randomOrgService) {
        super(operationRepository);
        this.randomOrgService = randomOrgService;
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) throws Exception {
        try {
            return new OperationResultDTO(randomOrgService.getRandomString());
        } catch (Exception e) {
            logger.error("MultiplyOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
