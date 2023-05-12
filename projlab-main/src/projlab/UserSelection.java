package projlab;

/**
 * A felhasználó által a Canvas-on kijelölt objektumokat tároló struktúra.
 */
public class UserSelection {
    public int selectedVirologistID;
    public int selectedFieldID;
    public int selectedAgentID;
    public int selectedEquipmentID;
    public projlab.Action selectedAction;
    public GeneticCode selectedGeneticCode;

    public UserSelection(int selectedVirologistID, int selectedFieldID, int selectedAgentID, int selectedEquipmentID, Action selectedAction, GeneticCode selectedGeneticCode) {
        this.selectedVirologistID = selectedVirologistID;
        this.selectedFieldID = selectedFieldID;
        this.selectedAgentID = selectedAgentID;
        this.selectedEquipmentID = selectedEquipmentID;
        this.selectedAction = selectedAction;
        this.selectedGeneticCode = selectedGeneticCode;
    }
}
