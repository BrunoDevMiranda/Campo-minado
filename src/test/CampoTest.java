package test;

import br.com.campominado.exception.ExplosaoException;
import br.com.campominado.model.Campo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {


    private Campo campo;

    @BeforeEach
    void iniciarCampo() {
        campo = new Campo(3, 3);
    }

    @Test
        // testando vizinho com 1 de distancia
    void testVizinhoRealDistancia1() {
        Campo vizinho = new Campo(3, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
        // testando vizinho com 2 de distancia
    void testVizinhoRealDistancia2() {
        Campo vizinho = new Campo(2, 2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test
        // testando quem não e vizinho
    void testVizinhoRealDistanciaNot() {
        Campo vizinho = new Campo(5, 3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }


    @Test
    void abrirMinadoMarcado() {
        campo.alternaMarcacao();
        campo.minar();
        assertFalse(campo.abrir());
    }

    @Test
    void abrirNaoMinadoNaoMarcado() {
        assertTrue(campo.abrir());
    }

    @Test
    void abrirNaoMinadoMarcado() {
        campo.alternaMarcacao();
        assertFalse(campo.abrir());
    }


    @Test
    void abrirMinadoNaoMarcado() {
        campo.minar();
        assertThrows(ExplosaoException.class, () -> {
            campo.abrir();
        });

    }

    @Test
    void vizinhaSegura1() {
        Campo vizinho22 = new Campo(2, 2);
        Campo vizinho11 = new Campo(1, 1);
        vizinho22.adicionarVizinho(vizinho11);

        campo.adicionarVizinho(vizinho22);
        campo.abrir();
        assertTrue(vizinho22.isAberto() && vizinho11.isAberto());
    }

    @Test
    void vizinhaSegura2() {
        Campo vizinho22 = new Campo(2, 2);
        Campo vizinho12 = new Campo(2, 2);

        vizinho12.minar();

        Campo vizinho11 = new Campo(1, 1);
        vizinho22.adicionarVizinho(vizinho11);

        campo.adicionarVizinho(vizinho22);
        campo.abrir();
        assertTrue(vizinho22.isAberto() && vizinho12.isFechado());
    }


    @Test
    void isMarcado() {
        assertFalse(campo.isMarcado());
    }

    @Test
    void alternaMarcacao() {
        campo.alternaMarcacao();
        assertTrue(campo.isMarcado());
    }

    @Test
    void alternaMarcacaoDuasChamadas() {
        campo.alternaMarcacao();
        campo.alternaMarcacao();
        assertFalse(campo.isMarcado());
    }
}