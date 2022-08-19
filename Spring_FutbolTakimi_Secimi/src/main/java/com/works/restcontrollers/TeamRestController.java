package com.works.restcontrollers;

import com.works.entities.Team;
import com.works.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/team")
public class TeamRestController {
    final TeamService tService;

    public TeamRestController(TeamService tService) {
        this.tService = tService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Team team){
        return tService.save(team);
    }
}
