package desafio.dashboard.repository;

import desafio.dashboard.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE MONTH(t.openingDate) = ?1 AND YEAR(t.openingDate) = ?2")
    List<Ticket> findAllByMonthAndYear(Integer month, Integer year);
}
