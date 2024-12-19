package desafio.dashboard.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "Ticket")
@Table(name = "TICKET")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITLE", nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "FK_ID_MODULE", nullable = false)
    private Module module;

    @ManyToOne
    @JoinColumn(name = "FK_ID_CLIENT", nullable = false)
    private Client client;

    @Column(name = "OPENING_DATE", nullable = false)
    private LocalDate openingDate;

    @Column(name = "CLOSING_DATE")
    private LocalDate closingDate;

    public Ticket() {
    }

    private Ticket(final Long id, final String title, final Module module, final Client client, final LocalDate openingDate, final LocalDate closingDate) {
        this.id = id;
        this.title = title;
        this.module = module;
        this.client = client;
        this.openingDate = openingDate;
        this.closingDate = closingDate;
    }

    public static Ticket newTicket(final String title, final Module module, final Client client) {
        final var date = LocalDate.now();
        return new Ticket(null, title, module, client, date, null);
    }


    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Module getModule() {
        return module;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }
}
