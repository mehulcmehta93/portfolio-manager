package com.mehul.portfoliomanager.exception;

public class PortfolioNotFoundException extends RuntimeException{

    public PortfolioNotFoundException(Long id){
        super("Portfolio with id " + id + " not found.");
    }
}
