package integration;

import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

public class InegrationTestTopDown {

    private BibliotecaCtrl controller;
    private CartiRepoMock cartiRepository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception{
        this.cartiRepository = new CartiRepoMock();
        this.controller = new BibliotecaCtrl(cartiRepository);
    }

    @Test
    public void testCautare() {
        //date valide
        ArrayList<String> referenti = new ArrayList<String>();
        referenti.add("Ref");
        ArrayList<String> cuvinteCheie = new ArrayList<String>();
        cuvinteCheie.add("cu");
        cuvinteCheie.add("c");
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.setReferenti(referenti);
        carte.setAnAparitie("2010");
        carte.setCuvinteCheie(cuvinteCheie);
        carte.setEditura("Ed");
        try {
            controller.adaugaCarte(carte);
            assert true;
        }catch (Exception ex){
            System.out.println(ex.toString());
            assert false;
        }
    }

    @Test
    public void integrationCautareDupaAutor(){
        testCautare();
        String name = "Mihai Eminescu";
        try {
            assert controller.cautaCarte(name).size() == 1;
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
    }

    @Test
    public void integrarationCautareOrdonataDupaAn(){
        integrationCautareDupaAutor();
        String an = "1973";
        try {
            assert controller.getCartiOrdonateDinAnul(an).size() == 2;
        }catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
