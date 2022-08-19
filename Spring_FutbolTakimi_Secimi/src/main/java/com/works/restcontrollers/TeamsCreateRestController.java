package com.works.restcontrollers;
import com.works.repositories.FootTeamRepository;
import com.works.utils.TEnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/teams")
public class TeamsCreateRestController {
    final FootTeamRepository ftRepo;

    public TeamsCreateRestController(FootTeamRepository ftRepo) {
        this.ftRepo = ftRepo;
    }
    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate(@RequestParam TEnum t){
        return new ResponseEntity(ftRepo.teamAsil(t.ordinal()), HttpStatus.OK);
    }
    @GetMapping("/baackUpCreate")
    public ResponseEntity baackUpCreate(@RequestParam TEnum t){
        return new ResponseEntity(ftRepo.teamYedek(t.ordinal()), HttpStatus.OK);
    }


}
