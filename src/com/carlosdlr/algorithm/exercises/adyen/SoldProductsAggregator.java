package com.carlosdlr.algorithm.exercises.adyen;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SoldProductsAggregator {
        private final EURExchangeService exchangeService;
        private BigDecimal rate = BigDecimal.valueOf(0);

        SoldProductsAggregator(EURExchangeService EURExchangeService) {
            this.exchangeService = EURExchangeService;
            Optional<BigDecimal> rate = this.exchangeService.rate("EUR");

            if(rate.isPresent() && rate.get().compareTo(BigDecimal.ZERO) > 0)
                this.rate = rate.get();


        }

        SoldProductsAggregate aggregate(Stream<SoldProduct> products) {
            if(products == null || products.count() == 0)
                products = Stream.empty();

            SoldProductsAggregate soldProductsAggregate = new SoldProductsAggregate();
            List<SimpleSoldProduct> productList = new ArrayList<>();
            productList = products.map(x -> transformSoldProduct(x)).collect(Collectors.toList());
            BigDecimal total = products.map(x -> x.getPrice()).reduce(BigDecimal.valueOf(0), BigDecimal::add);
            soldProductsAggregate.setProducts(productList);
            soldProductsAggregate.setTotal(total);

            return soldProductsAggregate;
        }

        private SimpleSoldProduct transformSoldProduct(SoldProduct soldProduct) {
            SimpleSoldProduct simpleSoldProduct = new SimpleSoldProduct();
            simpleSoldProduct.setName(soldProduct.getName());
            simpleSoldProduct.setPrice(soldProduct.getPrice());
            return simpleSoldProduct;
        }

}
