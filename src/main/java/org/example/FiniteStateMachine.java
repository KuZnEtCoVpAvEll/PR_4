package org.example;

public class FiniteStateMachine {
    public enum State {
        S,
        STATE1,
        STATE2,
        STATE3,
        F
    }


    private State currentState;

    public FiniteStateMachine() {
        currentState = State.S;
    }

    public void process(char input) {
        switch (currentState) {
            case S -> {
                currentState = (input == 'T') ? State.STATE1 : State.S;
                System.out.println((input == 'T') ? "Перехід до STATE1" : "Залишаємося в S");
            }
            case STATE1 -> {
                currentState = (input == 'E') ? State.STATE2 : (input == 'T' ? State.STATE1 : State.S);
                System.out.println((input == 'E') ? "Перехід до STATE2" : (input == 'T' ? "Повторний T, залишаємося в STATE1" : "Скидання до S"));
            }
            case STATE2 -> {
                currentState = (input == 'S') ? State.STATE3 : (input == 'T' ? State.STATE1 : State.S);
                System.out.println((input == 'S') ? "Перехід до STATE3" : (input == 'T' ? "Починаємо новий T, перехід до STATE1" : "Скидання до S"));
            }
            case STATE3 -> {
                currentState = (input == 'T') ? State.F : (input == 'T' ? State.STATE1 : State.S);
                System.out.println((input == 'T') ? "Перехід до F, знайдено TEST" : "Скидання до S");
            }
            case F -> System.out.println("Ми вже в кінцевому стані F");
        }
    }

    public State getCurrentState() {
        return currentState;
    }

    public void reset() {
        currentState = State.S;
    }

    public static void main(String[] args) {
        String test1 = "abcTESTabc";
        String test2 = "abcTES";

        FiniteStateMachine fsm = new FiniteStateMachine();

        for (char c : test1.toCharArray()) {
            fsm.process(c);
        }
        System.out.println("Final State for '" + test1 + "': " + fsm.getCurrentState());

        fsm.reset();

        for (char c : test2.toCharArray()) {
            fsm.process(c);
        }
        System.out.println("Final State for '" + test2 + "': " + fsm.getCurrentState());
    }
}
