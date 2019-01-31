package com.cvc.challenge.service.impl;

import javax.validation.Valid;

import com.cvc.challenge.dto.RoomDTO;
import com.cvc.challenge.dto.custom.RoomNoIdDTO;
import com.cvc.challenge.model.Room;
import com.cvc.challenge.repository.RoomRepository;
import com.cvc.challenge.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public class RoomServiceImpl extends GenericServiceImpl<Room, Long> implements RoomService {

    @Autowired
    private RoomRepository repository;

    @Override
    public RoomDTO create(RoomNoIdDTO room) {
        return null;
    }

    @Override
    public RoomDTO read(Long id) {
        return null;
    }

    @Override
    public RoomDTO update(@Valid RoomDTO room) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<RoomDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        return null;
    }

    @Override
    public Page<RoomDTO> search(RoomDTO room, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy) {
        return null;
    }

    @Override
    public Page<RoomDTO> find(RoomDTO room, Integer pageNumber, Integer pageSize, Direction direction, String orderBy) {
        return null;
    }

}