package com.proyectoYT.FullSpring;

import com.proyectoYT.FullSpring.models.Libro;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class Rutas {

    private final Logger logger = LoggerFactory.getLogger(Rutas.class);

    @GetMapping("/hola")
    String miPrimeraRuta() {
        return "Hola mundo desde Spring Controller :D";
    }

    @GetMapping("/libro/{id}/editorial/{editorial}")
    String leerLibro(@PathVariable int id, @PathVariable String editorial) {
        return "Leyendo el libro id: " + id + " de la editorial: " + editorial;
    }

    @GetMapping("/libro2/{id}")
    String leerLibro2(@PathVariable int id, @RequestParam String params, @RequestParam String editorial) {
        return "Leyendo el libro id: " + id + ", params: " + params + ", editorial " + editorial;
    }

    @PostMapping("/libro")
    String guardarLibro(@RequestBody Libro libro) {
        logger.debug("nombre {} editorial {}", libro.nombre, libro.editorial);

        return "libro guardado";
    }

    @GetMapping("/saludar")
    @ResponseStatus(value = HttpStatus.MOVED_PERMANENTLY, reason = "Fue movida a la version 2 de la API")
    String miSegundaRuta() {
        return "Aprendiendo Spring";
    }

    @GetMapping("/animales/{lugar}")
    public ResponseEntity<String> getAnimales(@PathVariable String lugar) {
       if (lugar.equals("granja")) {
           return ResponseEntity.status(HttpStatus.OK).body("Caballo, vaca, oveja, gallina");
       } else if (lugar.equals("selva")) {
           return ResponseEntity.status(HttpStatus.OK).body("mono, gorila");
       } else {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("lugar no valido");
       }

    }

    @GetMapping("/calcular/{numero}")
    public int getCalculo(@PathVariable int numero) {
        throw new NullPointerException("La clave del usuario es password123 y no debería leerse en postman");
    }

}
