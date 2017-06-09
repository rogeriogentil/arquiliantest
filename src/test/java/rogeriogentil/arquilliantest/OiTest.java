package rogeriogentil.arquilliantest;

import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 *
 * @author Rogerio J. Gentil
 */
@RunWith(Arquillian.class)
public class OiTest {
    
    @Inject
    private Oi oi;
    
    @Deployment
    public static JavaArchive criarJAR() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
            .addClass(Oi.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        
        // exibe os arquivos contidos no arquivo .jar
        System.out.println(jar.toString(true));
        
        return jar;
    }
    
    @Test
    public void deveDizerOlaRogerio() {
        assertEquals("Oi, Rogerio!", oi.cumprimentar("Rogerio"));
    }
    
}
