import org.example.FiniteStateMachine;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FiniteStateMachineTest {

    @Test
    void testStringWithTest() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "abcTESTabc";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
    }

    @Test
    void testPartialTestString() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "abcTES";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.STATE3, fsm.getCurrentState());
    }

    @Test
    void testExactTestString() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "TEST";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
    }

    @Test
    void testSingleT() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "T";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.STATE1, fsm.getCurrentState());
    }

    @Test
    void testEmptyString() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.S, fsm.getCurrentState());
    }

    @Test
    void testRandomString() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "randomstring";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.S, fsm.getCurrentState());
    }

    @Test
    void testStringWithMultipleTEST() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "abcTESTTEST";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
    }

    @Test
    void testStringWithNoiseBeforeAndAfter() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "noiseTESnoise";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.S, fsm.getCurrentState());
    }

    @Test
    void testStringWithPartialMatchThenReset() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "TESTabcTES";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
    }

    @Test
    void testLongStringWithoutTEST() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "abcdefghijklmnopqrstuvwxyz";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.S, fsm.getCurrentState());
    }

    @Test
    void testStringWithTestInMiddle() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "abcTESTxyz";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
    }

    @Test
    void testStringWithPartialOverlap() {
        FiniteStateMachine fsm = new FiniteStateMachine();
        String input = "TESTEST";

        for (char c : input.toCharArray()) {
            fsm.process(c);
        }

        assertEquals(FiniteStateMachine.State.F, fsm.getCurrentState());
    }
}
