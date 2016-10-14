package seo.dale.practice.pattern.observer;

public class SlackSender implements Observer {

	@Override
	public void onAbnormal(Health health) {
		sendSlack(health);
	}

	private void sendSlack(Health health) {
		System.out.println("Messaging on Slack.");
	}

}
