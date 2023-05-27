package create_agent;
import projlab.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import java.util.TreeMap;

import static org.junit.Assert.assertTrue;

public class CreateAgent {
    private Virologist virologist;
    private ChoreaVirusGene choreaVirusGene;
    private MemoryLossVirusGene memoryLossVirusGene;
    private ParalyzingVirusGene paralyzingVirusGene;
    private VaccineGene vaccineGene;

    @Given("a Virologist")
    public void givenAVirologist() {
        virologist = new Virologist();
    }

    @Given("a ChoreaVirusGene")
    public void givenAChoreaVirusGene() {
        choreaVirusGene = ChoreaVirusGene.getInstance();
    }

    @Given("a MemoryLossVirusGene")
    public void givenAMemoryLossVirusGene() {
        memoryLossVirusGene = MemoryLossVirusGene.getInstance();
    }

    @Given("a ParalyzingVirusGene")
    public void givenAParalyzingVirusGene() {
        paralyzingVirusGene = ParalyzingVirusGene.getInstance();
    }

    @Given("a VaccineGene")
    public void givenAVaccineGene() {
        vaccineGene = VaccineGene.getInstance();
    }

    @When("the Virologist adds the ChoreaVirusGene")
    public void whenTheVirologistAddsTheChoreaVirusGene() {
        virologist.addGeneticCode(choreaVirusGene);
    }

    @When("the Virologist adds the MemoryLossVirusGene")
    public void whenTheVirologistAddsTheMemoryLossVirusGene() {
        virologist.addGeneticCode(memoryLossVirusGene);
    }

    @When("the Virologist adds the ParalyzingVirusGene")
    public void whenTheVirologistAddsTheParalyzingVirusGene() {
        virologist.addGeneticCode(paralyzingVirusGene);
    }

    @When("the Virologist adds the VaccineGene")
    public void whenTheVirologistAddsTheVaccineGene() {
        virologist.addGeneticCode(vaccineGene);
    }

    @When("the Virologist is provided with the necessary amino acid and nucleotide")
    public void whenTheVirologistIsProvidedWithTheNecessaryAminoAcidAndNucleotide() {
        virologist.addAminoAcid(4);
        virologist.addNucleotide(4);
    }

    @Then("the Virologist creates the Chorea Virus agent")
    public void thenTheVirologistCreatesTheChoreaVirusAgent() throws Throwable {
        int agentId = virologist.createAgent(choreaVirusGene);
        TreeMap<Integer, Agent> agents = virologist.getAgents();
        assertTrue(agents.containsKey(agentId));
    }

    @Then("the Virologist creates the Memory Loss Virus agent")
    public void thenTheVirologistCreatesTheMemoryLossVirusAgent() throws Throwable {
        int agentId = virologist.createAgent(memoryLossVirusGene);
        TreeMap<Integer, Agent> agents = virologist.getAgents();
        assertTrue(agents.containsKey(agentId));
    }

    @Then("the Virologist creates the Paralyzing Virus agent")
    public void thenTheVirologistCreatesTheParalyzingVirusAgent() throws Throwable {
        int agentId = virologist.createAgent(paralyzingVirusGene);
        TreeMap<Integer, Agent> agents = virologist.getAgents();
        assertTrue(agents.containsKey(agentId));
    }

    @Then("the Virologist creates the Vaccine agent")
    public void thenTheVirologistCreatesTheVaccineAgent() throws Throwable {
        int agentId = virologist.createAgent(vaccineGene);
        TreeMap<Integer, Agent> agents = virologist.getAgents();
        assertTrue(agents.containsKey(agentId));
    }
}
