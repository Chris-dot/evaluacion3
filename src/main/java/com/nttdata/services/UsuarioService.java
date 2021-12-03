package com.nttdata.services;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nttdata.models.Role;
import com.nttdata.models.Usuario;
import com.nttdata.repositories.RoleRepository;
import com.nttdata.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	RoleService roleService;
	
	@Autowired
	BCryptPasswordEncoder bcpe;
	
	//buscar por email
	public Usuario findByEmail(String email) {
		return usuarioRepository.findByEmail(email);
		
	}
	
	//insertar usuario
	public Usuario persistirUsuarioRol(Usuario usuario) {
		
		usuario.setPassword(bcpe.encode(usuario.getPassword()));
		usuario.setRoles(roleService.findByNombre("ROLE_USER"));
		return usuarioRepository.save(usuario);
	}
	
	
	public Usuario registroUsuario(Usuario usuario) {

		//hashear el password
		String password_hashed= BCrypt.hashpw(usuario.getPassword(), BCrypt.gensalt());
		//sobre escribir la password
		usuario.setPassword(password_hashed);
		
		return usuarioRepository.save(usuario);
	}

	public void insertarUsuario(@Valid Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	public List<Usuario> obtenerListaUsuarios() {
		
		//return  usuarioRepository.findAll();
		return  usuarioRepository.findAllUsuarios();
	}

	public Usuario buscarUsuarioId(Long id) {
		
		return usuarioRepository.findById(id).get();
	}

	public void eliminarUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public void eliminarUsuarioObjeto(Usuario usuario) {
		usuarioRepository.delete(usuario);
		
	}

	public void updateUsuario(@Valid Usuario usuario) {
		if(usuarioRepository.existsById(usuario.getId())){
			usuarioRepository.save(usuario);
		}		
	}
	
	public List<String> findAllUsuariosNombres(){
		return usuarioRepository.findAllUsuariosNombres();
	}
	
	public List<Object[]> findAllUsuariosNombreApellido(){
		return usuarioRepository.findAllUsuariosNombreApellido();
	}
	
	public List<Usuario> obtenerUsuarioWhereId(Long id){
		return usuarioRepository.obtenerUsuarioWhereId(id);
	}

	public boolean loginUsuario(String email, String password) {
		
		Usuario usuario = usuarioRepository.findByEmail(email);
		
		if(usuario == null) {
			return false;
		} else {
			//if(password.equals(usuario.getPassword())) {
			if(BCrypt.checkpw(password, usuario.getPassword())) {
				return true;
			}else {
				return false;
			}
		}	
	}
	
	public Usuario findByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}
	 
}
