package com.cintech.PriceJuxtapose.service;

import com.cintech.PriceJuxtapose.dto.AlphaDTO;
import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.dto.ProductDTO;
import com.cintech.PriceJuxtapose.entity.Product;
import com.cintech.PriceJuxtapose.repository.PickNPayRepository;
import com.cintech.PriceJuxtapose.repository.ProductRepository;
import com.cintech.PriceJuxtapose.repository.WoolworthRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;



@Service
public class ProductService {

    private ModelMapper mapper;
    private ProductRepository productRepository;
    private PickNPayRepository pickNPayRepository;
    private WoolworthRepository woolworthRepository;


    public ProductService(ProductRepository productRepository, PickNPayRepository pickNPayRepository, WoolworthRepository woolworthRepository) {
        this.productRepository = productRepository;
        this.pickNPayRepository = pickNPayRepository;
        this.woolworthRepository = woolworthRepository;

    }

    public List<Product> getAll ()
    {
        return productRepository.findAll();
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product convertDTOtoEntity(ProductDTO productDTO) {
        this.mapper = new ModelMapper();
        Product product = this.mapper.map(productDTO, Product.class);
        return product;
    }

    public ProductDTO convertEntityToDTO(Product product) {
        this.mapper = new ModelMapper();
        ProductDTO productDTO = this.mapper.map(product, ProductDTO.class);
        return productDTO;
    }

    public List<ProductDTO> getAllProductListed() {
        List<ProductDTO> result = new ArrayList<ProductDTO>();
        productRepository.findAll().forEach(value -> result.add(convertEntityToDTO(value)));
        return result;
    }

    public Product saveProduct(ProductDTO product) {
        Product result = convertDTOtoEntity(product);
        return productRepository.save(result);
    }




}
