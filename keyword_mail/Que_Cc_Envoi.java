package keyword_mail;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.Collection;

import static com.mail.Automation.*;
import static com.mail.Body.*;
import static com.mail.Subject.*;
import static com.mail.Text.*;
import static java.util.Arrays.asList;

@RunWith(Parameterized.class)
public class Que_Cc_Envoi {

    private final String Contenu;
    private final String Copie;
    private final String Signature;
    private final String Sujet;

    public Que_Cc_Envoi(final String Contenu, final String Copie, final String Signature, final String Sujet) {
        this.Contenu = Contenu;
        this.Copie = Copie;
        this.Signature = Signature;
        this.Sujet = Sujet;
    }

    @Parameters(name = "{0}-{1}-{2}-{3}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {"Bonjour, ceci est un test", "marc.hage@altran.com", "Marc Hage Chahine", "Sujet non vide"}
        });
    }

    @Before
    public void setUp() {
        OpenApplication(mail.altran);
        ClickButton(Open composer);
    }

    @After
    public void tearDown() {
        CloseApplication(mail.altran);
    }

    @Test
    public void execute() {
        Enter_subject(Sujet);
        Enter_mail_Cc(Copie);
        Enter_Body(Contenu, Signature);
        ClickButton(SendMail);
    }
}
