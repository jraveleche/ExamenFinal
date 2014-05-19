import java.util.*;
import java.io.*;

public class NumerosReciclados {



    public static String abrirArchivo(String direccion){
        String aux="";
        String informacion="";
        FileReader archivo=null;
        File abrir=null;
        BufferedReader leer=null;
        try{

            abrir = new File(direccion);
            if(abrir!=null){
                archivo = new FileReader(abrir);
                leer = new BufferedReader(archivo);
                while((aux=leer.readLine())!=null){
                    informacion+=aux+"\n";
                    StringTokenizer tokens= new StringTokenizer(aux,"\n");
                    while(tokens.hasMoreTokens()){
                        tokens.nextToken();
                    }
                }
                leer.close();
            }
        }catch(IOException io){
            System.out.println(io.getMessage());
        }finally{

            try{
                if(null!=archivo){
                    archivo.close();
                }

            }catch(Exception e){
                System.out.println(e.getMessage());
            }
            return informacion;
        }
    }
    public static String comparar(String cadena){

        int size = 0;
        size=cadena.length();
        String conversion="";
        char [] sus = new char [size];
        for(int i=0; i<size; i++){
            sus[i]=cadena.charAt(i);
        }
        for(int j=0; j<size-1; j++){
            conversion=""+conversion+sus[j];
        }
        conversion = sus[size-1]+""+conversion;
        return conversion;
    }
    public static  boolean guardarArchivo (String a, String[] arg, String raiz) {
        boolean guardado=false;
        int size=0;
        size=arg.length;
        FileWriter fichero = null;
        PrintWriter pw = null;

        try

        {

            fichero = new FileWriter(raiz+"NumerosReciclados_201314076.txt");

            pw = new PrintWriter(fichero);
            pw.println(a);

            for (int i = 0; i < size ; i++)

                pw.println(arg[i]);



        } catch (Exception e) {

            e.printStackTrace();

        } finally {

            try {

                guardado=true;
                if (null != fichero)

                    fichero.close();

            } catch (Exception e2) {

                e2.printStackTrace();

            }

        }

        return guardado;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String direccion="";
        System.out.println("Por favor escriba la direccion del archivo");
        if(scan.hasNext()){
            direccion =scan.next();
        }
        System.out.println(abrirArchivo(direccion));
        System.out.println(comparar(abrirArchivo(direccion)));
            String text="";
            String texto2="";
            int reverso=0;
            int cont=0;
            int index=args.length;
            String[] argo=new String[index];
            String raiz=argo[0];
            String raiz2="";
            String s = System.getProperty("file.separator") ;
            String[] directorio=raiz.split(s);

            for(int z=0; z<directorio.length-1; z++){

                raiz2=raiz2+directorio[z]+""+s;

            }

            System.out.println("Direccion: "+raiz2);
            String a, p1, p2="";
            int size=0;
            System.out.println("Numeros Reciclados");
            text=abrirArchivo(args[0]);
            String [] t = text.split("\n");

            try{
                size=Integer.parseInt(t[0]);

            }catch(Exception e){

                System.out.println("Error"+ e);

            }

            for(int n=0; n<=size; n++){
                texto2=texto2+t[n]+"\n";

            }



            System.out.println("Casos No.1  " + size);
            String[]impresion= new String[size];
            String[][] rangos = new String[size][2];
            int[][] range= new int[size][2];

            for(int m=0; m<size; m++){

                try{

                    rangos[m]=t[m+1].split(" ");
                    System.out.println("Caso No. "+(m+1)+": "+rangos[m][0]+" - "+rangos[m][1] );

                }catch(Exception e){

                    System.out.println("Error: "+(m+1)+"\n"+

                            "Revise el archivo");
                }

            }for(int i=0; i<size; i++){

                for(int j=0; j<2; j++){

                    try{

                        range[i][j]=Integer.parseInt(rangos[i][j]);

                    }catch(Exception e){

                        System.out.println("Error "+(i+1)+" En el intervalo " +(j+1));

                    }

                }
            }



            System.out.println();

            for(int i=0; i<size; i++){
                for(int j=range[i][0]; j<=range[i][1]; j++){

                    a=""+j;

                    reverso=a.length();
                    if(reverso>0){

                        for(int k=(j+1); k<=range[i][1]; k++){

                            p2="";

                            p1=""+k;
                            for(int m=0; m<reverso; m++){

                                p2=comparar(p1);

                                p1=p2;

                                if(a.equals(""+p1)){

                                    cont ++;

                                }

                            }

                        }

                    }

                }impresion[i]="Caso No."+(i+1)+": "+cont;

                			cont=0;

                		}

           		for(int o=0; o<size; o++){

                				System.out.println(impresion[o]);

                		}

            		if(guardarArchivo(texto2, impresion, raiz2)){

                			System.out.println("Se ah guardado el archivo");

                		}else{

                			System.out.println("No se guardo el archivo");

                		}



                     }
}