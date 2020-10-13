package mas.ssatr.moldovan.ovidiu;

import java.util.List;

public class Transition {
    public List<Place> PreviousPlaces;
    public List<Place> NextPlaces;

    public Transition(List<Place> PreviousPlaces, List<Place> NextPlaces){
        this.PreviousPlaces = PreviousPlaces;
        this.NextPlaces = NextPlaces;
    }

    public Transition(){
    }

    public void AddNextPlace(Place p){
        NextPlaces.add(p);
    }

    public void AddPreviousPlace(Place p){
        PreviousPlaces.add(p);
    }
}
