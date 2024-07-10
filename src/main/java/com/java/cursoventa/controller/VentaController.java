package com.java.cursoventa.controller;

import com.java.cursoventa.dto.DetalleVentaDTO;
import com.java.cursoventa.dto.ProductoDTO;
import com.java.cursoventa.dto.VentaResponseDTO;
import com.java.cursoventa.entity.DetalleVenta;
import com.java.cursoventa.entity.Producto;
import com.java.cursoventa.entity.Venta;
import com.java.cursoventa.request.VentaRequest;
import com.java.cursoventa.service.ProductoService;
import com.java.cursoventa.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ventas")
public class VentaController {
    @Autowired
    private VentaService ventaService;

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public ResponseEntity<VentaResponseDTO> save(@RequestBody VentaRequest ventaRequest) {
        Venta venta = ventaRequest.getVenta();

        List<DetalleVenta> detalles = ventaRequest.getDetalles();
        for (DetalleVenta detalle : detalles) {
            Producto producto = productoService.findById(detalle.getProducto().getId());
            detalle.setProducto(producto);
            detalle.setVenta(venta);
        }
        venta.setDetalleVentas(detalles);

        Venta savedVenta = ventaService.save(venta);
        VentaResponseDTO responseDTO = convertToDTO(savedVenta);
        return ResponseEntity.ok(responseDTO);
    }

    private VentaResponseDTO convertToDTO(Venta venta) {
        VentaResponseDTO dto = new VentaResponseDTO();
        dto.setId(venta.getId());
        dto.setFecha(venta.getFecha());
        dto.setTotal(venta.getTotal());
        List<DetalleVentaDTO> detalleDTOs = venta.getDetalleVentas().stream().map(this::convertDetalleToDTO).collect(Collectors.toList());
        dto.setDetalles(detalleDTOs);
        return dto;
    }

    private DetalleVentaDTO convertDetalleToDTO(DetalleVenta detalle) {
        DetalleVentaDTO dto = new DetalleVentaDTO();
        dto.setId(detalle.getId());
        ProductoDTO productoDTO = new ProductoDTO();
        productoDTO.setId(detalle.getProducto().getId());
        productoDTO.setNombre(detalle.getProducto().getNombre());
        dto.setProducto(productoDTO);
        dto.setCantidad(detalle.getCantidad());
        dto.setPrecio(detalle.getPrecio());
        dto.setSubtotal(detalle.getSubtotal());
        return dto;
    }
}
