package seo.dale.practice.pattern.observer;

public class HealthChecker extends Subject {

	public void notifyIfAbnormal() {
		Health health = checkHealth();
		if (!health.isNormal()) {
			notifyObservers(health);
		}
	}

	private Health checkHealth() {
		System.out.print("> Checking health.");
		Health health = new Health(Math.random() < 0.5);
		if (health.isNormal()) {
			System.out.println(" -> Okay!");
		} else {
			System.out.println(" -> Error!");
		}
		return health;
	}

}
