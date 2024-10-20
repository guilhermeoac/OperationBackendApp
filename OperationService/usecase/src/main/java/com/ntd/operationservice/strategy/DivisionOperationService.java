package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import com.ntd.operationservice.exception.ApplicationException;
import java.math.RoundingMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class DivisionOperationService extends AbstractOperationService{
    public DivisionOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).setScale(5, RoundingMode.HALF_UP).divide(convertParameter(secondParam), RoundingMode.HALF_UP).setScale(2, RoundingMode.HALF_UP).toString());
        } catch (ArithmeticException e) {
            logger.error("SquareRootOperationService.execute, ArithmeticException message:" + e.getMessage(), e);
            throw new ApplicationException("invalid.operation.param", e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (Exception e) {
            logger.error("DivisionOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
