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
@Table(name = "detail_sale")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@EntityListeners(AuditingEntityListener.class)
public class DetailSale {

    @Id
    private Integer id;

    @Column
    private Integer amount;

    @Column
    private Float subtotal;

    @ManyToOne
    @JoinColumn(name = "note_sale_id")
    private NoteSale noteSale;

    @OneToMany(mappedBy = "detailSale")
    private List<Repayment> repayments;


    @ManyToOne
    @JoinColumn(name = "batchId")
    private Batch batch;

    @CreatedDate
    private LocalDateTime created_at;

    @LastModifiedDate
    private LocalDateTime updated_at;
}
