package mas.ssatr.moldovan.ovidiu;

public class PetriNetSimulator {
    private PetriNetModel petriNetModel;
    public static int ApplicationTime = 0;
    public static int LastExecutedTransitionTime;
    private boolean isActive = true;

    public PetriNetSimulator(PetriNetModel petriNetModel) {
        this.petriNetModel = petriNetModel;
    }

    public void Simulate(){
        FileHelper.Write("\n-----Simulation started-----\n");
        while(isActive){
            FileHelper.Write("Application time: " + this.ApplicationTime);
            petriNetModel.step();
            if(ApplicationTime > LastExecutedTransitionTime + petriNetModel.getMaxTime()){
                isActive = false;
            }
        }
    }
}
