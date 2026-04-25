package com.hospital_mv_cl.hospital_m_cl.controller;
import com.hospital_mv_cl.hospital_m_cl.model.Paciente;
import com.hospital_mv_cl.hospital_m_cl.sevice.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {
        System.out.println("este funcions");
        List<Paciente> paciente = pacienteService.findAll();
        if (paciente.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(paciente);
    }

    @PostMapping
    public String guardar(@RequestBody Paciente paciente){
        return "Hola";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        try {
            Paciente paciente = pacienteService.findById(id);
            return ResponseEntity.ok(paciente);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizar(@PathVariable Integer id, @RequestBody Paciente paciente){
        try {
            Paciente pac = pacienteService.findById(id);
            pac.setId(id);
            pac.setRun(paciente.getRun());
            pac.setNombres(paciente.getNombres());
            pac.setApellidos(paciente.getApellidos());
            pac.setFechaNacimiento(paciente.getFechaNacimiento());
            pac.setCorreo(paciente.getCorreo());

            pacienteService.save(pac);
            return ResponseEntity.ok(paciente);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id){
        try {
            pacienteService.delete(id);
            return ResponseEntity.noContent().build();
        }catch (Exception e){
        return ResponseEntity.notFound().build();
        }
    }


}
