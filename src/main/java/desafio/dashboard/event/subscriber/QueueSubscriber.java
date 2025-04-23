package desafio.dashboard.event.subscriber;

import desafio.dashboard.event.CreatedTicketEvent;
import desafio.dashboard.service.QueueService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class QueueSubscriber {

    private final QueueService queueService;

    public QueueSubscriber(QueueService queueService) {
        this.queueService = queueService;
    }

    @Async
    @EventListener
    public void postMessageToQueue(final CreatedTicketEvent event) {
        queueService.postMessageToQueue(event.getTicket());
    }
}
