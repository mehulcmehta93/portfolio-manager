package com.mehul.portfoliomanager.service;

import com.mehul.portfoliomanager.dto.PortfolioRequest;
import com.mehul.portfoliomanager.entity.Portfolio;
import com.mehul.portfoliomanager.exception.PortfolioNotFoundException;
import com.mehul.portfoliomanager.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Portfolio> getPortfolioById(Long id){

        return Optional.of(portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException(id)));
    }

    public void deletePortfolio(Long id){

        Portfolio portfolio = portfolioRepository.findById(id)
                .orElseThrow(() -> new PortfolioNotFoundException(id));

        portfolioRepository.delete(portfolio);
    }
}
