import com.example.Searcher;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SearcherTestCase {

    private Searcher searcher;
    private List<String> datos;

    @BeforeEach
    void setUp() {
        searcher = new Searcher();
        datos = Arrays.asList("hola", "adios", "mundo", "madre", "hermano");
    }

    @Test
    @DisplayName("searchWord: La palabra existe en la lista")
    void searchWord_palabraExiste() {
        assertTrue(searcher.searchWord("madre", datos));
    }

    @Test
    @DisplayName("searchWord: La palabra no existe en la lista")
    void searchWord_palabraNoExiste() {
        assertFalse(searcher.searchWord("amigo", datos));
    }

    @Test
    @DisplayName("getWordByIndex: Índice válido devuelve la palabra correcta")
    void getWordByIndex_indiceValido() {
        assertEquals("casa", searcher.getWordByIndex(datos, 0));
        assertEquals("gato", searcher.getWordByIndex(datos, 4));
    }

    @Test
    @DisplayName("getWordByIndex: Índice inválido (negativo o grande) devuelve null")
    void getWordByIndex_indiceInvalido() {
        assertNull(searcher.getWordByIndex(datos, -1));
        assertNull(searcher.getWordByIndex(datos, 10));
    }
    @Test
    @DisplayName("searchByPrefix: Devuelve las palabras que empiezan con el prefijo")
    void searchByPrefix_devuelveCoincidencias() {
        List<String> resultado = searcher.searchByPrefix("cas", datos);
        assertIterableEquals(Arrays.asList("casa", "casita", "casco"), resultado);
    }

    @Test
    @DisplayName("searchByPrefix: No incluye palabras que no empiezan con el prefijo")
    void searchByPrefix_excluyeNoCoincidencias() {
        List<String> resultado = searcher.searchByPrefix("cas", datos);
        assertFalse(resultado.contains("perro"));
        assertFalse(resultado.contains("gato"));
    }

    @Test
    @DisplayName("filterByKeyword: Devuelve todos los elementos que contienen la palabra clave")
    void filterByKeyword_devuelveCoincidencias() {
        List<String> resultado = searcher.filterByKeyword("as", datos);
        // 'as' aparece en casa, casita y casco
        assertIterableEquals(Arrays.asList("casa", "casita", "casco"), resultado);
    }

    @Test
    @DisplayName("filterByKeyword: Si no existe la palabra clave, devuelve lista vacía")
    void filterByKeyword_sinCoincidencias() {
        List<String> resultado = searcher.filterByKeyword("zzz", datos);
        assertTrue(resultado.isEmpty());
    }


    @Test
    @DisplayName("searchExactPhrase: True cuando la frase está en la lista (al inicio)")
    void searchExactPhrase_enPrimerElemento() {
        assertTrue(searcher.searchExactPhrase("casa", datos));
    }

    @Test
    @DisplayName("searchExactPhrase: True cuando la frase está en la lista (no al inicio) -> Falla con la implementación actual")
    void searchExactPhrase_enElementoNoInicial() {
        assertTrue(searcher.searchExactPhrase("perro", datos));
    }

    @Test
    @DisplayName("searchExactPhrase: False cuando la frase no está en la lista")
    void searchExactPhrase_noExiste() {
        assertFalse(searcher.searchExactPhrase("pez", datos));
    }
}

