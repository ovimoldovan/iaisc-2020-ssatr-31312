package mas.ssatr.moldovan.ovidiu;

public class Main {

    public static void main(String[] args) {
        CapsuleA capsuleA = new CapsuleA();
        CapsuleB capsuleB = new CapsuleB();

        Port1 p = new Port1();

        capsuleA.setMessageToSend("Mesaj de la capsula A");
        capsuleA.StateMachineA(p);

        capsuleB.StateMachineB(p);
        capsuleB.shoutMessage();
    }
}
