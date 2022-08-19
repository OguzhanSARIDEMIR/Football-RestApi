package com.works.services;

import com.works.entities.Footballer;
import com.works.repositories.FootballerRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FootballerService {
    final FootballerRepository fRepo;

    public FootballerService(FootballerRepository fRepo) {
        this.fRepo = fRepo;
    }
    public ResponseEntity save(Footballer footballer){
        Map<ERest,Object> hm=new LinkedHashMap<>();
        try {
            fRepo.save(footballer);
            hm.put(ERest.status,true);
            hm.put(ERest.message,"Kayıt İşlemi Başarılı");
            hm.put(ERest.result,footballer);

        }catch (Exception ex){
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Bu email daha önce kullanılmıştır");

        }


        return new ResponseEntity(hm, HttpStatus.OK);

    }
    public ResponseEntity allsave(List<Footballer> footballers){
        Map<ERest,Object> hm=new LinkedHashMap<>();
        for(Footballer item:footballers){
            fRepo.save(item);
        }

        hm.put(ERest.status,true);


        return new ResponseEntity(hm, HttpStatus.OK);

    }
}
