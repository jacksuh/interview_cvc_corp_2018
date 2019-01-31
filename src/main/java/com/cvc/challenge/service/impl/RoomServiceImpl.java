package com.cvc.challenge.service.impl;

import java.lang.reflect.Type;

import javax.validation.Valid;

import com.cvc.challenge.dto.RoomDTO;
import com.cvc.challenge.dto.custom.NoIdRoomDTO;
import com.cvc.challenge.model.Room;
import com.cvc.challenge.repository.RoomRepository;
import com.cvc.challenge.service.RoomService;

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

@Service("roomService")
public class RoomServiceImpl extends GenericServiceImpl<Room, Long> implements RoomService {

    @Autowired
    private RoomRepository repository;

    /** MODEL MAPPER */
    private final ModelMapper mapper = new ModelMapper();
    private final Type pageableTypeRoomDTO = new TypeToken<Page<RoomDTO>>() {}.getType(); // getPage Type for RoomDTO

    @Override
    public RoomDTO create(NoIdRoomDTO room) {
        Room newRoom = mapper.map(room, Room.class);
        return mapper.map(repository.save(newRoom), RoomDTO.class);
    }

    @Override
    public RoomDTO read(Long id) {
        return mapper.map(repository.getOne(id), RoomDTO.class);
    }

    @Override
    public RoomDTO update(@Valid RoomDTO room) {
        RoomDTO theRoom = mapper.map(repository.getOne(room.getId()), RoomDTO.class);
        mapper.getConfiguration().setFieldMatchingEnabled(true).setFieldAccessLevel(AccessLevel.PRIVATE);
        mapper.map(room, theRoom);
        Room newRoom = mapper.map(theRoom, Room.class);
        return mapper.map(repository.save(newRoom), RoomDTO.class);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Page<RoomDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        Page<Room> var = repository.findAll(pagination);
        return (mapper.map(var, pageableTypeRoomDTO));
    }

    @Override
    public Page<RoomDTO> search(RoomDTO room, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING).withIgnorePaths("id");
        Example<Room> query = Example.of(mapper.map(room, Room.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypeRoomDTO));
    }

    @Override
    public Page<RoomDTO> find(RoomDTO room, Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        Pageable pagination = PageRequest.of(pageNumber, pageSize, direction, orderBy);
        ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.EXACT).withIgnorePaths("id");
        Example<Room> query = Example.of(mapper.map(room, Room.class), matcher);
        return (mapper.map(repository.findAll(query, pagination), pageableTypeRoomDTO));
    }

}