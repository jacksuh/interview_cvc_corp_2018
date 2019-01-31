package com.cvc.challenge.controller;

import java.util.Date;
import java.util.List;

import com.cvc.challenge.dto.custom.HotelApiDTO;
import com.cvc.challenge.service.PartnerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@Api(value = "Partner")
@RestController
@RequestMapping("/partner")
public class PartnerController {
    private final PartnerService service;

    @Autowired
    public PartnerController(PartnerService service) {
        this.service = service;
    }

    /**
     * Get a List of Hotels from partner's api
     * 
     * @param cityId - Unique Identifier of a city
     * @return A List of Hotels from partner's api
     * 
     */
    @ApiOperation(value = "list hotels from Partner")
    @RequestMapping(value = "/hotel/city/{city_id}", method = RequestMethod.GET)
    public List<HotelApiDTO> hotelListByCity(@ApiParam(value = "city Id", required = true) @PathVariable Long city_id) {
        return (service.hotelListByCity(city_id));
    }

    /**
     * Get a Single Hotel from partner's api
     * 
     * @param id - Unique Identifier of a Hotel
     * @return A requested Hotel from partner's api
     * 
     */
    @ApiOperation(value = "hotel from Partner")
    @RequestMapping(value = "/hotel/{id}", method = RequestMethod.GET)
    public List<HotelApiDTO> hotelById(@ApiParam(value = "Id", required = true) @PathVariable Long id) {
        return (service.hotelById(id));
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
    @RequestMapping(value = "/hotel/city", method = RequestMethod.GET)
    public List<HotelApiDTO> hotelListPriceByCity(@RequestParam(value = "CityCode", required = true) Long cityCode,
            @RequestParam(value = "CheckIn" , required = true) Date checkIn,
            @RequestParam(value = "CheckOut", required = true) Date checkOut,
            @RequestParam(value = "Adults", defaultValue = "0", required = true) Integer adult,
            @RequestParam(value = "Child", defaultValue = "0", required = true) Integer child) {
        return (service.hotelListPriceByCity(cityCode, checkIn, checkOut, adult, child));
    }

}