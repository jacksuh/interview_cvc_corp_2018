package com.cvc.challenge.controller;

import javax.validation.Valid;

import com.cvc.challenge.dto.RoomDTO;
import com.cvc.challenge.dto.custom.NoIdRoomDTO;
import com.cvc.challenge.service.RoomService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * Simples CRUD operarions Advanced Search and List
 * 
 * @author Rodrigo Dantas - rodrigodantas.91@gmail.com
 * @since 2019.01.30
 * 
 */
@Api(value = "Room")
@RestController
@RequestMapping("/room")
public class RoomController {
    private final RoomService service;

    @Autowired
    public RoomController(RoomService service) {
        this.service = service;
    }

    /**
     * Create a new single room on Database
     * 
     * @param room - A Single Room Object with basic info of a Room
     * @return A Single Room Object that was just created
     * 
     */
    @ApiOperation(value = "Create new Room")
    @RequestMapping(method = RequestMethod.POST)
    public RoomDTO create(@ApiParam(value = "Room", required = true) @RequestBody NoIdRoomDTO room) {
        return (service.create(room));
    }

    /**
     * Get single room from Database
     * 
     * @param id - Unique Identifier of a Room
     * @return A Single Room Object that was requested by id
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Room by Id")
    public RoomDTO read(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        return (service.read(id));
    }

    /**
     * Updates a single room on Database
     * 
     * @param room - A Single Room Object the id of existing Object and new data
     *              tobe applied
     * @return A Single Room Object that was just updated
     * 
     */
    @ApiOperation(value = "Update Room")
    @RequestMapping(method = RequestMethod.PUT)
    public RoomDTO update(@ApiParam(value = "Room", required = true) @RequestBody @Valid RoomDTO room) {
        return (service.update(room));
    }

    /**
     * Delete a single room from Database
     * 
     * @param id - Unique Identifier of a Room
     * 
     */
    @ApiOperation(value = "Delete Room by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        service.delete(id);
    }

    /**
     * List all Rooms from Database
     * 
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Rooms Collection
     * 
     */
    @ApiOperation(value = "list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<RoomDTO> list(
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.list(pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Rooms from Database matching with <b>CONTAINING</b> filters
     * 
     * @param room      - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Rooms Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "search")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<RoomDTO> search(@ApiParam(value = "Room", required = true) RoomDTO room,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.search(room, pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Rooms from Database matching with <b>EXACT</b> filters
     * 
     * @param room      - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Rooms Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "find")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Page<RoomDTO> find(@ApiParam(value = "Room", required = true) RoomDTO room,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.find(room, pageNumber, pageSize, direction, orderBy));
    }
}