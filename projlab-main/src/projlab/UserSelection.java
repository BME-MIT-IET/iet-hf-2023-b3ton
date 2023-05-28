package projlab;

/**
 * A felhasználó által a Canvas-on kijelölt objektumokat tároló struktúra.
 */
public class UserSelection {
    private int selectedVirologistID;
    private int selectedFieldID;
    private int selectedAgentID;
    private int selectedEquipmentID;
    private projlab.Action selectedAction;
    private GeneticCode selectedGeneticCode;

    public UserSelection(int selectedVirologistID, int selectedFieldID, int selectedAgentID, int selectedEquipmentID, Action selectedAction, GeneticCode selectedGeneticCode) {
        this.setSelectedVirologistID(selectedVirologistID);
        this.setSelectedFieldID(selectedFieldID);
        this.setSelectedAgentID(selectedAgentID);
        this.setSelectedEquipmentID(selectedEquipmentID);
        this.setSelectedAction(selectedAction);
        this.setSelectedGeneticCode(selectedGeneticCode);
    }

    public int getSelectedVirologistID() {
        return selectedVirologistID;
    }

    public void setSelectedVirologistID(int selectedVirologistID) {
        this.selectedVirologistID = selectedVirologistID;
    }

    public int getSelectedFieldID() {
        return selectedFieldID;
    }

    public void setSelectedFieldID(int selectedFieldID) {
        this.selectedFieldID = selectedFieldID;
    }

    public int getSelectedAgentID() {
        return selectedAgentID;
    }

    public void setSelectedAgentID(int selectedAgentID) {
        this.selectedAgentID = selectedAgentID;
    }

    public int getSelectedEquipmentID() {
        return selectedEquipmentID;
    }

    public void setSelectedEquipmentID(int selectedEquipmentID) {
        this.selectedEquipmentID = selectedEquipmentID;
    }

    public Action getSelectedAction() {
        return selectedAction;
    }

    public void setSelectedAction(Action selectedAction) {
        this.selectedAction = selectedAction;
    }

    public GeneticCode getSelectedGeneticCode() {
        return selectedGeneticCode;
    }

    public void setSelectedGeneticCode(GeneticCode selectedGeneticCode) {
        this.selectedGeneticCode = selectedGeneticCode;
    }
}
