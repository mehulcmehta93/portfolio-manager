package com.mehul.portfoliomanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String portfolioName;

    @Column(nullable = false)
    private String ownerName;

    @Column(nullable = false)
    private String riskLevel;

    @Column(nullable = false)
    private LocalDateTime createdDate;

    @PrePersist
    void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }

}
