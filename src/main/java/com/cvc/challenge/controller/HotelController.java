package com.cvc.challenge.controller;

import javax.validation.Valid;

import com.cvc.challenge.dto.HotelDTO;
import com.cvc.challenge.dto.custom.HotelNoIdDTO;
import com.cvc.challenge.service.HotelService;

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
@Api(value = "Hotel")
@RestController
@RequestMapping("/hotel")
public class HotelController {
    
    private final HotelService service;

    @Autowired
    public HotelController(HotelService service) {
        this.service = service;
    }

    /**
     * Create a new single hotel on Database
     * 
     * @param hotel - A Single Hotel Object with basic info of a Hotel
     * @return A Single Hotel Object that was just created
     * 
     */
    @ApiOperation(value = "Create new Hotel")
    @RequestMapping(method = RequestMethod.POST)
    public HotelDTO create(@ApiParam(value = "Hotel", required = true) @RequestBody HotelNoIdDTO hotel) {
        return (service.create(hotel));
    }

    /**
     * Get single hotel from Database
     * 
     * @param id - Unique Identifier of a Hotel
     * @return A Single Hotel Object that was requested by id
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Hotel by Id")
    public HotelDTO read(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        return (service.read(id));
    }

    /**
     * Updates a single hotel on Database
     * 
     * @param hotel - A Single Hotel Object the id of existing Object and new data
     *              tobe applied
     * @return A Single Hotel Object that was just updated
     * 
     */
    @ApiOperation(value = "Update Hotel")
    @RequestMapping(method = RequestMethod.PUT)
    public HotelDTO update(@ApiParam(value = "Hotel", required = true) @RequestBody @Valid HotelDTO hotel) {
        return (service.update(hotel));
    }

    /**
     * Delete a single hotel from Database
     * 
     * @param id - Unique Identifier of a Hotel
     * 
     */
    @ApiOperation(value = "Delete Hotel by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        service.delete(id);
    }

    /**
     * List all Hotels from Database
     * 
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Hotels Collection
     * 
     */
    @ApiOperation(value = "list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<HotelDTO> list(
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.list(pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Hotels from Database matching with <b>CONTAINING</b> filters
     * 
     * @param hotel      - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Hotels Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "search")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<HotelDTO> search(@ApiParam(value = "Hotel", required = true) HotelDTO hotel,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.search(hotel, pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Hotels from Database matching with <b>EXACT</b> filters
     * 
     * @param hotel      - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Hotels Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "find")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Page<HotelDTO> find(@ApiParam(value = "Hotel", required = true) HotelDTO hotel,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.find(hotel, pageNumber, pageSize, direction, orderBy));
    }

}