package playground

import org.mockito.ArgumentMatchers.anyString
import org.mockito.Mockito
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe
import kotlin.test.assertEquals


class MockitoSpec : Spek({
  val mock by memoized { Mockito.mock(Greeter::class.java) }

  beforeEachTest {
    Mockito.`when`(mock.greet(anyString())).thenAnswer { "Hello ${it.arguments[0]}" }
  }

  describe("greet(\"mock\")") {
    val result by memoized { mock.greet("mock") }

    it("should return \"Hello mock\"") {
      assertEquals("Hello mock", result)
    }
  }
})
