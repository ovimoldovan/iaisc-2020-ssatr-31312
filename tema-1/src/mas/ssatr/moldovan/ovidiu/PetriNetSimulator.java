package mas.ssatr.moldovan.ovidiu;

public class PetriNetSimulator {
    private PetriNetModel petriNetModel;
    public static int ApplicationTime = 0;
    private int copyTime;

    public PetriNetSimulator(PetriNetModel petriNetModel) {
        this.petriNetModel = petriNetModel;
    }

    public void Simulate(){
        FileHelper.Write("\n-----Simulation started-----\n");
        for(var transition : petriNetModel.Transitions){
            this.ApplicationTime++;
            FileHelper.Write("Application time: " + this.ApplicationTime);
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
