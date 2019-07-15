package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/population")
public class CountriesPopulation extends AbstractCountries {
    @GetMapping("/size/{people}")
    public ResponseEntity<?> getPopulationGreater(@PathVariable int people){
        ArrayList<Country> temp=list.getCountryList();
        temp.removeIf(country -> (int)country.getSize()<people);
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }

    @GetMapping("/min")
    public ResponseEntity<?> getMin(){
        ArrayList<Country> temp=list.getCountryList();

        temp.sort((Country c1, Country c2)->(int)(c1.getPopulation()-c2.getPopulation()));
        return new ResponseEntity<>(temp.get(0), HttpStatus.OK);
    }

    @GetMapping("/max")
    public ResponseEntity<?> getMax(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort((Country c1, Country c2)->(int)(c2.getPopulation()-c1.getPopulation()));
        return new ResponseEntity<>(temp.get(0),HttpStatus.OK);
    }

    @GetMapping("/median")
    public ResponseEntity<?> getMedian(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort((Country c1, Country c2)->(int)(c1.getPopulation()-c2.getPopulation()));
        if(temp.size()%2==1){
            return new ResponseEntity<>(temp.get((temp.size()/2)+1),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(temp.get(temp.size()/2),HttpStatus.OK);
        }
    }
}
