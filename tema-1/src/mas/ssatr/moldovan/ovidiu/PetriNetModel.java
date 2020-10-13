package mas.ssatr.moldovan.ovidiu;

import java.util.List;

public class PetriNetModel {
    public List<Place> Places;
    public List<Transition> Transitions;

    public PetriNetModel(List<Place> places, List<Transition> transitions) {
        Places = places;
        Transitions = transitions;
    }
}
