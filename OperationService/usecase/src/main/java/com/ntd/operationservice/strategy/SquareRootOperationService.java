package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationResultDTO;
import com.ntd.operationservice.exception.ApplicationException;
import java.math.MathContext;
import java.math.RoundingMode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class SquareRootOperationService extends AbstractOperationService{
    public SquareRootOperationService(OperationRepository operationRepository) {
        super(operationRepository);
    }

    @Override
    public OperationResultDTO execute(String firstParam, String secondParam) {
        try {
            return new OperationResultDTO(convertParameter(firstParam).sqrt(MathContext.DECIMAL32).setScale(2, RoundingMode.HALF_UP).toString());
        } catch (ArithmeticException e) {
            logger.error("SquareRootOperationService.execute, ArithmeticException message:" + e.getMessage(), e);
            throw new ApplicationException("invalid.operation.param", e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }
        catch (Exception e) {
            logger.error("SquareRootOperationService.execute, message:" + e.getMessage(), e);
            throw e;
        }
    }
}
