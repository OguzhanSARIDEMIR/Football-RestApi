package com.works.repositories;

import com.works.entities.FootTeam;
import com.works.utils.TEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FootTeamRepository extends JpaRepository<FootTeam, Integer> {
    @Query(value = "SELECT t.tid,t.name as fname,f.name,f.fid,f.surname,f.email,f.age FROM team as t INNER JOIN footballer as f ON t.fid=f.fid WHERE t.name=?1 ORDER BY f.age LIMIT 0,11", nativeQuery = true)
    List<FootTeam> teamAsil(int t);

    @Query(value = "SELECT t.tid,t.name as fname,f.name,f.fid,f.surname,f.email,f.age FROM team as t INNER JOIN footballer as f ON t.fid=f.fid WHERE t.name=?1 ORDER BY f.age LIMIT 11,5",nativeQuery = true)
    List<FootTeam> teamYedek(int t);
}