package seo.dale.practice.pattern.proxy;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ListUITest {

	private ListUI ui;
	private List<Image> images;

	@Before
	public void setUp() {
		images = new ArrayList<>(100);
		for (int i = 0; i < 100; i++) {
			String path = "img/pic" + i + ".jpg";
			if (i < 5) {
				images.add(new RealImage(path)); // 5 pictures to load eagerly
			} else {
				images.add(new VirtualImage(path)); // 95 pictures to load lazily
			}
		}
		ui = new ListUI(images);
	}

	@Test
	public void testFivePictures() {
		ui.onScroll(0, 4);
		for (int i = 5; i < 100; i++) {
			VirtualImage image = (VirtualImage) images.get(i);
			assertFalse(image.isLoaded());
		}
	}

	@Test
	public void testTenPictures() {
		ui.onScroll(0, 9);
		for (int i = 5; i < 100; i++) {
			VirtualImage image = (VirtualImage) images.get(i);
			if (i < 10) {
				assertTrue(image.isLoaded());
			} else {
				assertFalse(image.isLoaded());
			}
		}
	}

}