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
public class Envoi_simple {

    private final String A;
    private final String Contenu;
    private final String Copie;
    private final String Copie_cachee;
    private final String Signature;
    private final String Sujet;

    public Envoi_simple(final String A, final String Contenu, final String Copie, final String Copie_cachee, final String Signature, final String Sujet) {
        this.A = A;
        this.Contenu = Contenu;
        this.Copie = Copie;
        this.Copie_cachee = Copie_cachee;
        this.Signature = Signature;
        this.Sujet = Sujet;
    }

    @Parameters(name = "{0}-{1}-{2}-{3}-{4}-{5}")
    public static Collection<Object[]> dataSets() {
        return asList(new Object[][]{
            {"marc.hage@altran.com", "Bonjour, ceci est un test", "marc.hage@outlook.fr", "{vide}", "Marc Hage Chahine", "Sujet non vide"},
            {"marc.hage@altran.com", "Bonjour, test envoi d'un mail", "marc.hage@outlook.fr", "{vide}", "{vide}", "Sujet non vide"}
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
        Enter_mail_to(A);
        Enter_mail_Cc(Copie);
        Enter_mail_Cci(Copie_cachee);
        Enter_Body(Contenu, Signature);
        ClickButton(SendMail);
    }
}
