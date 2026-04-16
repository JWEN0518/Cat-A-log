//package miniProject;
import java.util.Vector;

public interface CatCareAction {

    void recordFeeding(Cat cat);

    void logVetVisit(Cat cat);

    void reportIncident(Vector<Cat> cats);
}
