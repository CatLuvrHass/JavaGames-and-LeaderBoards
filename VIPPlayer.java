package final_project;

public class VIPPlayer extends Player {

    private static final long serialVersionUID = 1L;

    // VIP can only play for the points they have. Will get a Badge when finished.
    public VIPPlayer(String Name) {
        super("[VIP] " + Name);
    }

}