package br.com.rhssolutions.projetoTarefas;

import br.com.rhssolutions.projetoTarefas.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ProjetoTarefasApplicationTests {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void testCreateTodoSuccess() {
        var todo = new Todo("Tarefa 1", "descricao da tarefa 1", false, false, 1);
        webTestClient.post()
                .uri("/todos")
                .bodyValue(todo)
                .exchange().
                expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].nome").isEqualTo(todo.getNome())
                .jsonPath("$[0].descricao").isEqualTo(todo.getDescricao())
                .jsonPath("$[0].concluida").isEqualTo(todo.getConcluida())
                .jsonPath("$[0].pendente").isEqualTo(todo.getPendente())
                .jsonPath("$[0].prioridade").isEqualTo(todo.getPrioridade());
    }

    @Test
    void testCreateTodoFail() {
        var todo = new Todo("Tarefa 1", "descricao da tarefa 1", false, false, 1);
        webTestClient.post()
                .uri("/todos")
                .bodyValue(new Todo("", "", false, false, 1))
                .exchange()
                .expectStatus().isBadRequest();
    }
}
