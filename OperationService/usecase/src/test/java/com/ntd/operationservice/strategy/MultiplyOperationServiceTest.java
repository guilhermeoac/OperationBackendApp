package com.ntd.operationservice.strategy;

import com.ntd.operationservice.OperationRepository;
import com.ntd.operationservice.exception.ApplicationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultiplyOperationServiceTest {

    @Mock
    private OperationRepository operationRepository;

    @InjectMocks
    private MultiplyOperationService multiplyOperationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void should_execute_sum_correct() {
        var response = multiplyOperationService.execute("1", "2");

        assertEquals(response.result(), "2");
    }

    @Test
    void should_execute_sum_decimal_correct() {
        var response = multiplyOperationService.execute("1.2", "2.2");

        assertEquals(response.result(), "2.64");
    }

    @Test
    void should_execute_sum_negative_correct() {
        var response = multiplyOperationService.execute("-1.2", "2.2");

        assertEquals(response.result(), "-2.64");
    }

    @Test
    void should_throw_exception_when_first_parameter_is_null() {
        var exception = assertThrows(ApplicationException.class, () -> multiplyOperationService.execute(null, "2.2"));

        assertEquals(exception.getCode(), "invalid.parameter");
    }

    @Test
    void should_throw_exception_when_first_parameter_is_word() {
        var exception = assertThrows(ApplicationException.class, () -> multiplyOperationService.execute("asda", "2.2"));

        assertEquals(exception.getCode(), "invalid.parameter");
    }

    @Test
    void should_throw_exception_when_second_parameter_is_null() {
        var exception = assertThrows(ApplicationException.class, () -> multiplyOperationService.execute("1", null));

        assertEquals(exception.getCode(), "invalid.parameter");
    }

    @Test
    void should_throw_exception_when_second_parameter_is_word() {
        var exception = assertThrows(ApplicationException.class, () -> multiplyOperationService.execute("1", "2.1as2"));

        assertEquals(exception.getCode(), "invalid.parameter");
    }
}