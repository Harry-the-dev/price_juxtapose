package com.cintech.PriceJuxtapose.repository;

import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.dto.ProductDTO;
import com.cintech.PriceJuxtapose.dto.WoolworthsDTO;
import com.cintech.PriceJuxtapose.entity.PickNPay;
import com.cintech.PriceJuxtapose.entity.Product;
import com.cintech.PriceJuxtapose.entity.Woolworth;
import com.cintech.PriceJuxtapose.service.PickNPayService;
import com.cintech.PriceJuxtapose.service.ProductService;
import com.cintech.PriceJuxtapose.service.WoolworthsService;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PickNPayRepositoryTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private PickNPayService pickNPayService;

    @Autowired
    private WoolworthsService woolworthsService;
    @Autowired
    private PickNPayRepository pickNPayRepository;
    @Autowired
    private PickNPayRepository woolworthsRepository;

    @Autowired
    private PickNPayRepository productRepository;

    private ModelMapper mapper;


    public void printDTO(PickNPayDTO result) {
        System.out.println(result.getProductDTO().getId());
        System.out.println(result.getProductDTO().getProdTitle());
        System.out.println(result.getProductDTO().getProdVolume());
        System.out.println(result.getProductDTO().getProdVolumeUnit());

        System.out.println(result.getId());
        System.out.println(result.getPrice());
        System.out.println(result.getTitle());
        System.out.println(result.getUrl());
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++");

    }

    public void printEntity(PickNPay result) {

        System.out.println(result.getProduct().getId());
        System.out.println(result.getProduct().getProdTitle());
        System.out.println(result.getProduct().getProdVolume());
        System.out.println(result.getProduct().getProdVolumeUnit());

        System.out.println(result.getId());
        System.out.println(result.getPrice());
        System.out.println(result.getTitle());
        System.out.println(result.getUrl());

    }

    public PickNPayDTO generateDTO() {
        ProductDTO product = ProductDTO.builder()
                .prodTitle("Jungle Oats")
                .prodVolume(1.0)
                .prodVolumeUnit("kg")
                .build();
        PickNPayDTO pickNPay = PickNPayDTO.builder()
                .title("Jungle Oats 1kg")
                .price(29.99)
                .url("https://www.pnp.co.za/pnpstorefront/pnp/en/All-Products/Food-Cupboard/Breakfast-Cereals-%26-Bars/Hot-Cereals/Jungle-Oats-1kg/p/000000000000253187_EA")
                .productDTO(product)
                .build();
        return pickNPay;

    }

    public PickNPay generatEntity() {
        Product product = Product.builder()
                .prodTitle("Jungle Oats")
                .prodVolume(1.0)
                .prodVolumeUnit("kg")
                .build();
        PickNPay pickNPay = PickNPay.builder()
                .title("Jungle Oats 1kg")
                .price(29.99)
                .url("https://www.pnp.co.za/pnpstorefront/pnp/en/All-Products/Food-Cupboard/Breakfast-Cereals-%26-Bars/Hot-Cereals/Jungle-Oats-1kg/p/000000000000253187_EA")
                .product(product)
                .build();
        return pickNPay;

    }


    @Test
    public void convertDTOtoEntityTest() {

        this.mapper = new ModelMapper();
        TypeMap<PickNPayDTO, PickNPay> propertyMapper = this.mapper.createTypeMap(PickNPayDTO.class, PickNPay.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getProductDTO(), PickNPay::setProduct));
        PickNPayDTO pickNPayDTO = generateDTO();
        PickNPay result = this.mapper.map(pickNPayDTO, PickNPay.class);


        assertNotNull(result.getProduct().getProdTitle());
        assertNotNull(result.getProduct().getProdVolume());
        assertNotNull(result.getProduct().getProdVolumeUnit());
        assertNotNull(result.getTitle());
        assertNotNull(result.getUrl());
        assertNotNull(result.getProduct());
        printEntity(result);

        printEntity(pickNPayRepository.save(result));


    }

    @Test
    public void convertEntitytoDTOTest() {

        this.mapper = new ModelMapper();
        TypeMap<PickNPay, PickNPayDTO> propertyMapper = this.mapper.createTypeMap(PickNPay.class, PickNPayDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getProduct(), PickNPayDTO::setProductDTO));

        PickNPay pickNPay = generatEntity();
        PickNPayDTO result = this.mapper.map(pickNPay, PickNPayDTO.class);


        assertNotNull(result.getProductDTO().getProdTitle());
        assertNotNull(result.getProductDTO().getProdVolume());
        assertNotNull(result.getProductDTO().getProdVolumeUnit());
        assertNotNull(result.getTitle());
        assertNotNull(result.getUrl());
        assertNotNull(result.getPrice());
        printDTO(result);

        pickNPayService.saveProduct(result);


    }


    @Test
    public void saveAllProduct6() {

        ProductDTO product = ProductDTO.builder()
                .prodTitle("Jacobs Krönung Instant Coffee")
                .prodVolume(200.00)
                .prodVolumeUnit("g")
                .build();

        PickNPayDTO pickNPay = PickNPayDTO.builder()
                .title("Jungle Oats 1kg")
                .price(29.99)
                .url("https://www.pnp.co.za/pnpstorefront/pnp/en/All-Products/Food-Cupboard/Breakfast-Cereals-%26-Bars/Hot-Cereals/Jungle-Oats-1kg/p/000000000000253187_EA")
                .productDTO(product)
                .build();

        WoolworthsDTO woolworth = WoolworthsDTO.builder()
                .title("Jungle Oats 1 kg")
                .price(29.99)
                .url("https://www.woolworths.co.za/prod/Food/Pantry/Breakfast-Cereals-Bars/Porridge-Oats/Jungle-Oats-1-kg/_/A-6001275000003")
                .productDTO(product)
                .build();


          pickNPayService.saveProduct(pickNPay);
          woolworthsService.saveProduct(woolworth);



    }
}

