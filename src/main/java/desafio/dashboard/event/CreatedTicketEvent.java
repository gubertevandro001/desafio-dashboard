package desafio.dashboard.event;

import desafio.dashboard.entity.Ticket;

public class CreatedTicketEvent {

    private final Object object;
    private final Ticket ticket;

    public CreatedTicketEvent(Object object, Ticket ticket) {
        this.object = object;
        this.ticket = ticket;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public Object getObject() {
        return object;
    }
}
