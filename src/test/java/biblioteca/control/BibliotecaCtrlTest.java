package biblioteca.control;

import biblioteca.model.Carte;
import biblioteca.repository.repo.CartiRepo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class BibliotecaCtrlTest {

    private BibliotecaCtrl bibliotecaCtrl;
    private CartiRepo cartiRepo;

    @Before
    public void setUp() throws Exception {
        cartiRepo = new CartiRepo();
        bibliotecaCtrl = new BibliotecaCtrl(cartiRepo);
    }

    @After
    public void tearDown() throws Exception{
        cartiRepo.golesteFisier();
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


    @Test
    public void getCartiOrdonateDinAnulBBTValid(){
        try{
            adaugaCarti();
            List<Carte> result = bibliotecaCtrl.getCartiOrdonateDinAnul("2010");
            System.out.println(result.size());
            assert result.size() == 3;
            assert result.get(0).getTitlu().equals("Titlu testa");
            assert result.get(1).getTitlu().equals("Titlu testb");
            assert result.get(2).getTitlu().equals("Titlu testc");
        } catch (Exception e){
            assert false;
        }
    }

    @Test
    public void getCartiOrdinateDinAnulWBTInvalid(){
        try{
            bibliotecaCtrl.getCartiOrdonateDinAnul("das2");
            assert false;
        } catch (Exception e){
            assert true;
        }
    }

    private void adaugaCarti() throws Exception {
        Carte carte = new Carte();
        carte.setTitlu("Titlu testa");
        carte.adaugaReferent("Popescu");
        carte.setAnAparitie("2010");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        bibliotecaCtrl.adaugaCarte(carte);
        carte = new Carte();
        carte.setTitlu("Titlu testb");
        carte.adaugaReferent("Ionescu");
        carte.setAnAparitie("2010");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        bibliotecaCtrl.adaugaCarte(carte);
        carte = new Carte();
        carte.setTitlu("Titlu testc");
        carte.adaugaReferent("Gigi");
        carte.setAnAparitie("2010");
        carte.setEditura("test");
        carte.adaugaCuvantCheie("cuvant");
        carte.adaugaCuvantCheie("cuv");
        bibliotecaCtrl.adaugaCarte(carte);
    }
}