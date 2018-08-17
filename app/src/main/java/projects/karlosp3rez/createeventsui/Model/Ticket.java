package projects.karlosp3rez.createeventsui.Model;

public class Ticket {
    private String categoriaTicket;
    private String precioTicket;
    private String cantidadAsientos;

    public Ticket(String categoriaTicket, String precioTicket, String cantidadAsientos) {
        this.categoriaTicket = categoriaTicket;
        this.precioTicket = precioTicket;
        this.cantidadAsientos = cantidadAsientos;
    }

    public String getCategoriaTicket() {
        return categoriaTicket;
    }

    public void setCategoriaTicket(String categoriaTicket) {
        this.categoriaTicket = categoriaTicket;
    }

    public String getPrecioTicket() {
        return precioTicket;
    }

    public void setPrecioTicket(String precioTicket) {
        this.precioTicket = precioTicket;
    }

    public String getCantidadAsientos() {
        return cantidadAsientos;
    }

    public void setCantidadAsientos(String cantidadAsientos) {
        this.cantidadAsientos = cantidadAsientos;
    }
}
