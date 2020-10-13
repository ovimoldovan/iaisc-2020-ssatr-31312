package mas.ssatr.moldovan.ovidiu;

import jdk.jshell.spi.ExecutionControl;

import java.util.List;

public class PetriNetLoader {

    public void read(){
        System.out.println("Not implemented");
    }

    public PetriNetModel initializeHardCodedPetriNet(){
        Place p1 = new Place(1, "P1");
        Place p2 = new Place(0, "P2");
        Place p3 = new Place(0, "P3");
        Transition t1 = new Transition("T1");
        t1.AddPreviousPlace(p1);
        t1.AddNextPlace(p2);
        Transition t2 = new Transition("T2");
        t2.AddPreviousPlace(p2);
        t2.AddNextPlace(p3);

        List<Place> Places = List.of(p1, p2, p3);
        List<Transition> Transitions = List.of(t1, t2);
        PetriNetModel PetriNetModel = new PetriNetModel(Places, Transitions);
        return PetriNetModel;
    }
}
