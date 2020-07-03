/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package megasena;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.Random;
import java.util.Iterator;
import java.util.Collections;
/**
 *
 * @author cleit
 */
public class Sena {
     
    private static final Set<Integer> globo = new HashSet<>();
     
    public Sena(){
        inicializaGlobo();
    }
    
    private void inicializaGlobo(){
        for(int i=1; i<=60; i++){
            globo.add(i);
        }
    } 
      
    private int getTotalNumGlobo(){
         return globo.size();
     }
    
    public int retiraNumero(){
        int posAleatoria = new Random().nextInt(getTotalNumGlobo());
        Iterator<Integer> iter = globo.iterator();
        
        for (int i=0; i<posAleatoria; i++){
            iter.next();
        } 
        int numSorteado = iter.next();

        globo.remove(numSorteado);
        
        return numSorteado;
    }
    
    public ArrayList<Integer> sorteiaNumeros(int qtdeNúmeros){
        ArrayList<Integer> sorteio = new ArrayList<>();
        for (int i=0; i<qtdeNúmeros; i++)
            sorteio.add(retiraNumero());
        Collections.sort(sorteio);
        inicializaGlobo(); // Reinicializa o globo
        return sorteio;
    }
    
    public static long calculaProbabilidade(int numJogados, int numAcertos){
        long probabilidade;
        
        long numQuadra = 60L*59L*58L*57L;
        long num;
        
        long den = numJogados;
        
        for (int i=1; i<6;i++){
            den = den*(numJogados-i);
        }
                    
        switch (numAcertos){
            case 4:
                num = numQuadra;
                break;
            case 5:
                num = numQuadra*56L;
                break;
            case 6:
                num = numQuadra*56L*55L;
                break;
            default:
                num = 0;
                break;
        }
        
        probabilidade = num/den;            
        return probabilidade;
    }
    
    //public sorteiaNumeros
    
}
