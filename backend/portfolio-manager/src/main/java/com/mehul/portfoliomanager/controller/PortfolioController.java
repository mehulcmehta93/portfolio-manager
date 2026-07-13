package com.mehul.portfoliomanager.controller;

import com.mehul.portfoliomanager.dto.PortfolioRequest;
import com.mehul.portfoliomanager.entity.Portfolio;
import com.mehul.portfoliomanager.service.PortfolioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
}
