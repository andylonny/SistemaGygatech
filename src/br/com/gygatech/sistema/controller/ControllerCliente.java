package br.com.gygatech.sistema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gygatech.sistema.dao.ClienteDAO;
import br.com.gygatech.sistema.model.Cliente;

@Transactional
@Controller
public class ControllerCliente {

	@Autowired
	ClienteDAO clienteDao;
	
	@RequestMapping("/cadastrarClienteView")
	public String cadastrarClienteView(HttpSession session){
		if(session.getAttribute("usuarioLogado") != null){
			return "cliente/cadastrarCliente";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/consultarClienteView")
	public String consultarClienteView(HttpSession session){
		if(session.getAttribute("usuarioLogado") != null){
			return "cliente/consultarCliente";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/alterarClienteView")
	public String alterarClienteView(int codigo, HttpSession session, 
			HttpServletRequest req, HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			Cliente cliente = clienteDao.consulta(codigo);
			req.setAttribute("cliente", cliente);
			return "cliente/alterarCliente";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/gravarCliente")
	public String gravarCliente(Cliente cliente, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			clienteDao.adiciona(cliente);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/alterarCliente")
	public String alterarCliente(Cliente clienteAlterado, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Cliente cliente = clienteDao.consulta(clienteAlterado.getCodigoCliente());
			cliente.setNome(clienteAlterado.getNome());
			cliente.setLogradouro(clienteAlterado.getLogradouro());
			cliente.setNumero(clienteAlterado.getNumero());
			cliente.setComplemento(clienteAlterado.getComplemento());
			cliente.setBairro(clienteAlterado.getBairro());
			cliente.setCidade(clienteAlterado.getCidade());
			cliente.setCep(clienteAlterado.getCep());
			cliente.setTel1(clienteAlterado.getTel1());
			cliente.setTel2(clienteAlterado.getTel2());
			cliente.setEmail(clienteAlterado.getEmail());
			cliente.setInformacoes(clienteAlterado.getInformacoes());
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/excluirCliente")
	public String excluirCliente(int codigo, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			Cliente cliente = clienteDao.consulta(codigo);
			clienteDao.apaga(cliente);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarTodosClientes")
	public String consultarTodosClientes(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Cliente> lista = clienteDao.consultaTodos();
			req.setAttribute("clientes", lista);
			return "cliente/resultadoCliente";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarNomeCliente")
	public String consultarNomeCliente(String nome, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Cliente> lista = clienteDao.consultaPorNome(nome);
			req.setAttribute("clientes", lista);
			return "cliente/resultadoCliente";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/mapa")
	public String mapa(int codigo, HttpSession session, HttpServletRequest req, 
			HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			Cliente cliente = clienteDao.consulta(codigo);
			String destino = cliente.getLogradouro()+", "+cliente.getNumero()+" - "+
					cliente.getCidade()+", "+cliente.getUf();
			req.setAttribute("destino", destino);
			req.setAttribute("cliente", cliente);
			return "mapas";
		}
		return "redirect:index.html";
	}
	
}
