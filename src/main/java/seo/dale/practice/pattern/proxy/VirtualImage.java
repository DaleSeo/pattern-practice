package seo.dale.practice.pattern.proxy;

public class VirtualImage implements Image {

	private String path;
	private Image realImage;

	private boolean loaded;

	public VirtualImage(String path) {
		this.path = path;
	}

	@Override
	public void draw() {
		if (!isLoaded()) {
			realImage = new RealImage(path);
		}
		realImage.draw(); // Delegate to the real image
	}

	public boolean isLoaded() {
		return realImage != null;
	}

}
