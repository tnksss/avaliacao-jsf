/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.show.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;

/**
 * Guarda o total de acessos no escopo de aplicação
 *
 * @author ronifabio
 */
@ManagedBean(name = "totalBean", eager = true)
@ApplicationScoped
public class TotalBean {

    private List<String> shows;
    private double totalArrecadado;

    /**
     * Creates a new instance of TotalBean
     */
    public TotalBean() {
    }

    @PostConstruct
    private void init() {
        shows = new ArrayList<String>();
        shows.add("Banda Dejavu");
        shows.add("Modern Talking");
        shows.add("ColdPlay");
        shows.add("Rebelde");
        shows.add("KLB");

        totalArrecadado = 0;
    }

    public List<String> getShows() {
        return shows;
    }

    public void setShows(List<String> shows) {
        this.shows = shows;
    }

    public double getTotalArrecadado() {
        return totalArrecadado;
    }

    public void setTotalArrecadado(double totalArrecadado) {
        this.totalArrecadado = totalArrecadado;
    }

    public void addValorArrecadado(double totalArrecadado) {
        this.totalArrecadado += totalArrecadado;
    }

}
