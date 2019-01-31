package com.cvc.challenge.service;

import javax.validation.Valid;

import com.cvc.challenge.dto.RoomDTO;
import com.cvc.challenge.dto.custom.RoomNoIdDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;

public interface RoomService {

    public RoomDTO create(RoomNoIdDTO room);

    public RoomDTO read(Long id);

    public RoomDTO update(@Valid RoomDTO room);

    public void delete(Long id);

    public Page<RoomDTO> list(Integer pageNumber, Integer pageSize, Direction direction, String orderBy);

    public Page<RoomDTO> search(RoomDTO room, Integer pageNumber, Integer pageSize, Direction direction,
            String orderBy);

    public Page<RoomDTO> find(RoomDTO room, Integer pageNumber, Integer pageSize, Direction direction, String orderBy);


}