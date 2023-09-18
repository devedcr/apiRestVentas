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
import java.util.List;

@Entity
@Table(name = "usuario")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    private String ci;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(unique = true)
    private String email;

    @Column
    private String password;

    @Column
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "rolId")
    private Rol rol;

    @OneToMany(mappedBy = "user")
    private List<NoteSale> noteSales;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;

}
