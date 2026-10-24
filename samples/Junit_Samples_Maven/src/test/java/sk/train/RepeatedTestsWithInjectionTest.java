package sk.train;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

class RepeatedTestsWithInjectionTest {

	private final static Logger LOGGER = Logger.getLogger( RepeatedTestsWithInjectionTest.class.getName() );

	@BeforeEach
	void beforeEach(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		int currentRepetition = repetitionInfo.getCurrentRepetition();
		int totalRepetitions = repetitionInfo.getTotalRepetitions();
		String methodName = testInfo.getTestMethod().get().getName();
		LOGGER.info("About to execute repetition %d of %d for %s".formatted( 
			currentRepetition, totalRepetitions, methodName));
	}

	@RepeatedTest(10)
	void repeatedTest() {
		assertEquals(4, 2+2);
	}

	@RepeatedTest(5)
	void repeatedTestWithRepetitionInfo(RepetitionInfo repetitionInfo) {
		assertEquals(5, repetitionInfo.getTotalRepetitions());
	}

	@Disabled
	@RepeatedTest(value = 8, failureThreshold = 2)
	void repeatedTestWithFailureThreshold(RepetitionInfo repetitionInfo) {
		// Simulate unexpected failure every second repetition
		if (repetitionInfo.getCurrentRepetition() % 2 == 0) {
			fail("Boom!");
		}
	}

	@RepeatedTest(value = 1, name = "{displayName} {currentRepetition}/{totalRepetitions}")
	@DisplayName("Repeat!")
	void customDisplayName(TestInfo testInfo) {
		assertEquals("Repeat! 1/1", testInfo.getDisplayName());
	}

	@RepeatedTest(value = 1, name = RepeatedTest.LONG_DISPLAY_NAME)
	@DisplayName("Details...")
	void customDisplayNameWithLongPattern(TestInfo testInfo) {
		assertEquals("Details... :: repetition 1 of 1", testInfo.getDisplayName());
	}

}