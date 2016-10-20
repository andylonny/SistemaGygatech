package br.com.gygatech.sistema.mail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

import br.com.gygatech.sistema.model.Agenda;

public class EmailAgenda {

	public void enviaEmailAgenda(List<Agenda> lista) throws EmailException {
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = hoje.format(formatador);
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e‐mail
		email.addTo("fabssilveira@gygatech.com.br"); //destinatário
		email.setFrom("gygatech@gygatech.com.br"); // remetente
		email.setSubject("Sistema Gygatech: Agenda de "+data); // assunto do e‐mail
		
		StringBuilder sb = new StringBuilder();
		sb.append("Atendimentos agendados para hoje:");
		sb.append("\n");
		int i = 1;
		for(Agenda a: lista){
			sb.append(i+"º: "+a.getHorario()+" - "+a.getCliente().getNome()+" - "+a.getInformacoes());
			sb.append("\n");
			i++;
		}
		sb.append("Gerado automaticamente pelo Sistema de Chamados Gygatech. Por favor não responda este email.");
		
		email.setMsg(sb.toString()); //conteudo do e‐mail
		email.setAuthenticator(new DefaultAuthenticator("gygatech@gygatech.com.br", "k6a2q6"));
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);
		email.send();
	}

	public void enviaEmailVazio() throws EmailException {
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String data = hoje.format(formatador);
		
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e‐mail
		email.addTo("fabssilveira@gygatech.com.br"); //destinatário
		email.setFrom("gygatech@gygatech.com.br"); // remetente
		email.setSubject("Sistema Gygatech: Agenda de "+data); // assunto do e‐mail
		
		StringBuilder sb1 = new StringBuilder();
		sb1.append("Atendimentos agendados para hoje:");
		sb1.append("\n");
		sb1.append("Não há atendimentos agendados para hoje.");
		sb1.append("\n");
		sb1.append("Gerado automaticamente pelo Sistema de Chamados Gygatech. Por favor não responda este email.");
		
		email.setMsg(sb1.toString()); //conteudo do e‐mail
		email.setAuthenticator(new DefaultAuthenticator("gygatech@gygatech.com.br", "k6a2q6"));
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);
		email.send();
	}
	
}
