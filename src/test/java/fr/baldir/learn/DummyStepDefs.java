package fr.baldir.learn;

import io.cucumber.java8.En;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class DummyStepDefs implements En {
    public DummyStepDefs() {
        Given("^the project has no real business use cases$", () -> {

        });
        Then("^this dummy feature should exist$", () -> {
            // dummy.feature should not exist
            // fr.baldir.learn.DummyStepDefs.java should not exist
            assertThat(featureFiles())
                    .describedAs("Please remove both src/test/java/fr/baldir/learn/DummyStepDefs.java and src/test/resources/dummy.feature\n" +
                            "This dummy Gherkin feature and step definition should not exist anymore")
                    .containsExactly("dummy.feature");

        });
    }

    private HashSet<String> featureFiles() throws IOException {
        var featuresResourceFolder = this.getClass().getResourceAsStream("/features");
        var featureFiles = new HashSet<String>();
        BufferedReader br = new BufferedReader(new InputStreamReader(featuresResourceFolder));
        String resource;

        while ((resource = br.readLine()) != null) {
            featureFiles.add(resource);
        }
        return featureFiles;
    }
}
