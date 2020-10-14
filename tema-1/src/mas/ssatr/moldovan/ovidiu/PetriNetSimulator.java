package mas.ssatr.moldovan.ovidiu;

public class PetriNetSimulator {
    private PetriNetModel petriNetModel;
    private int currentTime = 0;
    private int copyTime;

    public PetriNetSimulator(PetriNetModel petriNetModel) {
        this.petriNetModel = petriNetModel;
    }

    public void Simulate(){
        System.out.println("\n-----Simulation started-----\n");
        for(var transition : petriNetModel.Transitions){
            this.currentTime++;
            System.out.println("Application time: " + this.currentTime);
            transition.ExecuteTransition();
        }
    }

    int executableAtTimeUnit(){
        int timestamp = 0;
        for(int i=0; i<petriNetModel.Transitions.size(); i++){
            timestamp = timestamp +petriNetModel.Transitions.get(i).getTime();
        }
        return timestamp;
    }
}
