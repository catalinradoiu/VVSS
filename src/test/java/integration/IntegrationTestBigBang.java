package integration;

import biblioteca.control.BibliotecaCtrl;
import biblioteca.model.Carte;
import biblioteca.repository.repoMock.CartiRepoMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class IntegrationTestBigBang {

    private CartiRepoMock cartiRepository1;
    private CartiRepoMock cartiRepository2;
    private BibliotecaCtrl controller;

    @Before
    public void setUp() throws Exception{
        this.cartiRepository1 = new CartiRepoMock();
        this.cartiRepository2 = new CartiRepoMock();
        this.cartiRepository2.getCarti().clear();
        this.controller = new BibliotecaCtrl(this.cartiRepository1);
    }

    @Test
    public void testAdauga() {
        //titlu contine o litera
        int dimensiuneFisierInainte = cartiRepository1.getCarti().size();
        ArrayList<String> referenti = new ArrayList<String>();
        referenti.add("ref");
        ArrayList<String> cuvinteCheie = new ArrayList<String>();
        cuvinteCheie.add("cu");
        cuvinteCheie.add("c");
        Carte carte = new Carte();
        carte.setTitlu("T");
        carte.setReferenti(referenti);
        carte.setAnAparitie("2010");
        carte.setCuvinteCheie(cuvinteCheie);
        carte.setEditura("edit");
        try {
            controller.adaugaCarte(carte);
        }catch (Exception ex){
            System.out.println(ex.toString());
            assert false;
        }
        int dimensiuneFisierDupa = cartiRepository1.getCarti().size();
        assertEquals(dimensiuneFisierInainte+1, dimensiuneFisierDupa);
    }

    @Test
    public void testCautaDupaAutor(){
        //cautare cu succes
        String name = "Mihai Eminescu";
        int dim_exp = 1;
        int dim_found = cartiRepository1.cautaCarte(name).size();
        assertEquals(dim_exp, dim_found);
    }

    @Test
    public void testCautaCarteDupaAn(){
        //cautare cu succes
        String an = "1973";
        int dim_exp = 2;
        int dim_found = cartiRepository1.getCartiOrdonateDinAnul(an).size();
        assertEquals(dim_exp, dim_found);
    }

    @Test
    public void testare_integrare(){
        // P -> A -> B -> C
        testAdauga();
        testCautaDupaAutor();
        testCautaCarteDupaAn();
    }
}
