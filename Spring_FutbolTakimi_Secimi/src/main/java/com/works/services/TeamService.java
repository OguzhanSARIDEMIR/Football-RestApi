package com.works.services;

import com.works.entities.Team;
import com.works.repositories.FootballerRepository;
import com.works.repositories.TeamRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TeamService {
    final TeamRepository tRepo;
    final FootballerRepository fRepo;

    public TeamService(TeamRepository tRepo, FootballerRepository fRepo) {
        this.tRepo = tRepo;
        this.fRepo = fRepo;
    }

    public ResponseEntity save(Team team) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            boolean status=fRepo.existsByFidEquals(team.getFid());
            if (!status) {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "Böyle bir futbolcu yok");
                hm.put(ERest.result, team);


            }else {
                tRepo.save(team);
                hm.put(ERest.status, true);
                hm.put(ERest.message, "Kayıt İşlemi Başarılı");
                hm.put(ERest.result, team);


            }
            tRepo.save(team);
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Kayıt İşlemi Başarılı");
            hm.put(ERest.result, team);

        } catch (Exception ex) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Bu futbolcu daha önce bir takıma atanmıştır");

        }


        return new ResponseEntity(hm, HttpStatus.OK);

    }
}
