package com.solutioncode.apiRestVentas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "module_operation")
@IdClass(IdModuleOperation.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ModuleOperation {
    @Id
    private Integer moduleId;

    @Id
    private Integer operationId;

    @ManyToOne
    @JoinColumn(name = "operationId")
    private Operation operation;

    @ManyToOne
    @JoinColumn(name = "moduleId")
    private Module module;

    @OneToMany(mappedBy = "moduleOperation")
    private List<RolModuleOperation> rolModuleOperations;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}

@Data
class IdModuleOperation implements Serializable {
    private Integer moduleId;
    private Integer operationId;
}