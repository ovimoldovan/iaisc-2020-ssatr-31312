package mas.ssatr.moldovan.ovidiu;

public class PetriNetSimulator {
    private PetriNetModel petriNetModel;
    public static int ApplicationTime = 0;

    public PetriNetSimulator(PetriNetModel petriNetModel) {
        this.petriNetModel = petriNetModel;
    }

    public void Simulate(){
        //petriNetModel.sortTransitions();
        FileHelper.Write("\n-----Simulation started-----\n");
        for(var transition : petriNetModel.Transitions){
            FileHelper.Write("Application time: " + this.ApplicationTime);
            transition.ExecuteTransition();
            try{
                Thread.sleep(1000);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
