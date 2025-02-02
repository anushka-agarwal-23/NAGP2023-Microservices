package com.nagp.searchservice.controller;

import com.nagp.searchservice.delegate.SearchDelegate;
import com.nagp.searchservice.dto.request.FlightSearchRequestDTO;
import com.nagp.searchservice.dto.request.HotelSearchRequestDTO;
import com.nagp.searchservice.dto.response.FlightDetailDTO;
import com.nagp.searchservice.dto.response.HotelDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class SearchController {

    @Autowired
    private SearchDelegate searchDelegate;

    @GetMapping("/search-flight")
    public ResponseEntity<List<FlightDetailDTO>> searchFlight(@RequestBody @Valid FlightSearchRequestDTO flightSearchRequestDTO) {
        log.info("SearchController.searchFlight started");
        List<FlightDetailDTO> response = searchDelegate.searchFlight(flightSearchRequestDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("/search-hotel")
    public ResponseEntity<List<HotelDetailDTO>> searchHotel(@RequestBody @Valid HotelSearchRequestDTO hotelSearchRequestDTO) {
        log.info("SearchController.searchHotel started");
        List<HotelDetailDTO> response = searchDelegate.searchHotel(hotelSearchRequestDTO);
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
