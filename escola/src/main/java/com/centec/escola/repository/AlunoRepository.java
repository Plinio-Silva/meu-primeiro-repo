package com.centec.escola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.centec.escola.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
