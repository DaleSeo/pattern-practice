package seo.dale.practice.pattern.observer;

import org.junit.Before;
import org.junit.Test;

public class HealthCheckerTest {

	private HealthChecker healthChecker;

	@Before
	public void setUp() {
		healthChecker = new HealthChecker();
		healthChecker.addObserver(new EmailSender());
		healthChecker.addObserver(new SmsSender());
		healthChecker.addObserver(new SlackSender());
	}

	@Test
	public void testNotifyIfAbnormal() throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			Thread.sleep(1000);
			healthChecker.notifyIfAbnormal();
		}
	}

}