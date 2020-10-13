package mas.ssatr.moldovan.ovidiu;

public class PetriNetSimulator {
    private PetriNetModel petriNetModel;
    private int currentTime = 0;

    public PetriNetSimulator(PetriNetModel petriNetModel) {
        this.petriNetModel = petriNetModel;
    }

    public void Simulate(){
        for(var transition : petriNetModel.Transitions){
            transition.ExecuteTransitions();
        }
    }
}
