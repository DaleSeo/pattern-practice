package seo.dale.practice.pattern.observer;

public class EmailSender implements Observer {

	@Override
	public void onAbnormal(Health health) {
		sendEmail(health);
	}

	private void sendEmail(Health health) {
		System.out.println("Writing an email.");
	}

}
