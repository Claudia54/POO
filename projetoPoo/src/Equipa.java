
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
//import static java.util.stream.Collectors.toCollection;
//import static java.lang.System.out;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Equipa {
    private String equipa;
    private HashMap<Integer,Jogador> jogadores;
    


    public Equipa(){
    
        this.jogadores  = new HashMap<>();
        this.equipa = "n/a";
    }
    
    public Equipa(String equipa) {
        this.jogadores  = new HashMap<Integer, Jogador>();
        this.equipa = equipa;
    }

    public Equipa(HashMap<Integer, Jogador> jogadores,String equipa) {
        this.jogadores  = jogadores;
        this.equipa = equipa;
    }
    
    public String getEquipa(){
        return this.equipa;
    }

    public void setEquipa(String equipa){
      this.equipa =equipa;
    }

    public HashMap<Integer, Jogador> getJogadores() {
        HashMap<Integer, Jogador> list = jogadores;
        return list;
    }

    public void setJogadores(HashMap<Integer, Jogador> jogadores) {
        this.jogadores = jogadores;
    }
  
    public  void removerjogador (int numero){ // assumir que so fica no historico qd sai da equipa 
        if ( this.jogadores.containsKey(numero)){
           this.jogadores.remove(numero);
          }
  }
  
  public void adicionarjogadorRandom(Jogador jogador){ //acresentei o numero assumindo q o numero é dado na identificacao
    int numero = (int) Math.floor(Math.random()*(100)+1);
    while (jogadores.containsKey(numero)) numero = (int) Math.floor(Math.random()*(100)+1);
    this.jogadores.put(numero,jogador);
    this.jogadores.get(numero).addHistorico(equipa);
    
    }

    public Boolean containsJogador(int numero){
        return jogadores.containsKey(numero);
    }

    public void adicionarjogador(Jogador jogador, int numero){ //acresentei o numero assumindo q o numero é dado na identificacao
        this.jogadores.put(numero,jogador);
        this.jogadores.get(numero).addHistorico(equipa);
        
    }
    
    public EquipaJogo criarEquipaJogo(){
        View view = new View();
        Controller controller = new Controller();
        this.verJogadores();
        ArrayList jogEmCampo = new ArrayList<>();
        view.escJogTitu();
        while(jogEmCampo.size()!=12){
        
            view.printVar("digite o numero da camisola do Jogador");
            int num = controller.getInt();
            if(this.containsJogador(num)) jogEmCampo.add( jogadores.get(num));
            else view.jogadorNaoExite();
        } 
        
        ArrayList suplentes = new ArrayList<>();
        EquipaJogo eJogo = new EquipaJogo(0, Estado.NEUTRO, jogEmCampo, suplentes);
        

        return null;
    }
   
    public void verJogadores(){
        //aplicar a tostring a lista de jogadores

        System.out.println( this.jogadores.values());
        
    }



}