package com.java.cursoventa.service;

import com.java.cursoventa.entity.Cliente;
import com.java.cursoventa.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente update(Long id, Cliente clienteDetails) {
        Cliente cliente = clienteRepository.findById(id).orElse(null);
        if (cliente != null) {
            cliente.setNombre(clienteDetails.getNombre());
            cliente.setApellido(clienteDetails.getApellido());
            cliente.setEmail(clienteDetails.getEmail());
            cliente.setTelefono(clienteDetails.getTelefono());
            cliente.setDireccion(clienteDetails.getDireccion());
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }
}
