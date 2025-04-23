package desafio.dashboard.event.subscriber;

import desafio.dashboard.event.CreatedTicketEvent;
import desafio.dashboard.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailSubscriber {

    private final EmailService emailService;

    public EmailSubscriber(EmailService emailService) {
        this.emailService = emailService;
    }

    @Async
    @EventListener
    public void sendEmailToClient(final CreatedTicketEvent event) throws InterruptedException {
        emailService.sendEmailToClient(event.getTicket());
    }
}
