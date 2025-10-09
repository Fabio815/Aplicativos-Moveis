package br.com.ifsc;

import java.util.ArrayList;

public class DAOPlaneta {
    private ArrayList<Planeta> planetas;

    public DAOPlaneta() {
        planetas = new ArrayList<Planeta>();
    }

    //Inserir Planetas
    public void inserirPlanetas(Planeta p) {
        this.planetas.add(p);
    }

    public ArrayList<Planeta> getPlanetas() {
        return planetas;
    }

    public Planeta get(int posicao) {
        return  this.planetas.get(posicao);
    }
}
