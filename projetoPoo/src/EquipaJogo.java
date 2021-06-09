import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EquipaJogo {
    private int score;
    private Estado estado;
    private ArrayList<Jogador> jogEmCampo;
    private ArrayList<Jogador> suplentes;

    public EquipaJogo(int score, Estado estado, ArrayList<Jogador> jogEmCampo, ArrayList<Jogador> suplentes) {
        this.score = score;
        this.estado = estado;
        this.jogEmCampo = jogEmCampo;
        this.suplentes = suplentes;
    }

    public boolean estaAtacar(){
        if (estado == Estado.ATAQUE) return true;
        else return false;
    }

    public boolean marcou(EquipaJogo adversaria){
        int numRand = (int) Math.floor(Math.random()*(100)+1);
        if (this.probSucAtaque(adversaria) >= numRand) return true;
        else return false;
    }

    public boolean perdeuBola() {
        int numRand = (int) Math.floor(Math.random()*(100)+1);
        if (this.probPerdaBola() >= numRand) return true;
        else return false;
    }

   

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public ArrayList<Jogador> getJogEmCampo() {
        return jogEmCampo;
    }

    public void setJogEmCampo(ArrayList<Jogador> jogEmCampo) {
        this.jogEmCampo = jogEmCampo;
    }

    public ArrayList<Jogador> getSuplentes() {
        return suplentes;
    }

    public void setSuplentes(ArrayList<Jogador> suplentes) {
        this.suplentes = suplentes;
    }

    public int avgHabilidade(Function <Jogador, Integer> f){

        List<Integer> listRem =   this.getJogEmCampo().stream()
                                                   .map(f)
                                                   .collect(Collectors.toList());

        int mediaRemate = listRem.stream().mapToInt(Integer::intValue).sum()/listRem.size();
        
        return mediaRemate;
    }


    public int probSucAtaque(EquipaJogo adversaria) {
        
        int mediaRemateBaliza = this.avgHabilidade(Jogador::cpRemateBaliza);
        

        //System.out.println(mediaVel);
        

        return mediaRemateBaliza;
    }

    public int probPerdaBola() {
        
        int mediaPerda = this.avgHabilidade(Jogador::probPerda);

        
        //System.out.println(mediaPerda);
        return mediaPerda;
    }
    
}
