package mg.giz.service.metier;

public interface SendingMailService {
	boolean sendMail(String subject, String body);
}
