package com.cintech.PriceJuxtapose.service;
import com.cintech.PriceJuxtapose.dto.WoolworthsDTO;
import com.cintech.PriceJuxtapose.dto.WoolworthsDTO;
import com.cintech.PriceJuxtapose.entity.PickNPay;
import com.cintech.PriceJuxtapose.entity.Woolworth;
import com.cintech.PriceJuxtapose.repository.WoolworthRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WoolworthsService {

    private WoolworthRepository woolworthRepository;
    private ModelMapper mapper;

    public WoolworthsService(WoolworthRepository woolworthRepository) {
        this.woolworthRepository = woolworthRepository;
    }
    public Woolworth convertDTOtoEntity (WoolworthsDTO woolworthsDTO)
    {
        this.mapper = new ModelMapper();
        TypeMap<WoolworthsDTO, Woolworth> propertyMapper = this.mapper.createTypeMap(WoolworthsDTO.class, Woolworth.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getProductDTO(), Woolworth::setProduct));
        Woolworth result = this.mapper.map(woolworthsDTO, Woolworth.class);
        return result;
    }

    public WoolworthsDTO convertEntityToDTO (Woolworth woolworths)
    {
        this.mapper = new ModelMapper();
        TypeMap<Woolworth, WoolworthsDTO> propertyMapper = this.mapper.createTypeMap(Woolworth.class, WoolworthsDTO.class);
        propertyMapper.addMappings(mapper -> mapper.map(src -> src.getProduct(), WoolworthsDTO::setProductDTO));
        WoolworthsDTO result = this.mapper.map(woolworths,WoolworthsDTO.class);
        return result;
    }


    public WoolworthsDTO getProductById (Long id)
    {
        return convertEntityToDTO(woolworthRepository.findWoolworthsById(id));
    }
    public List<WoolworthsDTO> getProductByTitleContaining (String title)
    {
        List<WoolworthsDTO> result = new ArrayList<WoolworthsDTO>();
        woolworthRepository.findWoolworthsByTitleContainingIgnoreCase(title).forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }
    public List<WoolworthsDTO> getProductByUrlContaining (String url)
    {
        List<WoolworthsDTO> result = new ArrayList<WoolworthsDTO>();
        woolworthRepository.findWoolworthsByUrlLike(url).forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }

    public List<WoolworthsDTO> getProductByPriceBetween(double min , double max)
    {
        List<WoolworthsDTO> result = new ArrayList<WoolworthsDTO>();
        woolworthRepository.findWoolworthsByPriceBetween(min ,max).forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }
    public List<WoolworthsDTO> getALL ()
    {
        List<WoolworthsDTO> result = new ArrayList<WoolworthsDTO>();
        woolworthRepository.findAll().forEach(value -> result.add(convertEntityToDTO(value)));
        return result ;
    }

    public Woolworth saveProduct (WoolworthsDTO woolworthDTO) {
        return woolworthRepository.save(convertDTOtoEntity(woolworthDTO));
    }


}
