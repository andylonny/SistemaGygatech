package br.com.gygatech.sistema.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gygatech.sistema.dao.ServicoDAO;
import br.com.gygatech.sistema.model.Servico;

@Transactional
@Controller
public class ControllerServico {

	@Autowired
	ServicoDAO servicoDao;
	
	@RequestMapping("/cadastrarServicoView")
	public String cadastrarServicoView(HttpSession session){
		if(session.getAttribute("usuarioLogado") != null){
			return "servico/cadastrarServico";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/alterarServicoView")
	public String alterarServicoView(int codigo, HttpSession session, 
			HttpServletRequest req, HttpServletResponse res){
		if(session.getAttribute("usuarioLogado") != null){
			Servico servico = servicoDao.consulta(codigo);
			req.setAttribute("servico", servico);
			return "servico/alterarServico";
		}
		return "redirect:index.html";
	}
	
	@RequestMapping("/gravarServico")
	public String gravarServico(Servico servico, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			servicoDao.adiciona(servico);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/excluirServico")
	public String excluirServico(int codigo, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			Servico servico = servicoDao.consulta(codigo);
			servicoDao.apaga(servico);
			return "principal";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/consultarServicos")
	public String consultarServicos(HttpSession session, HttpServletRequest req, HttpServletResponse res) {
		if (session.getAttribute("usuarioLogado") != null) {
			List<Servico> lista = servicoDao.consultaTodos();
			req.setAttribute("servicos", lista);
			return "servico/resultadoServico";
		}
		return "redirect:index.html";
	}

	@RequestMapping("/alterarServico")
	public String alterarServico(Servico servicoAlterado, HttpSession session) {
		if (session.getAttribute("usuarioLogado") != null) {
			Servico servico = servicoDao.consulta(servicoAlterado.getCodigo());
			servico.setDescricao(servicoAlterado.getDescricao());
			servico.setValor(servicoAlterado.getValor());
			return "principal";
		}
		return "redirect:index.html";
	}
	
}
