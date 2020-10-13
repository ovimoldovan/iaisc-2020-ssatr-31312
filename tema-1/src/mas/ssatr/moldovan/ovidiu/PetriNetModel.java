package mas.ssatr.moldovan.ovidiu;

import java.util.ArrayList;
import java.util.List;

public class PetriNetModel {
    public List<Place> Places;
    public List<Transition> Transitions;

    public PetriNetModel(List<Place> places, List<Transition> transitions) {
        Places = places;
        Transitions = transitions;
    }
    public PetriNetModel() {
        this.Places = new ArrayList<Place>();
        this.Transitions = new ArrayList<Transition>();
    }

    public void display(){
        for(var place : Places){
            place.DisplayPlace();
        }
        for(var transition : Transitions){
            transition.DisplayTransition();
        }
    }
}
