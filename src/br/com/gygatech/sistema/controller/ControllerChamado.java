package br.com.gygatech.sistema.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gygatech.sistema.dao.ChamadoDAO;
import br.com.gygatech.sistema.dao.ClienteDAO;
import br.com.gygatech.sistema.dao.PecaDAO;
import br.com.gygatech.sistema.dao.ServicoDAO;
import br.com.gygatech.sistema.model.AuxChamado;
import br.com.gygatech.sistema.model.Chamado;
import br.com.gygatech.sistema.model.Cliente;
import br.com.gygatech.sistema.model.Peca;
import br.com.gygatech.sistema.model.Servico;

@Transactional
@Controller
public class ControllerChamado {
	
	private float total, valorServico, valorPeca;
	int size;

	@Autowired
	ChamadoDAO chamadoDao;
	
	@Autowired
	ClienteDAO clienteDao;
	
	@Autowired
	ServicoDAO servicoDao;
	
	@Autowired
	PecaDAO pecaDao;
	
	@RequestMapping("/novoChamadoView")
	public String novoChamadoView(HttpSession session, HttpServletRequest req, 
			HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			List<Cliente> clientes = clienteDao.consultaTodos();
			List<Servico> servicos = servicoDao.consultaTodos();
			List<Peca> pecas = pecaDao.consultaTodos();
			req.setAttribute("clientes", clientes);
			req.setAttribute("servicos", servicos);
			req.setAttribute("pecas", pecas);
			return "chamado/novoChamado";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/consultarChamadoView")
	public String consultarChamadoView(HttpSession session, HttpServletRequest req, 
			HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			List<Cliente> clientes = clienteDao.consultaTodos();
			req.setAttribute("clientes", clientes);
			return "chamado/consultarChamado";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/alterarChamadoView")
	public String alterarChamadoView(int codigo, HttpSession session, 
			HttpServletRequest req, HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			Chamado chamado = chamadoDao.consulta(codigo);
			Calendar c = Calendar.getInstance();
			c = chamado.getData();
			String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
			req.setAttribute("chamado", chamado);
			req.setAttribute("data", data);
			return "chamado/alterarChamado";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/gravarChamado")
	public String gravarChamado(String codigoCliente, String codigoServico, String codigoPeca, Chamado chamado,
			String valorData, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Chamado novoChamado = new Chamado();

			Cliente cliente = clienteDao.consulta(Integer.parseInt(codigoCliente));
			novoChamado.setCliente(cliente);

			List<Servico> listaServ = new ArrayList<Servico>();
			if (codigoServico != null) {
				String[] codServicos = codigoServico.split(",");
				size = codServicos.length;
				for (int i = 0; i < size; i++) {
					listaServ.add(servicoDao.consulta(Integer.parseInt(codServicos[i])));
				}
				novoChamado.setServicos(listaServ);
			}

			List<Peca> listaPeca = new ArrayList<Peca>();
			if (codigoPeca != null) {
				String[] codPecas = codigoPeca.split(",");
				size = codPecas.length;
				for (int i = 0; i < size; i++) {
					listaPeca.add(pecaDao.consulta(Integer.parseInt(codPecas[i])));
				}
				novoChamado.setPecas(listaPeca);
			}

			novoChamado.setValorAtendimento(calcularValorChamado(listaServ, listaPeca));
			
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(valorData));
				novoChamado.setData(cal);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			novoChamado.setHorario(chamado.getHorario());
			novoChamado.setStatus(chamado.getStatus());
			novoChamado.setInformacoes(chamado.getInformacoes());

			chamadoDao.adiciona(novoChamado);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarChamadoNome")
	public String consultarChamadoNome(String codigoCliente, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Cliente cliente = clienteDao.consulta(Integer.parseInt(codigoCliente));
			List<Chamado> chamados = chamadoDao.consultaPorCliente(cliente);
			List<AuxChamado> auxChamados = new ArrayList<AuxChamado>();
			for(Chamado ch :chamados){
				AuxChamado aux = new AuxChamado();
				Calendar c = Calendar.getInstance();
				c = ch.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(ch.getCodigo());
				aux.setCliente(ch.getCliente());
				aux.setServicos(ch.getServicos());
				aux.setPecas(ch.getPecas());
				aux.setData(data);
				aux.setHorario(ch.getHorario());
				aux.setStatus(ch.getStatus());
				aux.setInformacoes(ch.getInformacoes());
				aux.setValorAtendimento(ch.getValorAtendimento());
				auxChamados.add(aux);
			}
			req.setAttribute("chamados", auxChamados);
			return "chamado/resultadoChamado";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarChamadoData")
	public String consultarChamadoData(String valorData, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Calendar cal = Calendar.getInstance();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cal.setTime(sdf.parse(valorData));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<Chamado> chamados = chamadoDao.consultaPorData(cal);
			List<AuxChamado> auxChamados = new ArrayList<AuxChamado>();
			for(Chamado ch :chamados){
				AuxChamado aux = new AuxChamado();
				Calendar c = Calendar.getInstance();
				c = ch.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(ch.getCodigo());
				aux.setCliente(ch.getCliente());
				aux.setServicos(ch.getServicos());
				aux.setPecas(ch.getPecas());
				aux.setData(data);
				aux.setHorario(ch.getHorario());
				aux.setStatus(ch.getStatus());
				aux.setInformacoes(ch.getInformacoes());
				aux.setValorAtendimento(ch.getValorAtendimento());
				auxChamados.add(aux);
			}
			req.setAttribute("chamados", auxChamados);
			return "chamado/resultadoChamado";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarChamadoStatus")
	public String consultarChamadoStatus(String status, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Chamado> chamados = chamadoDao.consultaPorStatus(status);
			List<AuxChamado> auxChamados = new ArrayList<AuxChamado>();
			for(Chamado ch :chamados){
				AuxChamado aux = new AuxChamado();
				Calendar c = Calendar.getInstance();
				c = ch.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(ch.getCodigo());
				aux.setCliente(ch.getCliente());
				aux.setServicos(ch.getServicos());
				aux.setPecas(ch.getPecas());
				aux.setData(data);
				aux.setHorario(ch.getHorario());
				aux.setStatus(ch.getStatus());
				aux.setInformacoes(ch.getInformacoes());
				aux.setValorAtendimento(ch.getValorAtendimento());
				auxChamados.add(aux);
			}
			req.setAttribute("chamados", auxChamados);
			return "chamado/resultadoChamado";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarChamadoTotal")
	public String consultarChamadoTotal(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Chamado> chamados = chamadoDao.consultaTodos();
			List<AuxChamado> auxChamados = new ArrayList<AuxChamado>();
			for(Chamado ch :chamados){
				AuxChamado aux = new AuxChamado();
				Calendar c = Calendar.getInstance();
				c = ch.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(ch.getCodigo());
				aux.setCliente(ch.getCliente());
				aux.setServicos(ch.getServicos());
				aux.setPecas(ch.getPecas());
				aux.setData(data);
				aux.setHorario(ch.getHorario());
				aux.setStatus(ch.getStatus());
				aux.setInformacoes(ch.getInformacoes());
				aux.setValorAtendimento(ch.getValorAtendimento());
				auxChamados.add(aux);
			}
			req.setAttribute("chamados", auxChamados);
			return "chamado/resultadoChamado";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/detalharChamado")
	public String detalharChamado(String codigo, HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Chamado chamado = chamadoDao.consulta(Integer.parseInt(codigo));
			List<Servico> servicos = chamado.getServicos();
			List<Peca> pecas = chamado.getPecas();
			req.setAttribute("servicos", servicos);
			req.setAttribute("pecas", pecas);
			return "chamado/detalhes";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/alterarChamado")
	public String alterarChamado(Chamado chamadoAlterado, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Chamado chamado = chamadoDao.consulta(chamadoAlterado.getCodigo());
			chamado.setStatus(chamadoAlterado.getStatus());
			chamado.setInformacoes(chamadoAlterado.getInformacoes());
			return "chamado/consultarChamado";
		}
		return "redirect:index.html";
	}

	private float calcularValorChamado(List<Servico> servicos, List<Peca> pecas) {

		valorServico = 0;
		valorPeca = 0;
		total = 0;

		for (Servico servico : servicos) {
			valorServico = valorServico + servico.getValor();
		}
		for (Peca peca : pecas) {
			valorPeca = valorPeca + peca.getValor();
		}
		total = valorServico + valorPeca;
		return total;
	}
	
	@RequestMapping("/adicionaServico")
	public void adicionaServico(int id, HttpSession session, HttpServletRequest req, 
			HttpServletResponse res){
		System.out.println(id);
	}
	
}
