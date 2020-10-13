package mas.ssatr.moldovan.ovidiu;

import java.util.ArrayList;
import java.util.List;

public class Transition {
    private List<Place> PreviousPlaces;
    private List<Place> NextPlaces;

    public List<Place> getPreviousPlaces() {
        return PreviousPlaces;
    }

    public List<Place> getNextPlaces() {
        return NextPlaces;
    }

    public String getName() {
        return Name;
    }

    private String Name;

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

    public void ExecuteTransition(){
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

    public void DisplayTransition(){
        System.out.print("Transition " + this.Name + " with input places: ");
        for(Place input : PreviousPlaces){
            System.out.print(input.getName()+ " ");
            }
        System.out.print(" and output places: ");
        for(Place output : NextPlaces){
            System.out.print(output.getName() + " ");
        }
        System.out.print("\n");
    }
}
