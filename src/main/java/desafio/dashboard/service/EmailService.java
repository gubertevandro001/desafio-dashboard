package desafio.dashboard.service;

import desafio.dashboard.entity.Ticket;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    public void sendEmailToClient(final Ticket ticket) throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("Enviando email para o cliente " + ticket.getClient().getName());
    }
}
