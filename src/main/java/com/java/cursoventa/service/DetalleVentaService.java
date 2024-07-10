package com.java.cursoventa.service;

import com.java.cursoventa.entity.DetalleVenta;
import com.java.cursoventa.repository.DetalleVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaService {
    @Autowired
    private DetalleVentaRepository detalleVentaRepository;

    public List<DetalleVenta> findAll() {
        return detalleVentaRepository.findAll();
    }

    public DetalleVenta findById(Long id) {
        return detalleVentaRepository.findById(id).orElse(null);
    }

    public DetalleVenta save(DetalleVenta detalleVenta) {
        return detalleVentaRepository.save(detalleVenta);
    }

    public void deleteById(Long id) {
        detalleVentaRepository.deleteById(id);
    }
}
