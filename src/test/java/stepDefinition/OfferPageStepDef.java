package stepDefinition;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.*;
import utils.BaseUtil;

public class OfferPageStepDef {
    private final BaseUtil base;
    public String offerProductName;
    private final LandingPage lp;
    private final OfferPage op;

    public OfferPageStepDef(BaseUtil base) {
        this.base = base;
        this.lp = base.pom.getLandingPage();
        this.op = base.pom.getOfferPage();
    }

    public void switchToOfferPage(){
        lp.selectTopDeals();
        base.gu.switchWindowToChild();
    }

    @Then("User search for {string} shortname in offers page")
    public void userSearchForShortnameInOffersPage(String shortName) {
        switchToOfferPage();
        op.searchItem(shortName);
        offerProductName = op.getProductItem();
    }

    @And("validate product name in Offers Page matches with Landing Page")
    public void validateProductNameInOffersPageMatchesWithLandingPage() {
        Assert.assertEquals(offerProductName, base.landingProductName);
    }

    @Then("^User search for (.+) in Offers Page$")
    public void userSearchForInOffersPage(String proName) {
        switchToOfferPage();
        op.searchItem(proName);
        offerProductName = op.getProductItem();
    }
}
