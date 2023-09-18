package br.com.rhssolutions.projetoTarefas.service;

import br.com.rhssolutions.projetoTarefas.entity.Todo;
import br.com.rhssolutions.projetoTarefas.repository.TodoRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) { // Constructor injection
        this.todoRepository = todoRepository;
    }

    public List<Todo> create(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> update(Todo todo) {
        todoRepository.save(todo);
        return list();
    }

    public List<Todo> delete(Long id) {
        todoRepository.deleteById(id);
        return list();
    }

    public List<Todo> list() {
        Sort sort = Sort.by("prioridade").descending().and(
                Sort.by("nome").ascending().and(
                        Sort.by("pendente").ascending()
                )
        );
        return todoRepository.findAll(sort);
    }


}
