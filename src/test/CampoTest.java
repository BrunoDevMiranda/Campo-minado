package test;

import br.com.campominado.model.Campo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CampoTest {


    private Campo campo;
    @BeforeEach
    void iniciarCampo(){
        campo = new Campo(3,3);
    }

    @Test // testando vizinho com 1 de distancia
    void testVizinhoRealDistancia1(){
        Campo vizinho = new Campo(3,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test // testando vizinho com 2 de distancia
    void testVizinhoRealDistancia2(){
        Campo vizinho = new Campo(2,2);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertTrue(resultado);
    }

    @Test // testando quem não e vizinho
    void testVizinhoRealDistanciaNot(){
        Campo vizinho = new Campo(5,3);
        boolean resultado = campo.adicionarVizinho(vizinho);
        assertFalse(resultado);
    }
}