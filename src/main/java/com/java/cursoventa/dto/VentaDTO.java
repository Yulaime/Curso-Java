// VentaDTO.java
package com.java.cursoventa.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class VentaDTO {
    private Long id;
    private LocalDateTime fecha;
    private String clienteNombre; // O cualquier otro campo relevante del cliente
    private BigDecimal total;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getClienteNombre() {
        return clienteNombre;
    }

    public void setClienteNombre(String clienteNombre) {
        this.clienteNombre = clienteNombre;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}

