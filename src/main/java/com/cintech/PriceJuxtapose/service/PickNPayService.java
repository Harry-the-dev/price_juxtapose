package com.cintech.PriceJuxtapose.service;

import com.cintech.PriceJuxtapose.dto.PickNPayDTO;
import com.cintech.PriceJuxtapose.dto.ProductDTO;
import com.cintech.PriceJuxtapose.entity.PickNPay;
import com.cintech.PriceJuxtapose.entity.Product;
import com.cintech.PriceJuxtapose.repository.PickNPayRepository;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;


@Service
public class PickNPayService {


    private PickNPayRepository pickNPayRepository;
    private ModelMapper mapper;

    public PickNPayService(PickNPayRepository pickNPayRepository) {
        this.pickNPayRepository = pickNPayRepository;
    }

    public PickNPay convertDTOtoEntity (PickNPayDTO pickNPayDTO)
    {

        this.mapper = new ModelMapper();
        TypeMap<PickNPayDTO, PickNPay> propertyMapper = this.mapper.createTypeMap(PickNPayDTO.class, PickNPay.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getProductDTO(), PickNPay::setProduct));
        PickNPay result = this.mapper.map(pickNPayDTO, PickNPay.class);
        return result;
    }

    public PickNPayDTO convertEntityToDTO (PickNPay pickNPay)
    {
        this.mapper = new ModelMapper();
        TypeMap<PickNPay, PickNPayDTO> propertyMapper = this.mapper.createTypeMap(PickNPay.class, PickNPayDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getProduct(), PickNPayDTO::setProductDTO));
        PickNPayDTO result = this.mapper.map(pickNPay,PickNPayDTO.class);
      return result;
    }



    public PickNPayDTO getProductById (Long id)
    {
        return convertEntityToDTO(pickNPayRepository.findPickNPayById(id));
    }
    public List<PickNPayDTO> getProductsByTitleContaining (String title)
    {
        List<PickNPayDTO> result = new ArrayList<PickNPayDTO>();
        pickNPayRepository.findPickNPayByTitleContainingIgnoreCase(title).forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }
    public List<PickNPayDTO> getProductsByUrlContaining (String url)
    {
        List<PickNPayDTO> result = new ArrayList<PickNPayDTO>();
        pickNPayRepository.findPickNPayByUrlLike(url).forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }

    public List<PickNPayDTO> getProductsByPriceBetween(double min , double max)
    {
        List<PickNPayDTO> result = new ArrayList<PickNPayDTO>();
        pickNPayRepository.findPickNPayByPriceBetween(min ,max).forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }
    public List<PickNPayDTO> getALL ()
    {
        List<PickNPayDTO> result = new ArrayList<PickNPayDTO>();
        pickNPayRepository.findAll().forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }

    public PickNPay saveProduct (PickNPayDTO pickNPayDTO) {
        return pickNPayRepository.save(convertDTOtoEntity(pickNPayDTO));
    }



}
