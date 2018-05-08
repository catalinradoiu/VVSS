package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repo.CartiRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BibliotecaCtrlTest {

    private BibliotecaCtrl bibliotecaCtrl;

    @Before
    public void setUp() throws Exception {
        bibliotecaCtrl = new BibliotecaCtrl(new CartiRepo());
    }

    @Test
    public void adaugaCarteBBT1() {
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("2016");
        carte.setEditura("edit");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try {
            bibliotecaCtrl.adaugaCarte(carte);
            assert true;
        } catch (Exception e) {
            assert false;
        }
    }

    @Test
    public void adaugaCarteBBT2(){
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi2");
        carte.setAnAparitie("2016");
        carte.setEditura("edit");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert false;
        } catch (Exception e){
            assert true;
            assertEquals(e.getMessage(), "Autor invalid!");
        }
    }

    @Test
    public void adaugaCarteBBT3(){
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("20c");
        carte.setEditura("edit");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert false;
        } catch (Exception e){
            assert true;
            assertEquals(e.getMessage(), "An invalid!");
        }
    }

    @Test
    public void adaugaCarteBBT4(){
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("1899");
        carte.setEditura("edit");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert false;
        } catch (Exception e){
            assert true;
            assertEquals(e.getMessage(), "An invalid!");
        }
    }

    @Test
    public void adaugaCarteBBT5(){
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.setAnAparitie("2013");
        carte.setEditura("12*abc");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert false;
        } catch (Exception e){
            assert true;
            assertEquals(e.getMessage(), "Editura invalida!");
        }
    }

    @Test
    public void adaugaCarteBBT6(){
        Carte carte = new Carte();
        carte.setTitlu("Titlu");
        carte.adaugaReferent("Ion");
        carte.setAnAparitie("2012");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("abc");
        carte.adaugaCuvantCheie("");
        carte.adaugaCuvantCheie("12m");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert false;
        } catch (Exception e){
            assert true;
            assertEquals(e.getMessage(), "Cuvant cheie invalid!");
        }
    }

    @Test
    public void adaugaCarteBBT7(){
        Carte carte = new Carte();
        carte.setTitlu("*abc");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("2011");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert false;
        } catch (Exception e){
            assert true;
            assertEquals(e.getMessage(), "Titlu invalid!");
        }
    }

    @Test
    public void adaugaCarteBBT8(){
        Carte carte = new Carte();
        carte.setTitlu("ab");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("1900");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert true;
        } catch (Exception e){
            assert false;
        }
    }

    @Test
    public void adaugaCarteBBT9(){
        Carte carte = new Carte();
        carte.setTitlu("C");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("1901");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert true;
        } catch (Exception e){
            assert false;
        }
    }

    @Test
    public void adaugaCarteBBT10(){
        Carte carte = new Carte();
        carte.setTitlu("Titlu test");
        carte.adaugaReferent("Ion");
        carte.adaugaReferent("Popescu");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("2010");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        try{
            bibliotecaCtrl.adaugaCarte(carte);
            assert true;
        } catch (Exception e){
            assert false;
        }
    }
}