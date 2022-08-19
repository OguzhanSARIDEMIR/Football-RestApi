package com.works.restcontrollers;

import com.works.entities.Footballer;
import com.works.services.FootballerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/footballer")
public class FootballerRestController {
    final FootballerService fServices;

    public FootballerRestController(FootballerService fServices) {
        this.fServices = fServices;
    }
    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Footballer footballer){
        return fServices.save(footballer);
    }
    @PostMapping("/allsave")
    public ResponseEntity allsave(@Valid @RequestBody List<Footballer>  footballers){
        return fServices.allsave(footballers);
    }

}
