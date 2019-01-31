package com.cvc.challenge.service.impl;

import java.lang.reflect.Type;

import javax.validation.Valid;

import com.cvc.challenge.dto.PriceDTO;
import com.cvc.challenge.dto.custom.PriceNoIdDTO;
import com.cvc.challenge.model.Price;
import com.cvc.challenge.repository.PriceRepository;
import com.cvc.challenge.service.PriceService;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.modelmapper.config.Configuration.AccessLevel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service("priceService")
public class PriceServiceImpl extends GenericServiceImpl<Price, Long> implements PriceService {

    @Autowired
    private PriceRepository repository;

    /** MODEL MAPPER */
    private final ModelMapper mapper = new ModelMapper();
    private final Type pageableTypePriceDTO = new TypeToken<Page<PriceDTO>>() {}.getType(); // getPage Type for PriceDTO

    @Override
    public PriceDTO create(PriceNoIdDTO price) {
        Price newPrice = mapper.map(price, Price.class);
        return mapper.map(repository.save(newPrice), PriceDTO.class);
    }

    @Override
    public PriceDTO read(Long id) {
        return mapper.map(repository.getOne(id), PriceDTO.class);
    }

    @Override
    public PriceDTO update(@Valid PriceDTO price) {
        PriceDTO thePrice = mapper.map(repository.getOne(price.getId()), PriceDTO.class);
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
        mapper.map(price, thePrice);
        Price newPrice = mapper.map(thePrice, Price.class);
        return mapper.map(repository.save(newPrice), PriceDTO.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<PriceDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        Page<Price> var = repository.findAll(pagination);
        return (mapper.map(var, pageableTypePriceDTO));
    }

    @Override
    public Page<PriceDTO> search(PriceDTO price, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("id");
        Example<Price> query = Example.of(mapper.map(price, Price.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypePriceDTO));
    }

    @Override
    public Page<PriceDTO> find(PriceDTO price, Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT).withIgnorePaths("id");
        Example<Price> query = Example.of(mapper.map(price, Price.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypePriceDTO));
    }

}