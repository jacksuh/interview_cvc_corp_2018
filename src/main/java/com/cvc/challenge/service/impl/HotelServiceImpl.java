package com.cvc.challenge.service.impl;

import java.lang.reflect.Type;
import java.util.List;

import javax.validation.Valid;

import com.cvc.challenge.api.HotelApi;
import com.cvc.challenge.dto.HotelDTO;
import com.cvc.challenge.dto.custom.HotelApiDTO;
import com.cvc.challenge.dto.custom.HotelNoIdDTO;
import com.cvc.challenge.model.Hotel;
import com.cvc.challenge.repository.HotelRepository;
import com.cvc.challenge.service.HotelService;

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

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service("hotelService")
public class HotelServiceImpl extends GenericServiceImpl<Hotel, Long> implements HotelService {

    @Autowired
    private HotelRepository repository;

    private final HotelApi api;

    /** MODEL MAPPER */
    private final ModelMapper mapper = new ModelMapper();
    private final Type pageableTypeHotelDTO = new TypeToken<Page<HotelDTO>>() {}.getType(); // getPage Type for HotelDTO

    @Override
    public HotelDTO create(HotelNoIdDTO hotel) {
        Hotel newHotel = mapper.map(hotel, Hotel.class);
        return mapper.map(repository.save(newHotel), HotelDTO.class);
    }

    @Override
    public HotelDTO read(Long id) {
        return mapper.map(repository.getOne(id), HotelDTO.class);
    }

    @Override
    public HotelDTO update(@Valid HotelDTO hotel) {
        HotelDTO theHotel = mapper.map(repository.getOne(hotel.getId()), HotelDTO.class);
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
        mapper.map(hotel, theHotel);
        Hotel newHotel = mapper.map(theHotel, Hotel.class);
        return mapper.map(repository.save(newHotel), HotelDTO.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<HotelDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        Page<Hotel> var = repository.findAll(pagination);
        return (mapper.map(var, pageableTypeHotelDTO));
    }

    @Override
    public Page<HotelDTO> search(HotelDTO hotel, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("id");
        Example<Hotel> query = Example.of(mapper.map(hotel, Hotel.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypeHotelDTO));
    }

    @Override
    public Page<HotelDTO> find(HotelDTO hotel, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT).withIgnorePaths("id");
        Example<Hotel> query = Example.of(mapper.map(hotel, Hotel.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypeHotelDTO));
    }

    @Override
    public List<HotelApiDTO> listApi(Long cityId) {
        return api.getHotelsByCity(cityId);
        // return null;
    }



}