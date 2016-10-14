package seo.dale.practice.pattern.observer;

public class SmsSender implements Observer {

	@Override
	public void onAbnormal(Health health) {
		sendSms(health);
	}

	private void sendSms(Health health) {
		System.out.println("Sending a SMS.");
	}

}
