package com.ntd.operationservice.repository.model;

import com.ntd.operation.OperationTypeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_operation", schema = "operation")
public class Operation {
    @Id
    @SequenceGenerator(name = "tb_operation_id_seq", sequenceName = "tb_operation_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tb_operation_id_seq")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private OperationTypeEnum type;
    @Column(name = "cost", nullable = false)
    private BigDecimal cost;


    public Operation() {
        this.id = null;
        this.type = null;
        this.cost = null;
    }

    public Operation(Long id, OperationTypeEnum type, BigDecimal cost) {
        this.id = id;
        this.type = type;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationTypeEnum getType() {
        return type;
    }

    public void setType(OperationTypeEnum type) {
        this.type = type;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }
}

