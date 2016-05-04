/**
 * Created by Sebastian on 18/10/2015.
 */
public class NovelSplit {
    //Last chapters
    //SW - 188
    //AC - 22
    //SBM - 5
    //3 Feb

    static String[] persons = {"jwong", "ewad", "yang"}; //Associated person for each array in entries

    static double[][] entries = {
            {5, 0, 0},
            {15, 15, 0},
            {0, 3, 1}
    }; // Each array for each person, [Translated, Edited, Posted]

    static double totalRev = 361.43;

    public static void main(String[] args) {
        double tlRev = totalRev*0.6;
        double editRev = totalRev*0.35;
        double postRev = totalRev*0.05;

        double tlParts = 0;
        double editParts = 0;
        double postParts = 0;

        //gathering parts
        for (double[] entry: entries) {
            tlParts = tlParts + entry[0];
            editParts = editParts + entry[1];
            postParts = postParts + entry[2];
        }

        double tlRevPerPart = tlRev/tlParts;
        double editRevPerPart = editRev/editParts;
        double postRevPerPart = postRev/postParts;

        int counter = 0;
        for (String person: persons) {
            System.out.println(person + ": " + (tlRevPerPart*entries[counter][0] + editRevPerPart*entries[counter][1] + postRevPerPart*entries[counter][2]));
            counter++;
        }

        System.out.println();
        System.out.println("Each TL: " + tlRevPerPart);
        System.out.println("Each Edit: " + editRevPerPart);
        System.out.println("Each Post: " + postRevPerPart);
    }
}
