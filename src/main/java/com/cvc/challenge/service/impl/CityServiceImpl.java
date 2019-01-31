package com.cvc.challenge.service.impl;

import java.lang.reflect.Type;

import javax.validation.Valid;

import com.cvc.challenge.dto.CityDTO;
import com.cvc.challenge.dto.custom.NoIdCityDTO;
import com.cvc.challenge.model.City;
import com.cvc.challenge.repository.CityRepository;
import com.cvc.challenge.service.CityService;

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

@Service("cityService")
public class CityServiceImpl extends GenericServiceImpl<City, Long> implements CityService {

    @Autowired
    private CityRepository repository;

    /** MODEL MAPPER */
    private final ModelMapper mapper = new ModelMapper();
    private final Type pageableTypeCityDTO = new TypeToken<Page<CityDTO>>() {}.getType(); // getPage Type for CityDTO

    @Override
    public CityDTO create(NoIdCityDTO city) {
        City newCity = mapper.map(city, City.class);
        return mapper.map(repository.save(newCity), CityDTO.class);
    }

    @Override
    public CityDTO read(Long id) {
        return mapper.map(repository.getOne(id), CityDTO.class);
    }

    @Override
    public CityDTO update(@Valid CityDTO city) {
        CityDTO theCity = mapper.map(repository.getOne(city.getId()), CityDTO.class);
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
        mapper.map(city, theCity);
        City newCity = mapper.map(theCity, City.class);
        return mapper.map(repository.save(newCity), CityDTO.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<CityDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        Page<City> var = repository.findAll(pagination);
        return (mapper.map(var, pageableTypeCityDTO));
    }

    @Override
    public Page<CityDTO> search(CityDTO city, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("id");
        Example<City> query = Example.of(mapper.map(city, City.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypeCityDTO));
    }

    @Override
    public Page<CityDTO> find(CityDTO city, Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT).withIgnorePaths("id");
        Example<City> query = Example.of(mapper.map(city, City.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypeCityDTO));
    }

}