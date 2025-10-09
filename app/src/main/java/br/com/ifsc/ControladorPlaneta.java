package br.com.ifsc;

import java.util.ArrayList;

public class ControladorPlaneta {
    DAOPlaneta dao;
    public ControladorPlaneta() {
        dao = new DAOPlaneta();
        dao.inserirPlanetas(new Planeta("Mercurio", R.drawable.mercury));
        dao.inserirPlanetas(new Planeta("Venus", R.drawable.venus));
        dao.inserirPlanetas(new Planeta("Terra", R.drawable.earth));
        dao.inserirPlanetas(new Planeta("Jupiter", R.drawable.jupter));
        dao.inserirPlanetas(new Planeta("Saturno", R.drawable.saturn));
        dao.inserirPlanetas(new Planeta("Urano", R.drawable.uranus));
        dao.inserirPlanetas(new Planeta("Netuno", R.drawable.neptune));
    }

    public ArrayList<Planeta> getPlanetas() {
        return dao.getPlanetas();
    }

    public Planeta get(int posicao) {
        return dao.get(posicao);
    }
}
