package com.mehul.portfoliomanager;

import com.mehul.portfoliomanager.dto.PortfolioRequest;
import com.mehul.portfoliomanager.entity.Portfolio;
import com.mehul.portfoliomanager.repository.PortfolioRepository;
import com.mehul.portfoliomanager.service.PortfolioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class PortfolioManagerApplicationTests {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private PortfolioRepository portfolioRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void shouldCreatePortfolio() {
        PortfolioRequest request = new PortfolioRequest(
                "Growth Portfolio",
                "Mehul Mehta",
                "HIGH"
        );

        Portfolio result =
                portfolioService.createPortfolio(request);

        assertNotNull(result.getId());
        assertEquals("Growth Portfolio", result.getPortfolioName());
        assertEquals("Mehul Mehta", result.getOwnerName());
        assertEquals(1, portfolioRepository.count());
    }
}