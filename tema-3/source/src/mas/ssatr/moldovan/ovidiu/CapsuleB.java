package mas.ssatr.moldovan.ovidiu;

public class CapsuleB {

    private String messageToBeReceived;

    public void StateMachineB(Port1 p){
        messageToBeReceived = p.getMessage();
    }

    public void shoutMessage(){
        System.out.println(messageToBeReceived);
    }

}
