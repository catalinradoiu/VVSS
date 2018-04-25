package biblioteca.repository.repo;

import biblioteca.model.Carte;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@SuppressWarnings("ArraysAsListWithZeroOrOneArgument")
public class CartiRepoTest {

    private CartiRepo cartiRepo;

    @Before
    public void setUp() throws Exception {
        cartiRepo = new CartiRepo();
    }

    @After
    public void tearDown() throws Exception {
        cartiRepo.golesteFisier();
    }

    @Test
    public void cautaCarteWBT1() {
        Carte carte = new Carte();
        carte.setTitlu("titlu");
        carte.setReferenti(new ArrayList<String>(Arrays.asList("abc")));
        carte.setAnAparitie("2010");
        carte.setEditura("edit");
        carte.setCuvinteCheie(new ArrayList<String>(Arrays.asList("ded")));
        cartiRepo.adaugaCarte(carte);
        List<Carte> result = cartiRepo.cautaCarte("test");
        assert  result.size() == 0;
    }

    @Test
    public void cautaCarteWBT2(){
        Carte carte = new Carte();
        carte.setTitlu("t1");
        carte.setReferenti(new ArrayList<String>(Arrays.asList("Popescu", "Ion")));
        carte.setAnAparitie("2010");
        carte.setEditura("ab");
        carte.setCuvinteCheie(new ArrayList<String>(Arrays.asList("d")));
        cartiRepo.adaugaCarte(carte);
        List<Carte> result = cartiRepo.cautaCarte("escu");
        assert  result.size() == 1;
    }

    @Test
    public void cautaCarteWBT3(){
        assert cartiRepo.cautaCarte("abc").size() == 0;
    }

    @Test
    public void cautaCarteWBT4(){
        Carte carte = new Carte();
        carte.setTitlu("titlu");
        carte.setReferenti(new ArrayList<String>(Arrays.asList("Popescu")));
        carte.setAnAparitie("2012");
        carte.setEditura("edit");
        carte.setCuvinteCheie(new ArrayList<String>(Arrays.asList("d")));

        Carte carte2 = new Carte();
        carte2.setTitlu("t2");
        carte2.setReferenti(new ArrayList<String>(Arrays.asList("Popsor")));
        carte2.setAnAparitie("2010");
        carte2.setEditura("ab");
        carte2.setCuvinteCheie(new ArrayList<String>(Arrays.asList("d")));

        cartiRepo.adaugaCarte(carte);
        cartiRepo.adaugaCarte(carte2);

        List<Carte> result = cartiRepo.cautaCarte("op");
        assert result.size() == 2;
    }
}