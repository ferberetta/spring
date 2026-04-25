package com.hospital_mv_cl.hospital_m_cl.repository;
import com.hospital_mv_cl.hospital_m_cl.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {

    @Query("SELECT p FROM Paciente p WHERE p.apellidos = :apellidos")
    List<Paciente> buscarPorApellido(@Param("apellido") String apellido);

    @Query(value = "SELECT * FROM paciente WHERE correo = :correo", nativeQuery = true)
    List<Paciente> buscarPorCorreo(@Param("correo") String correo);


}
