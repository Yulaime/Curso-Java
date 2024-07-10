package com.java.cursoventa.request;

import com.java.cursoventa.entity.Venta;
import com.java.cursoventa.entity.DetalleVenta;
import java.util.List;

public class VentaRequest {
    private Venta venta;
    private List<DetalleVenta> detalles;

    // Getters y Setters
    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }
}
