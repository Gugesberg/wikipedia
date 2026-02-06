package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HeadPage {
    private SelenideElement loginLinkLocator = $("#pt-login"),
            depositeLinkLocator  = $("#pt-anoncontribs"),
            savePageAsPDFLinkLocator = $("#coll-download-as-rl");

    public HeadPage pushLoginLink(){
        loginLinkLocator.click();
        return this;
    }
    public HeadPage pushDepositeLink(){
        depositeLinkLocator.click();
        return this;
    }
    public HeadPage pushsavePageAsPDFLink(){
        savePageAsPDFLinkLocator.click();
        return this;
    }

}
