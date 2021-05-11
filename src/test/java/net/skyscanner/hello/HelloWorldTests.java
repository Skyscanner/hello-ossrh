/**
 * Copyright 2021 Skyscanner Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.skyscanner.hello;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class HelloWorldTests {

	private ByteArrayOutputStream baos = new ByteArrayOutputStream();
	private PrintStream ps = new PrintStream(baos);

	@Before
	public void setup() {
		System.setOut(ps);
	}

	@Test
	public void shouldPrintTimeToConsole() {
		HelloWorld.main(new String[] { });

		assertThat(output(), containsString("The current local time is"));
	}

	@Test
	public void shouldPrintHelloWorldToConsole() {
		HelloWorld.main(new String[] { });

		assertThat(output(), containsString("Hello OSSRH!"));
	}

	private String output() {
		return new String(baos.toByteArray(), StandardCharsets.UTF_8);
	}
}
