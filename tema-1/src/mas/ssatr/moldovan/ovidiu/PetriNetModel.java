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

    public void display() {
        for (var place : Places) {
            place.DisplayPlace();
        }
        for (var transition : Transitions) {
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

    public void step() {
        List<Transition> executableTransitions = new ArrayList<Transition>();
        for (var transition : Transitions) {
            if (transition.IsExecutable() || transition.getIsExecuting()) {
                executableTransitions.add(transition);
            }
        }

        for (var transition : executableTransitions) {
            transition.ExecuteTransition();
            PetriNetSimulator.LastExecutedTransitionTime = PetriNetSimulator.ApplicationTime;
        }

        PetriNetSimulator.ApplicationTime++;
        WriteMarkings();
    }

    private void WriteMarkings() {
        FileHelper.WriteOneLine("Markings: ");
        for (var place : Places) {
            FileHelper.WriteOneLine(place.getTokens() + " ");
        }
        FileHelper.WriteOneLine("\n");
    }

    public int getMaxTime() {
        int max = 0;
        for (var transition : Transitions) {
            if (max < transition.getTime()) {
                max = transition.getTime();
            }
        }
        return max;
    }
}
