package com.ntd.operationservice.repository.impl;

import com.ntd.operation.OperationTypeEnum;
import com.ntd.operationservice.dto.OperationOutputDTO;
import com.ntd.operationservice.repository.interfaces.OperationsJpaRepository;
import com.ntd.operationservice.repository.model.Operation;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class OperationRepositoryImplTest {

    @Mock
    private OperationsJpaRepository operationsJpaRepository;

    private OperationRepositoryImpl operationRepositoryImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        operationRepositoryImpl = new OperationRepositoryImpl(operationsJpaRepository);
    }

    @Test
    void testFindAll() throws Exception {
        var operation1 = new Operation(1L, OperationTypeEnum.ADDITION, new BigDecimal("100.00"));
        var operation2 = new Operation(2L, OperationTypeEnum.SUBTRACTION, new BigDecimal("200.00"));
        when(operationsJpaRepository.findAll()).thenReturn(List.of(operation1, operation2));

        List<OperationOutputDTO> result = operationRepositoryImpl.findAll();

        assertEquals(2, result.size());
        verify(operationsJpaRepository, times(1)).findAll();
    }

    @Test
    void testFindByType() throws Exception {
        var operation = new Operation(1L, OperationTypeEnum.ADDITION, new BigDecimal("100.00"));
        when(operationsJpaRepository.findOperationByType(OperationTypeEnum.ADDITION)).thenReturn(List.of(operation));

        Optional<OperationOutputDTO> result = operationRepositoryImpl.findByType(OperationTypeEnum.ADDITION.name());

        assertTrue(result.isPresent());
        assertEquals(OperationTypeEnum.ADDITION.name(), result.get().type());
        verify(operationsJpaRepository, times(1)).findOperationByType(OperationTypeEnum.ADDITION);
    }

    @Test
    void testFindByTypeEmpty() throws Exception {
        when(operationsJpaRepository.findOperationByType(OperationTypeEnum.ADDITION)).thenReturn(List.of());

        Optional<OperationOutputDTO> result = operationRepositoryImpl.findByType(OperationTypeEnum.ADDITION.name());

        assertTrue(result.isEmpty());
        verify(operationsJpaRepository, times(1)).findOperationByType(OperationTypeEnum.ADDITION);
    }

    @Test
    void testFindByTypeMultipleItems() throws Exception {
        var operation1 = new Operation(1L, OperationTypeEnum.ADDITION, new BigDecimal("100.00"));
        var operation2 = new Operation(2L, OperationTypeEnum.ADDITION, new BigDecimal("200.00"));
        when(operationsJpaRepository.findOperationByType(OperationTypeEnum.ADDITION)).thenReturn(List.of(operation1, operation2));

        Optional<OperationOutputDTO> result = operationRepositoryImpl.findByType(OperationTypeEnum.ADDITION.name());

        assertTrue(result.isPresent());
        assertEquals(OperationTypeEnum.ADDITION.name(), result.get().type());
        assertEquals(1L, result.get().id());
        verify(operationsJpaRepository, times(1)).findOperationByType(OperationTypeEnum.ADDITION);
    }
}