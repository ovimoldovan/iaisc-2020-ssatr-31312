package mas.ssatr.moldovan.ovidiu;

import java.util.ArrayList;
import java.util.List;

public class Transition {
    private List<Place> PreviousPlaces;
    private List<Place> NextPlaces;
    private int Time = 1;
    private String Name;
    private boolean isExecuting;
    int auxTime;

    public List<Place> getPreviousPlaces() {
        return PreviousPlaces;
    }

    public List<Place> getNextPlaces() {
        return NextPlaces;
    }

    public String getName() {
        return Name;
    }

    public Transition(List<Place> PreviousPlaces, List<Place> NextPlaces, String name) {
        this.PreviousPlaces = PreviousPlaces;
        this.NextPlaces = NextPlaces;
        this.Name = name;
    }

    public Transition(String name) {
        this.PreviousPlaces = new ArrayList<Place>();
        this.NextPlaces = new ArrayList<Place>();
        this.Name = name;
    }

    public void AddNextPlace(Place p) {
        NextPlaces.add(p);
    }

    public void AddPreviousPlace(Place p) {
        PreviousPlaces.add(p);
    }

    public void setTime(int time) {
        Time = time;
    }

    public void ExecuteTransition() {
        if (IsExecutable()) {
            for (Place input : PreviousPlaces) {
                if (input.HasToken()) {
                    input.RemoveToken();
                }
            }
            isExecuting = true;
        }
        auxTime++;

        if (isExecuting && enoughTimeHasPassed(auxTime)) {
            FileHelper.Write(this.Name + " transition executed.");
            for (Place output : NextPlaces) {
                output.AddToken();
            }
            isExecuting = false;
            auxTime = 0;
        }
    }

    public void DisplayTransition() {
        FileHelper.Write("Transition " + this.Name + " with input places: ");
        for (Place input : PreviousPlaces) {
            FileHelper.Write(input.getName() + " ");
        }
        FileHelper.Write(" and output places: ");
        for (Place output : NextPlaces) {
            FileHelper.Write(output.getName() + " ");
        }
        FileHelper.Write("\nIt takes " + Time + " time units.\n");
    }

    public int getTime() {
        return Time;
    }

    public boolean IsExecutable() {
        for (Place input : PreviousPlaces) {
            if (!input.HasToken()) {
                return false;
            }
        }
        return true;
    }

    public boolean getIsExecuting() {
        return this.isExecuting;
    }

    public boolean enoughTimeHasPassed(int auxTime) {
        return auxTime > Time;
    }
}
