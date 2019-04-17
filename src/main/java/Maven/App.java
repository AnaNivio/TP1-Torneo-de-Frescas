package Maven;

import classes.*;

import java.sql.*;
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


        Humano ganador=competir(sortedListVikingos.get(aleatorioVikingos),sortedListEspartano.get(aleatorioEspartanos));

        if(ganador instanceof Vikingo){
            System.out.println("\n\n---------------------------FIN-------------------------------------");
            System.out.println("Ha ganado "+ ganador.getNombre() +" .Felicidades al equipo VIKINGOS!");
        }else
        {
            System.out.println("\n\n---------------------------FIN-------------------------------------");
            System.out.println("Ha ganado "+ ganador.getNombre() +" .Felicidades al equipo ESPARTANOS!");
        }


    /*PENDIENTE:
    * - Persistir el resultado en base de datos. REALIZADO EN LA VERSION 2
    * - Combate: ganador VS dueño*/

        try {
            Class.forName("com.mysql.jdbc.Driver");

        }catch (ClassNotFoundException e)
        {
            System.out.println("Falta la libreria de mysql!!");
        }


        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://localhost/tp1torneodefrescas", "root", "");

            PreparedStatement ps= connection.prepareStatement("INSERT INTO ganadoresDeTorneos(nombre_ganador,bebida_en_cuerpo)"
                    + "VALUES (?,?);");

            ps.setString(1,ganador.getNombre());
            ps.setInt(2,ganador.getBebidaEnCuerpo());

            ps.execute();


        }catch (SQLException e){

            System.out.println("No se pudo conectar a la base de datos");
        }
        catch (Exception e){
            System.out.println("es otra cosa");
        }




    }


    public static Humano competir(Humano h1, Humano h2)
    {
        Humano ganador=new Humano();

        if(h1 instanceof Vikingo && h2 instanceof Espartano){
            Vikingo v= (Vikingo) h1;
            Espartano e= (Espartano) h2;

            int limiteE=e.getLimite();
            limiteE= limiteE + e.gettoleranciaExtra();
            
            int restoLimiteE=limiteE;//

            int limiteV=v.getLimite();
            if(v.getbebedorProfesional() > 3)
            {
                limiteV=limiteV * 2;

            }
            
            int restoLimiteV=limiteV;//decidi crear estas variables restoLimite para sabe cuantas bebidas tomaron. Esto tendra sentido a la hora de setear la cant de bebidas en el ganador

            while (restoLimiteE > 0 && restoLimiteV > 0){

                v.beber();
                restoLimiteV= restoLimiteV - 1;

                e.beber();
                restoLimiteE=restoLimiteE - 1;

            }


            if(restoLimiteE == 0){
                e.orinar();
                ganador=v;
                v.setBebidaEnCuerpo(limiteV-restoLimiteV);//restoLimite representa cuantas bebidas mas hubiera soportado el humano. Si a eso se lo restamos al limite origina, obtendremos la cantidad de bebidas
            }

            if(restoLimiteV == 0){
                v.orinar();
                ganador=e;
                e.setBebidaEnCuerpo(limiteE-restoLimiteE);//
            }

        }

        return ganador;
    }
}

