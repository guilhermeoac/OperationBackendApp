package com.ntd.operationservice.repository.impl;

import com.ntd.operation.OperationTypeEnum;
import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.dto.OperationOutputDTO;
import com.ntd.operationservice.repository.interfaces.OperationsJpaRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class OperationRepositoryImpl implements OperationRepository {

    private final OperationsJpaRepository operationsJpaRepository;

    public OperationRepositoryImpl(OperationsJpaRepository operationsJpaRepository) {
        this.operationsJpaRepository = operationsJpaRepository;
    }

    @Override
    public List<OperationOutputDTO> findAll() throws Exception {
        return operationsJpaRepository.findAll().stream().map(it -> new OperationOutputDTO(it.getId(), it.getType().name(), it.getCost())).collect(Collectors.toList());
    }

    @Override
    public Optional<OperationOutputDTO> findByType(String type) throws Exception {
        var result = operationsJpaRepository.findOperationByType(OperationTypeEnum.valueOf(type)).stream().findFirst();

        return result.map(operation -> new OperationOutputDTO(operation.getId(), operation.getType().name(), operation.getCost()));

    }
}
