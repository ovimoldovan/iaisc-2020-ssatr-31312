package mas.ssatr.moldovan.ovidiu;

public class CapsuleA {

    String messageToSend;

    public void setMessageToSend(String message){
        messageToSend = message;
    }

    public void StateMachineA(Port1 p){
        p.setMessage(messageToSend);
    }
}
