package seo.dale.practice.pattern.proxy;

public class RealImage implements Image {

	private String path;

	public RealImage(String path) {
		this.path = path;
		System.out.println("The image at " + path + " has loaded on memory.");
	}

	@Override
	public void draw() {
		System.out.println("==============");
		System.out.println("=" + path + "=");
		System.out.println("==============");
	}

}
