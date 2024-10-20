package com.ntd.operationservice;

import com.ntd.operationservice.dto.OperationOutputDTO;
import java.util.List;
import java.util.Optional;

public interface OperationRepository {
    List<OperationOutputDTO> findAll() throws Exception;

    Optional<OperationOutputDTO> findByType(String type) throws Exception;

}


