package mas.ssatr.moldovan.ovidiu;

public class Main {

    public static void main(String[] args) {
        var Loader = new PetriNetLoader();
	    var PetriNetModel = Loader.initializeHardCodedPetriNet();
	    var PetriNetSimulator = new PetriNetSimulator(PetriNetModel);
	    PetriNetSimulator.Simulate();
    }
}
