package com.lexcorp.Foro_Hub_Challeng.controller;

import com.lexcorp.Foro_Hub_Challeng.domain.dto.DatosRegistroRespuesta;
import com.lexcorp.Foro_Hub_Challeng.domain.respuestas.Respuesta;
import com.lexcorp.Foro_Hub_Challeng.domain.usuario.Usuario;
import com.lexcorp.Foro_Hub_Challeng.repository.RespuestaRepository;
import com.lexcorp.Foro_Hub_Challeng.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    private RespuestaRepository respuestaRepository;

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> responder(@RequestBody @Valid DatosRegistroRespuesta datos,
                                       @AuthenticationPrincipal Usuario usuario) {

        var topico = topicoRepository.findById(datos.topicoId())
                .orElseThrow(() -> new RuntimeException("Tópico no encontrado"));

        var respuesta = new Respuesta();
        respuesta.setMensaje(datos.mensaje());
        respuesta.setTopico(topico);
        respuesta.setAutor(usuario);

        respuestaRepository.save(respuesta);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Respuesta registrada correctamente");
    }
}
