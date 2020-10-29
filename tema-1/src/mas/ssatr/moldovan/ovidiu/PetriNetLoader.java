package mas.ssatr.moldovan.ovidiu;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class PetriNetLoader {

    public PetriNetModel petriNetModel = new PetriNetModel();

    public void read() {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/mas/ssatr/moldovan/ovidiu/input.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray places = (JSONArray) jsonObject.get("places");
            JSONArray transitions = (JSONArray) jsonObject.get("transitions");

            places.forEach(place -> parsePlacesObject((JSONObject) place));
            transitions.forEach(transition -> parseTransitionsObject((JSONObject) transition));

            petriNetModel.display();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parsePlacesObject(JSONObject places) {
        String name = places.get("name").toString();
        String tokens = places.get("tokens").toString();
        Place place = new Place(Integer.parseInt(tokens), name);
        this.petriNetModel.Places.add(place);
    }

    private void parseTransitionsObject(JSONObject transitions) {
        JSONArray previousPlaces = (JSONArray) transitions.get("previousPlaces");
        JSONArray nextPlaces = (JSONArray) transitions.get("nextPlaces");
        String name = transitions.get("name").toString();

        String time;
        try {
            time = transitions.get("time").toString();
        } catch (Exception e) {
            time = "0";
        }

        String time2;
        try {
            time2 = transitions.get("time2").toString();
        } catch (Exception e) {
            time2 = null;
        }

        int timeInt = getTimeInt(time, time2);

        Transition transition = new Transition(name);
        transition.setTime(timeInt);

        Iterator<JSONObject> iterator = previousPlaces.iterator();
        while (iterator.hasNext()) {
            var placeName = iterator.next().get("name").toString();
            for (var p : this.petriNetModel.Places) {
                if (p.getName().equalsIgnoreCase(placeName)) {
                    transition.AddPreviousPlace(p);
                }
            }
        }
        iterator = nextPlaces.iterator();
        while (iterator.hasNext()) {
            var placeName = iterator.next().get("name").toString();
            for (var p : this.petriNetModel.Places) {
                if (p.getName().equalsIgnoreCase(placeName)) {
                    transition.AddNextPlace(p);
                }
            }
        }
        this.petriNetModel.Transitions.add(transition);
    }

    private int getTimeInt(String time, String time2) {
        if (time2 != null) {
            return computeTime(time, time2);
        } else {
            return Integer.parseInt(time);
        }
    }

    private int computeTime(String time, String time2) {
        int t1 = Integer.parseInt(time);
        int t2 = Integer.parseInt(time2);
        Random r = new Random();
        return r.nextInt(t2 - t1) + t1;
    }

    public PetriNetModel initializeHardCodedPetriNet() {
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
