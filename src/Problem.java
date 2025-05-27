import java.util.HashSet;
import java.util.Set;

public class Problem {
    /**
     * Returns how many salamanders less than 3 years old will be at risk from a
     * serious infection if a given salamander is infected.
     * 
     * When a salamander is infected, it will pass the disease along to all of
     * its contacts. Each of those contacts will pass it on to their contacts
     * and so on. Salamanders of any age can catch and spread the disease, but
     * it is only a serious risk for salamanders strictly less than 3 years old.
     * 
     * Include the initial patient in the count iff the initial patient is less
     * than 3 years old.
     * 
     * @param initialPatient the first salamander to be infected
     * @return the number of salamanders less than 3 years old that may be infected
     */
    public static int countSeriousInfections(Salamander initialPatient) {
        // int countInfect = 0;
        Set<Salamander> visted = new HashSet<>();

        return ((initialPatient.getAge() < 3) ? 0:1) + countSeriousInfections(initialPatient, visted);

    }

    public static int countSeriousInfections(Salamander initialPatient, Set<Salamander> visted){
        if(initialPatient == null || visted.contains(initialPatient)) return 0;

        visted.add(initialPatient);
        int track;

        if(initialPatient.getAge() > 3){
            track = 1;
        }else{
            track = 0;
        }

        for(Salamander sal: initialPatient.getContacts()){
            track += countSeriousInfections(sal, visted);
        }

        return track;
    }
}
