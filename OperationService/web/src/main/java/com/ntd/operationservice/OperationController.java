package com.ntd.operationservice;

import com.ntd.operationservice.dto.OperationDTO;
import com.ntd.operationservice.dto.OperationParamsDTO;
import com.ntd.operationservice.dto.OperationResultDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/operation")
public class OperationController {

    private final OperationsFactory operationsFactory;

    private final OperationService operationService;

    public OperationController(OperationsFactory operationsFactory, OperationService operationService) {
        this.operationsFactory = operationsFactory;
        this.operationService = operationService;
    }

    @PostMapping("/execute")
    public ResponseEntity<OperationResultDTO> executeOperation(
            @RequestHeader("type") String type,
            @RequestBody OperationParamsDTO body
            ) throws Exception {
        return ResponseEntity.ok(operationsFactory.getInstance(type).execute(body.firstParam(), body.secondParam()));
    }
    @GetMapping("/type")
    public ResponseEntity<OperationDTO> getByType(
            @RequestHeader("type") String type
    ) throws Exception {
        return ResponseEntity.ok(operationService.getOperationInfo(type));
    }
    @GetMapping
    public ResponseEntity<List<OperationDTO>> getAllOperations(
    ) throws Exception {
        return ResponseEntity.ok(operationService.getOperations());
    }
}


