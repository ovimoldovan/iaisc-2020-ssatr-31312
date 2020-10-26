package mas.ssatr.moldovan.ovidiu;

import java.util.ArrayList;
import java.util.Collections;
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

    public void sortTransitions() {
        Collections.sort(Transitions, (o1, o2) -> {
            if (o1.getTime() == o2.getTime()) {
                return 0;
            }
            return o1.getTime() < o2.getTime() ? -1 : 1;
        });
    }
}
