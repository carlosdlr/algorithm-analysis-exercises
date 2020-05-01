package com.carlosdlr.algorithm.exercises.adyen;

import java.math.BigDecimal;
import java.util.Optional;

public class EURExchangeService implements ExchangeService{
    @Override
    public Optional<BigDecimal> rate(String currency) {
        return Optional.empty();
    }
}
