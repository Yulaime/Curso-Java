package com.java.cursoventa.controller;

import com.java.cursoventa.entity.DetalleVenta;
import com.java.cursoventa.service.DetalleVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/detalle-ventas")
public class DetalleVentaController {
    @Autowired
    private DetalleVentaService detalleVentaService;

    @GetMapping
    public List<DetalleVenta> findAll() {
        return detalleVentaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleVenta> findById(@PathVariable Long id) {
        DetalleVenta detalleVenta = detalleVentaService.findById(id);
        if (detalleVenta != null) {
            return ResponseEntity.ok(detalleVenta);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public DetalleVenta save(@RequestBody DetalleVenta detalleVenta) {
        return detalleVentaService.save(detalleVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        detalleVentaService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
