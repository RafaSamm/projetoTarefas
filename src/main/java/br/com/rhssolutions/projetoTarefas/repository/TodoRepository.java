package br.com.rhssolutions.projetoTarefas.repository;

import br.com.rhssolutions.projetoTarefas.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
}
