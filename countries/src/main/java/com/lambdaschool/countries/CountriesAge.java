package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Comparator;

@RestController
@RequestMapping("/age")
public class CountriesAge extends AbstractCountries {
    @RequestMapping("/age/{age}")
    public ResponseEntity<?> getByAgeMin(@PathVariable int age){
        ArrayList<Country> temp=list.getCountryList();
        temp.removeIf(country -> country.getMedian_age()<age);
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    @RequestMapping(value = "/min",
                    produces={"application/json"})
    public ResponseEntity<?> getMinMedianAge(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort(Comparator.comparingInt(Country::getMedian_age));
        return new ResponseEntity<>(temp.get(0),HttpStatus.OK);
    }

    @RequestMapping(value="/max",
                    produces={"application/json"})
    public ResponseEntity<?> getMaxMedianAge(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort(Comparator.comparingInt(Country::getMedian_age));
        return new ResponseEntity<>(temp.get(temp.size()-1), HttpStatus.OK);
    }

    @RequestMapping(value = "/median",
                    produces={"application/json"})
    public ResponseEntity<?> getMedianMedianAge(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort(Comparator.comparingInt(Country::getMedian_age));
        if(temp.size()%2==1){
            return new ResponseEntity<>(temp.get((temp.size()/2)+1), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(temp.get(temp.size()/2), HttpStatus.OK);
        }
    }
}
