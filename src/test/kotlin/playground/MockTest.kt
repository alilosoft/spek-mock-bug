package playground

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MockTest {

  private val mock = mockk<Greeter>()

  @BeforeEach
  fun setup() {
    every { mock.greet(any()) } answers { "Hello ${args[0]}" }
  }

  @AfterEach
  fun clear() {
    clearMocks(mock)
  }

  @Test
  fun testGreetMe() {
    assertEquals("Hello me", mock.greet("me"))
  }
}
