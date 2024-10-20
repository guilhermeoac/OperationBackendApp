package com.ntd.operationservice;

import com.ntd.operationservice.dto.OperationDTO;
import com.ntd.operationservice.dto.OperationResultDTO;
import java.util.List;

public interface OperationService {

    OperationResultDTO execute(String firstParam, String secondParam) throws Exception;

    OperationDTO getOperationInfo(String type) throws Exception;
    List<OperationDTO> getOperations() throws Exception;

}
