package mas.ssatr.moldovan.ovidiu;

import java.util.ArrayList;
import java.util.List;

public class Transition {
    public List<Place> PreviousPlaces;
    public List<Place> NextPlaces;
    public String Name;

    public Transition(List<Place> PreviousPlaces, List<Place> NextPlaces, String name){
        this.PreviousPlaces = PreviousPlaces;
        this.NextPlaces = NextPlaces;
        this.Name = name;
    }

    public Transition(String name){
        this.PreviousPlaces = new ArrayList<Place>();
        this.NextPlaces = new ArrayList<Place>();
        this.Name = name;
    }

    public void AddNextPlace(Place p){
        NextPlaces.add(p);
    }

    public void AddPreviousPlace(Place p){
        PreviousPlaces.add(p);
    }

    public void ExecuteTransitions(){
        for(Place input : PreviousPlaces){
            if(input.HasToken()){
                input.RemoveToken();
                for(Place output : NextPlaces){
                    output.AddToken();
                }
            }
        }
        System.out.println(this.Name + " transition executed.");
    }
}
