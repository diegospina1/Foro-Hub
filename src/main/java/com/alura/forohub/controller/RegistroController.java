package com.alura.forohub.controller;


import com.alura.forohub.domain.usuario.DatosRegistroUsuario;
import com.alura.forohub.domain.usuario.DatosRespuestaUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/registrar")
public class RegistroController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuestaUsuario> crearUsuario(@RequestBody @Valid DatosRegistroUsuario datosRegistroUsuario,
                                                              UriComponentsBuilder uriComponentsBuilder){

        String password = datosRegistroUsuario.clave();
        String claveEncriptada = new BCryptPasswordEncoder().encode(password);
        DatosRegistroUsuario datosConClaveEncriptada = new DatosRegistroUsuario(datosRegistroUsuario.nombre(), datosRegistroUsuario.correo(),
                claveEncriptada);

        Usuario usuario = usuarioRepository.save(new Usuario(datosConClaveEncriptada));
        DatosRespuestaUsuario datosRespuestaUsuario = new DatosRespuestaUsuario(usuario.getId(), usuario.getNombre(), usuario.getEmail());
        URI url = uriComponentsBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaUsuario);
    }
}
