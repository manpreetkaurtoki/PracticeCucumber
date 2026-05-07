package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	@Before
	public void init() {
		System.out.println("Init: I am in before method");
	}

	@After
	public void end() {
		System.out.println("End: I am in after method");
	}
}
