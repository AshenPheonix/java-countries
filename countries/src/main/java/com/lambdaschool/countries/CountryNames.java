package com.lambdaschool.countries;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/names")
public class CountryNames extends AbstractCountries{

    @GetMapping(value="/all",
                produces={"application/json"})
    public ResponseEntity<?> getAll(){
        ArrayList<Country> temp=list.getCountryList();
        temp.sort((Country c1, Country c2)-> c1.getName().compareToIgnoreCase(c2.getName()));
        System.out.println("okay");
        return new ResponseEntity<>(temp, HttpStatus.OK);
    }
    @GetMapping(value="/start/{letter}",
                produces={"application/json"})
    public ResponseEntity<?> getNameStart(@PathVariable String letter){
        ArrayList<Country> temp=list.getCountryList();

        temp.removeIf(c-> !c.getName().substring(0,1).equalsIgnoreCase(letter));
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }

    @GetMapping(value = "/size/{number}",
                produces={"application/json"})
    public ResponseEntity<?> getNameSize(@PathVariable int number){
        ArrayList<Country> temp=list.getCountryList();

        temp.removeIf(c->c.getName().length()<number);
        return new ResponseEntity<>(temp,HttpStatus.OK);
    }
}
