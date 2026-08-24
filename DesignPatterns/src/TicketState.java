interface TicketState {
    void assignToDeveloper(TicketContext ticket);
    void resolveTicket(TicketContext ticket);
    void closeTicket(TicketContext ticket);
}

class OpenState implements TicketState{
    @Override
    public void assignToDeveloper(TicketContext ticket){
        System.out.println("Ticket assigned to a developer. Moving to In Progress...");
        ticket.setState(new InProgressState());
    }

    @Override
    public void resolveTicket(TicketContext ticket){
        System.out.println("Cannot resolve directly! Ticket must be processed by a developer first.");
    }

    @Override
    public void closeTicket(TicketContext ticket){
        System.out.println();
        ticket.setState(new ClosedState());
    }
}

class InProgressState implements TicketState{
    @Override
    public void assignToDeveloper(TicketContext ticket){
        System.out.println("Ticket is already assigned to a developer.");
    }

    @Override
    public void resolveTicket(TicketContext ticket){
        System.out.println("Issue is fixed! Ticket is now resolved. Moving to Closed...");
        ticket.setState(new ClosedState());
    }

    @Override
    public void closeTicket(TicketContext ticket){
        System.out.println("Closing the ticket before finishing work...");
        ticket.setState(new ClosedState());
    }
}

class ClosedState implements TicketState{
    @Override
    public void assignToDeveloper(TicketContext ticket){
        System.out.println("Action denied! Ticket is closed. Open a new ticket if needed.");
    }

    @Override
    public void resolveTicket(TicketContext ticket){
        System.out.println("Ticket is already closed.");
    }

    @Override
    public void closeTicket(TicketContext ticket){
        System.out.println("Ticket is already closed.");
    }
}

class TicketContext{
    private TicketState currentState;
    private String title;

    public TicketContext(String title){
        this.title = title;
        this.currentState = new OpenState();
        System.out.println("Ticket created: '" + title + "' [Status: OPEN]");
    }

    public void setState(TicketState state){
        this.currentState = state;
    }

    public void assign() {
        currentState.assignToDeveloper(this);
    }

    public void resolve() {
        currentState.resolveTicket(this);
    }

    public void close() {
        currentState.closeTicket(this);
    }
}
