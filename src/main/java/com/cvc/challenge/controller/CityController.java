package com.cvc.challenge.controller;

import javax.validation.Valid;

import com.cvc.challenge.dto.CityDTO;
import com.cvc.challenge.dto.custom.CityNoIdDTO;
import com.cvc.challenge.service.CityService;

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
@Api(value = "City")
@RestController
@RequestMapping("/city")
public class CityController {
    private final CityService service;

    @Autowired
    public CityController(CityService service) {
        this.service = service;
    }

    /**
     * Create a new single city on Database
     * 
     * @param city - A Single City Object with basic info of a City
     * @return A Single City Object that was just created
     * 
     */
    @ApiOperation(value = "Create new City")
    @RequestMapping(method = RequestMethod.POST)
    public CityDTO create(@ApiParam(value = "City", required = true) @RequestBody CityNoIdDTO city) {
        return (service.create(city));
    }

    /**
     * Get single city from Database
     * 
     * @param id - Unique Identifier of a City
     * @return A Single City Object that was requested by id
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "City by Id")
    public CityDTO read(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        return (service.read(id));
    }

    /**
     * Updates a single city on Database
     * 
     * @param city - A Single City Object the id of existing Object and new data
     *             tobe applied
     * @return A Single City Object that was just updated
     * 
     */
    @ApiOperation(value = "Update City")
    @RequestMapping(method = RequestMethod.PUT)
    public CityDTO update(@ApiParam(value = "City", required = true) @RequestBody @Valid CityDTO city) {
        return (service.update(city));
    }

    /**
     * Delete a single city from Database
     * 
     * @param id - Unique Identifier of a City
     * 
     */
    @ApiOperation(value = "Delete City by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        service.delete(id);
    }

    /**
     * List all Citys from Database
     * 
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Citys Collection
     * 
     */
    @ApiOperation(value = "list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<CityDTO> list(
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.list(pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Citys from Database matching with <b>CONTAINING</b> filters
     * 
     * @param city       - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Citys Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "search")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<CityDTO> search(@ApiParam(value = "City", required = true) CityDTO city,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.search(city, pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Citys from Database matching with <b>EXACT</b> filters
     * 
     * @param city       - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Citys Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "find")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Page<CityDTO> find(@ApiParam(value = "City", required = true) CityDTO city,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.find(city, pageNumber, pageSize, direction, orderBy));
    }
}