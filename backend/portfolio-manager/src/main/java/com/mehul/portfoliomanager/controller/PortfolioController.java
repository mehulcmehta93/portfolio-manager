package com.mehul.portfoliomanager.controller;

import com.mehul.portfoliomanager.dto.PortfolioRequest;
import com.mehul.portfoliomanager.entity.Portfolio;
import com.mehul.portfoliomanager.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/portfolios")
public class PortfolioController {

    private final PortfolioService portfolioService;


    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }


    @GetMapping
    public List<Portfolio> getAllPortfolios(){
        return portfolioService.getAllPortfolios();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Portfolio createPortfolio (@Valid @RequestBody PortfolioRequest request){
        return portfolioService.createPortfolio(request);
    }

    @GetMapping(value = "/{id}")
    public Optional<Portfolio> getPortfolioById(@PathVariable Long id){
        Optional<Portfolio> portfolio;

        portfolio = portfolioService.getPortfolioById(id);

       return portfolio;
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePortfolio(@PathVariable Long id){
        portfolioService.deletePortfolio(id);
    }

    }
