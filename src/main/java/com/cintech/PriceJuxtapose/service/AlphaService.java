package com.cintech.PriceJuxtapose.service;

import com.cintech.PriceJuxtapose.dto.AlphaDTO;
import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.dto.ProductDTO;
import com.cintech.PriceJuxtapose.dto.WoolworthsDTO;
import com.cintech.PriceJuxtapose.entity.PickNPay;
import com.cintech.PriceJuxtapose.entity.Product;
import com.cintech.PriceJuxtapose.entity.Woolworth;
import com.cintech.PriceJuxtapose.repository.PickNPayRepository;
import com.cintech.PriceJuxtapose.repository.ProductRepository;
import com.cintech.PriceJuxtapose.repository.WoolworthRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlphaService {

    private ModelMapper mapper;
    private ProductRepository productRepository;
    private PickNPayRepository pickNPayRepository;
    private WoolworthRepository woolworthRepository;
    private PickNPayService pickNPayService;
    private WoolworthsService woolworthsService;

    private ProductService productService;

    public AlphaService(ProductRepository productRepository, PickNPayRepository pickNPayRepository, WoolworthRepository woolworthRepository, PickNPayService pickNPayService, WoolworthsService woolworthsService, ProductService productService) {
        this.productRepository = productRepository;
        this.pickNPayRepository = pickNPayRepository;
        this.woolworthRepository = woolworthRepository;
        this.pickNPayService = pickNPayService;
        this.woolworthsService = woolworthsService;
        this.productService = productService;
    }


    @Transactional
    public boolean saveBulk (AlphaDTO alphaDTO)
    {
     productService.saveProduct(alphaDTO.getProductDTO());
     woolworthsService.saveProduct(alphaDTO.getWoolworthsDTO());
     pickNPayService.saveProduct(alphaDTO.getPickNPayDTO());
     return true ;
    }
    public AlphaDTO relax (ProductDTO productDTO)
    {
        System.out.println(pickNPayService.getProductById(productDTO.getId()));
        System.out.println(woolworthsService.getProductById(productDTO.getId()));

        AlphaDTO alphaDTO = AlphaDTO.builder()
                .productDTO(productDTO)

                .pickNPayDTO(pickNPayService.getProductById(productDTO.getId()))
                .woolworthsDTO(woolworthsService.getProductById(productDTO.getId()))
                .build();
        return alphaDTO;

    }
    public List<AlphaDTO>  getAllBulk ()
    {
        List<AlphaDTO> resultDTOList = new ArrayList<AlphaDTO>();
        List<ProductDTO> productDTOList = productService.getAllProductListed();

        productDTOList.forEach(value -> System.out.println(value.getId()+ '\n'+value.getProdTitle()));
        productDTOList.forEach(value -> resultDTOList.add(relax(value)));
        resultDTOList.forEach(value -> System.out.println(value.getPickNPayDTO().getTitle()+ '\n'+value.getPickNPayDTO().getTitle()+ '\n'+value.getPickNPayDTO().getTitle()));

        return resultDTOList;
    }



}
