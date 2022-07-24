package com.cintech.PriceJuxtapose.controller;

import com.cintech.PriceJuxtapose.dto.WoolworthsDTO;
import com.cintech.PriceJuxtapose.service.WoolworthsService;
import com.cintech.PriceJuxtapose.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class WoolworthsController {



    //http://localhost:8080/test/
    private final ProductService productService;
    private final WoolworthsService pickNPayService;

    public WoolworthsController(ProductService productService, WoolworthsService pickNPayService) {
        this.productService = productService;
        this.pickNPayService = pickNPayService;
    }

    //http://localhost:8080/test/getWoolworthsProducts
    //-----------------------------GET all Woolworths products------------------------------------------------
    @GetMapping("/getAllWoolworthsProducts")
    public List<WoolworthsDTO> getWoolworthsProducts() {
        return pickNPayService.getALL();
    }

    //http://localhost:8080/test/getWoolworthsProductById
    //-----------------------------GET all Woolworths products By ID------------------------------------------------
    @GetMapping("/getALLWoolworthsProductById/{id}")
    public WoolworthsDTO getWoolworthsProductById(@PathVariable Long id) {
        return pickNPayService.getProductById(id);
    }

    //http://localhost:8080/test/getWoolworthsProductsByTitle
    //-----------------------------GET all Woolworths products By Title------------------------------------------------
    @GetMapping("/getWoolworthsProductsByTitle/{title}")
    public List<WoolworthsDTO> getWoolworthsProductsByTitle(@PathVariable String title) {
        return pickNPayService.getProductByTitleContaining(title);
    }

    //http://localhost:8080/test/getWoolworthsProductByPriceBetween
    // GET all Woolworths products By Price Between
    //-----------------------------------------------------------------------------
    @GetMapping("/getWoolworthsProductByPriceBetween/{min}/{max}")
    public List<WoolworthsDTO> getWoolworthsProductByPriceBetween(@PathVariable double min, @PathVariable double max) {
        return pickNPayService.getProductByPriceBetween(min, max);
    }

    //http://localhost:8080/test/addWoolworthsProduct
    // ADD Woolworths product
    //-----------------------------------------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addWoolworthsProduct")
    public boolean addWoolworthsProduct(@RequestBody WoolworthsDTO pickNPay) {
        pickNPayService.saveProduct(pickNPay);
        return true;
    }


    //http://localhost:8080/test/addWoolworthsProducts
    // ADD Woolworths products
    //-----------------------------------------------------------------------------
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/addWoolworthsProducts")
    public boolean addWoolworthsProducts(@RequestBody List<WoolworthsDTO> pickNPay) {
        pickNPay.forEach(value -> pickNPayService.saveProduct(value));
        return true;
    }

}