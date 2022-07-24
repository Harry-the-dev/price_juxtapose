package com.cintech.PriceJuxtapose.repository;

import com.cintech.PriceJuxtapose.dto.ProductDTO;
import com.cintech.PriceJuxtapose.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByProdTitle(String Title);
    List<Product> findProductByProdTitleAndProdVolumeAndAndProdVolumeUnit (String title, double volume , double volumeUnit);
    List<Product> findAll();
    Product findProductById (Long id ) ;

}