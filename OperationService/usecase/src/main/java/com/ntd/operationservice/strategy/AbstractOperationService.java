package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.OperationService;
import com.ntd.operationservice.dto.OperationDTO;
import com.ntd.operationservice.dto.OperationResultDTO;
import com.ntd.operationservice.exception.ApplicationException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;

public abstract class AbstractOperationService implements OperationService {

    private final OperationRepository operationRepository;

    protected final Log logger = LogFactory.getLog(this.getClass());

    protected AbstractOperationService(OperationRepository operationRepository) {
        this.operationRepository = operationRepository;
    }

    @Override
    public OperationDTO getOperationInfo(String type) throws Exception {
        return operationRepository.findByType(type).map(it -> new OperationDTO(it.type(), it.cost())).orElse(null);
    }
    @Override
    public List<OperationDTO> getOperations() throws Exception {
        return operationRepository.findAll().stream().map(it -> new OperationDTO(it.type(), it.cost())).collect(Collectors.toList());
    }

    protected BigDecimal convertParameter(String parameter) {
        try {
            return new BigDecimal(parameter);
        } catch (Exception e) {
            logger.error("AbstractOperationService.convertParameter, message:" + e.getMessage(), e);
            throw new ApplicationException("invalid.parameter", "Invalid parameter!", HttpStatus.NOT_ACCEPTABLE);
        }
    }
}
