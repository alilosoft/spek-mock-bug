package playground

import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals


class MockkSpec : Spek({
  val mock = mockk<Greeter>()

  beforeEachTest {
    every { mock.greet(any()) } answers { "Hello ${args[0]}" }
  }

  afterEachTest {
    clearMocks(mock)
  }

  describe("greet(\"mock\")") {
    val result by memoized { mock.greet("mock") }

    it("should return \"Hello mock\"") {
      assertEquals("Hello mock", result)
    }
  }
})
