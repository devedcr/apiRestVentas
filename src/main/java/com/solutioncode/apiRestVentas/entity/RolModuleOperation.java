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

import java.time.LocalDateTime;

@Entity
@Table(name = "rol_module_operation")
@IdClass(IdRolModuleOperation.class)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@EntityListeners(AuditingEntityListener.class)
public class RolModuleOperation {

    @Id
    private Integer rolId;

    @Id
    private Integer moduleId;

    @Id
    private Integer operationId;

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "moduleId", referencedColumnName = "moduleId"),
            @JoinColumn(name = "operationId", referencedColumnName = "operationId")
    })
    private ModuleOperation moduleOperation;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}

@Data
class IdRolModuleOperation {
    private Integer rolId;
    private Integer moduleId;
    private Integer operationId;
}
