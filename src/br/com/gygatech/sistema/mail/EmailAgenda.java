package br.com.gygatech.sistema.mail;

import java.time.LocalDate;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class EmailAgenda {

	public void enviaEmailSimples() throws EmailException {
		LocalDate hoje = LocalDate.now();
		SimpleEmail email = new SimpleEmail();
		email.setHostName("smtp.gmail.com"); // o servidor SMTP para envio do e‐mail
		email.addTo("fabssilveira@gygatech.com.br"); //destinatário
		email.setFrom("gygatech@gygatech.com.br"); // remetente
		email.setSubject("Contato: "+hoje); // assunto do e‐mail
		email.setMsg(""); //conteudo do e‐mail
		email.setAuthenticator(new DefaultAuthenticator("gygatech@gygatech.com.br", "k6a2q6"));
		email.setSmtpPort(587);
		email.setStartTLSEnabled(true);
		email.send();
		}

}
