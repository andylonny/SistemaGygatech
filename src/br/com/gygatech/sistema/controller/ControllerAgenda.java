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

import br.com.gygatech.sistema.dao.AgendaDAO;
import br.com.gygatech.sistema.dao.ClienteDAO;
import br.com.gygatech.sistema.model.Agenda;
import br.com.gygatech.sistema.model.AuxAgenda;
import br.com.gygatech.sistema.model.Cliente;

@Transactional
@Controller
public class ControllerAgenda {

	@Autowired
	AgendaDAO agendaDao;
	
	@Autowired
	ClienteDAO clienteDao;
	
	@RequestMapping("/agendarAtendimentoView")
	public String cadastrarAgendaView(HttpSession session, HttpServletRequest req, 
			HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			List<Cliente> clientes = clienteDao.consultaTodos();
			req.setAttribute("clientes", clientes);
			return "agenda/agendarAtendimento";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/consultarAgendaView")
	public String consultarAgendaView(HttpSession session, HttpServletRequest req, 
			HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			List<Cliente> clientes = clienteDao.consultaTodos();
			req.setAttribute("clientes", clientes);
			return "agenda/consultarAgenda";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/alterarAgendaView")
	public String alterarAgendaView(int codigo, HttpSession session, 
			HttpServletRequest req, HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			Agenda agenda = agendaDao.consulta(codigo);
			Calendar c = Calendar.getInstance();
			c = agenda.getData();
			String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
			req.setAttribute("agenda", agenda);
			req.setAttribute("data", data);
			return "agenda/alterarAgenda";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/consultarAgendaCliente")
	public String consultarAgendaCliente(String codigoCliente, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Cliente cliente = clienteDao.consulta(Integer.parseInt(codigoCliente));
			List<Agenda> agenda = agendaDao.consultaPorCliente(cliente);
			List<AuxAgenda> auxAgenda = new ArrayList<AuxAgenda>();
			for(Agenda a: agenda){
				AuxAgenda aux = new AuxAgenda(); 
				Calendar c = Calendar.getInstance();
				c = a.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(a.getCodigo());
				aux.setCliente(a.getCliente());
				aux.setData(data);
				aux.setHorario(a.getHorario());
				aux.setStatus(a.getStatus());
				aux.setInformacoes(a.getInformacoes());
				auxAgenda.add(aux);
			}
			req.setAttribute("agenda", auxAgenda);
			return "agenda/resultadoAgenda";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarAgendaData")
	public String consultarAgendaData(String valorData, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Calendar cal = Calendar.getInstance();
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				cal.setTime(sdf.parse(valorData));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			List<Agenda> agenda = agendaDao.consultaPorData(cal);
			List<AuxAgenda> auxAgenda = new ArrayList<AuxAgenda>();
			for(Agenda a: agenda){
				AuxAgenda aux = new AuxAgenda(); 
				Calendar c = Calendar.getInstance();
				c = a.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(a.getCodigo());
				aux.setCliente(a.getCliente());
				aux.setData(data);
				aux.setHorario(a.getHorario());
				aux.setStatus(a.getStatus());
				aux.setInformacoes(a.getInformacoes());
				auxAgenda.add(aux);
			}
			req.setAttribute("agenda", auxAgenda);
			return "agenda/resultadoAgenda";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarAgendaTotal")
	public String consultarAgendaTotal(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Agenda> agenda = agendaDao.consultaTodos();
			List<AuxAgenda> auxAgenda = new ArrayList<AuxAgenda>();
			for(Agenda a: agenda){
				AuxAgenda aux = new AuxAgenda(); 
				Calendar c = Calendar.getInstance();
				c = a.getData();
				String data = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
				aux.setCodigo(a.getCodigo());
				aux.setCliente(a.getCliente());
				aux.setData(data);
				aux.setHorario(a.getHorario());
				aux.setStatus(a.getStatus());
				aux.setInformacoes(a.getInformacoes());
				auxAgenda.add(aux);
			}
			req.setAttribute("agenda", auxAgenda);
			return "agenda/resultadoAgenda";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/gravarAgenda")
	public String gravarAgenda(String codigoCliente, String valorData, Agenda agenda, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			Agenda novaAgenda = new Agenda();

			Cliente cliente = clienteDao.consulta(Integer.parseInt(codigoCliente));
			novaAgenda.setCliente(cliente);
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(sdf.parse(valorData));
				novaAgenda.setData(cal);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			novaAgenda.setHorario(agenda.getHorario());
			novaAgenda.setInformacoes(agenda.getInformacoes());
			novaAgenda.setStatus("Em Aberto");

			agendaDao.adiciona(novaAgenda);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/alterarAgenda")
	public String alterarAgenda(Agenda agendaAlterada, HttpSession session, HttpServletRequest req,
			HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			Agenda agenda = agendaDao.consulta(agendaAlterada.getCodigo());
			agenda.setStatus(agendaAlterada.getStatus());
			agenda.setInformacoes(agendaAlterada.getInformacoes());
			return "agenda/consultarAgenda";
		}
		return "redirect:index.html";
	}
	
}
