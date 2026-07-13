package com.mehul.portfoliomanager.dto;

import jakarta.validation.constraints.NotBlank;

public record PortfolioRequest (
    @NotBlank String portfolioName,
    @NotBlank String ownerName,
    @NotBlank String riskLevel
) {

}
