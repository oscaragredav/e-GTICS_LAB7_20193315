package com.example.lab7.repository;

import com.example.lab7.dto.TicketPorSitio;
import com.example.lab7.entity.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SiteRepository extends JpaRepository<Site,Integer> {

    @Query(nativeQuery = true, value = "select s.SiteName as Sitio, COUNT(t.TicketID) as Tickets\n" +
            "from site s \n" +
            "left join ticket t on t.SiteID = s.SiteID\n" +
            "group by s.SiteName;")
    List<TicketPorSitio> obtenerTicketPorSitio();

}
