package Maven;

import classes.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello Strategies!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<Vikingo> vikingos= new ArrayList<Vikingo>();
        List<Espartano> espartanos=new ArrayList<Espartano>();

        vikingos= Arrays.asList(new Vikingo("Andrew",27,75,new ImpOrinarVikingo(),new ImpBeberVikingo(),1,5),
                new Vikingo("Jamie",45,81,new ImpOrinarVikingo(),new ImpBeberVikingo(),5,4),
                new Vikingo("Robert",57,85,new ImpOrinarVikingo(),new ImpBeberVikingo(),10,5),
                new Vikingo("Philip",18,65,new ImpOrinarVikingo(),new ImpBeberVikingo(),2,3));

        espartanos= Arrays.asList(new Espartano("Ned",56,80,new ImpOrinarEspartano(),new ImpBeberEspartano(),5,2),
                new Espartano("Jeff",19,70,new ImpOrinarEspartano(),new ImpBeberEspartano(),2,5),
                new Espartano("Frank",67,87,new ImpOrinarEspartano(),new ImpBeberEspartano(),1,3),
                new Espartano("Luther",38,80,new ImpOrinarEspartano(),new ImpBeberEspartano(),10,1));

        List<Vikingo> sortedListVikingos= vikingos.stream().sorted(Comparator.comparing(Vikingo::getEdad)).collect(Collectors.toList());
        List<Espartano> sortedListEspartano= espartanos.stream().sorted(Comparator.comparing(Espartano::getEdad)).collect(Collectors.toList());


        int aleatorioVikingos = (int)Math.floor(Math.random()*(sortedListVikingos.size()));
        int aleatorioEspartanos = (int)Math.floor(Math.random()*(sortedListEspartano.size()));


        String ganador=competir(sortedListVikingos.get(aleatorioVikingos),sortedListEspartano.get(aleatorioEspartanos));

        System.out.println("\n\n---------------------------FIN-------------------------------------");
        System.out.println("Ha ganado "+ ganador +" .Felicidades al equipo ganador!");

    /*PENDIENTE:
    * - Persistir el resultado en base de datos,
    * - Combate: ganador VS dueño*/



    }


    public static String competir(Humano h1, Humano h2)
    {
        String nombreGanador="";

        if(h1 instanceof Vikingo && h2 instanceof Espartano){
            Vikingo v= (Vikingo) h1;
            Espartano e= (Espartano) h2;

            int limiteE=e.getLimite();
            limiteE= limiteE + e.gettoleranciaExtra();

            int limiteV=v.getLimite();
            if(v.getbebedorProfesional() > 3)
            {
                limiteV=limiteV * 2;

            }

            while (limiteE > 0 || limiteV > 0){

                v.beber();
                limiteV= limiteV - 1;

                e.beber();
                limiteE=limiteE - 1;

            }


            if(limiteE == 0){
                e.orinar();
                nombreGanador=v.getNombre();
            }

            if(limiteV == 0){
                v.orinar();
                nombreGanador=e.getNombre();
            }

        }

        if(h1 instanceof Vikingo && h2 instanceof Espartano){
            Vikingo v= (Vikingo) h1;
            Espartano e= (Espartano) h2;

            int limiteE=e.getLimite();
            limiteE= limiteE + e.gettoleranciaExtra();

            int limiteV=v.getLimite();
            if(v.getbebedorProfesional() > 3)
            {
                limiteV=limiteV * 2;

            }

            while (limiteE > 0 || limiteV > 0){

                v.beber();
                limiteV= limiteV - 1;

                e.beber();
                limiteE=limiteE - 1;

            }


            if(limiteE == 0){
                e.orinar();
                nombreGanador=v.getNombre();
            }

            if(limiteV == 0){
                v.orinar();
                nombreGanador=e.getNombre();
            }

        }

        return nombreGanador;
    }
}

