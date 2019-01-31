package com.cvc.challenge.controller;

import javax.validation.Valid;

import com.cvc.challenge.dto.PriceDTO;
import com.cvc.challenge.dto.custom.PriceNoIdDTO;
import com.cvc.challenge.service.PriceService;

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
@Api(value = "Price")
@RestController
@RequestMapping("/price")
public class PriceController {
    private final PriceService service;

    @Autowired
    public PriceController(PriceService service) {
        this.service = service;
    }

    /**
     * Create a new single price on Database
     * 
     * @param price - A Single Price Object with basic info of a Price
     * @return A Single Price Object that was just created
     * 
     */
    @ApiOperation(value = "Create new Price")
    @RequestMapping(method = RequestMethod.POST)
    public PriceDTO create(@ApiParam(value = "Price", required = true) @RequestBody PriceNoIdDTO price) {
        return (service.create(price));
    }

    /**
     * Get single price from Database
     * 
     * @param id - Unique Identifier of a Price
     * @return A Single Price Object that was requested by id
     * 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Price by Id")
    public PriceDTO read(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        return (service.read(id));
    }

    /**
     * Updates a single price on Database
     * 
     * @param price - A Single Price Object the id of existing Object and new data
     *              tobe applied
     * @return A Single Price Object that was just updated
     * 
     */
    @ApiOperation(value = "Update Price")
    @RequestMapping(method = RequestMethod.PUT)
    public PriceDTO update(@ApiParam(value = "Price", required = true) @RequestBody @Valid PriceDTO price) {
        return (service.update(price));
    }

    /**
     * Delete a single price from Database
     * 
     * @param id - Unique Identifier of a Price
     * 
     */
    @ApiOperation(value = "Delete Price by Id")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        service.delete(id);
    }

    /**
     * List all Prices from Database
     * 
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Prices Collection
     * 
     */
    @ApiOperation(value = "list")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Page<PriceDTO> list(
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.list(pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Prices from Database matching with <b>CONTAINING</b> filters
     * 
     * @param price      - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Prices Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "search")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Page<PriceDTO> search(@ApiParam(value = "Price", required = true) PriceDTO price,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.search(price, pageNumber, pageSize, direction, orderBy));
    }

    /**
     * Search all Prices from Database matching with <b>EXACT</b> filters
     * 
     * @param price      - Object filled with attributes to be used as filters
     * @param pageNumber - Page that will be shown on Response
     * @param pageSize   - Number of items to display on requested Page
     * @param direction  - Order of items ASC / DESC
     * @param orderBy    - Attribute that will be used as Order Index
     * @return A pageable element with a Prices Collection that matched with given
     *         Exemple
     * 
     */
    @ApiOperation(value = "find")
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public Page<PriceDTO> find(@ApiParam(value = "Price", required = true) PriceDTO price,
            @RequestParam(value = "Page Number", defaultValue = "0", required = true) Integer pageNumber,
            @RequestParam(value = "Page Size", defaultValue = "20", required = true) Integer pageSize,
            @RequestParam(value = "Direction", defaultValue = "ASC", required = true) Direction direction,
            @RequestParam(value = "Ordered By", defaultValue = "id", required = true) String orderBy) {
        return (service.find(price, pageNumber, pageSize, direction, orderBy));
    }
}