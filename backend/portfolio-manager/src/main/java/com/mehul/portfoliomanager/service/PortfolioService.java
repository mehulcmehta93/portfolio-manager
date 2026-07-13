package com.mehul.portfoliomanager.service;

import com.mehul.portfoliomanager.dto.PortfolioRequest;
import com.mehul.portfoliomanager.entity.Portfolio;
import com.mehul.portfoliomanager.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public List<Portfolio> getAllPortfolios() {
        return this.portfolioRepository.findAll();
    }

    public Portfolio createPortfolio(PortfolioRequest request) {
        Portfolio portfolio = Portfolio.builder()
                .portfolioName(request.portfolioName())
                .ownerName(request.ownerName())
                .riskLevel(request.riskLevel())
                .build();
        return portfolioRepository.save(portfolio);
    }
}
