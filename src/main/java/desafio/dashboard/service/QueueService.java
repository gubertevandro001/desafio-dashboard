package desafio.dashboard.service;

import desafio.dashboard.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class QueueService {

    public void postMessageToQueue(final Ticket ticket) {
        System.out.println("Ticket de ID: " + ticket.getId() + " criado com sucesso!");
    }
}
