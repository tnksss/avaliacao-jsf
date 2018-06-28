/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.show.bean;

import br.edu.utfpr.show.model.Event;
import br.edu.utfpr.show.model.Extra;
import br.edu.utfpr.show.model.ShowDonation;
import br.edu.utfpr.show.model.service.ShowService;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ronifabio
 */
@ManagedBean(eager = true)
@RequestScoped
public class ShowBean {

    private Event event;
    private ShowDonation showDonation;
    private Extra dadosExtras;
    private List<ShowDonation> showDonations;

    //injeção de dependência de outro ManagedBean
    @ManagedProperty(value = "#{totalBean}")
    private TotalBean totalBean;

    /**
     * Creates a new instance of ShowBean
     */
    public ShowBean() {
    }

    @PostConstruct
    private void init() {
        event = new Event("Vittace", new Date("06/22/2018"), new Date("06/28/2018"), "Guarapuava");
        showDonation = new ShowDonation();
        dadosExtras = new Extra();

    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public ShowDonation getShowDonation() {
        return showDonation;
    }

    public void setShowDonation(ShowDonation showDonation) {
        this.showDonation = showDonation;
    }

    public String clickHandler() {
        totalBean.addValorArrecadado(showDonation.getValorDoacao());
        ShowService showService = new ShowService();
        //instanciar o ShowService
        //chamar o save
        showService.save(showDonation);
        return "resultado";
    }

    public TotalBean getTotalBean() {
        return totalBean;
    }

    public void setTotalBean(TotalBean totalBean) {
        this.totalBean = totalBean;
    }

    public Extra getDadosExtras() {
        return dadosExtras;
    }

    public void setDadosExtras(Extra dadosExtras) {
        this.dadosExtras = dadosExtras;
    }

    public String resultVendas() {
        ShowService showService = new ShowService();
        showDonations = showService.findAll();
        this.addShowDonation(showDonation);
        return "vendas";
    }

    public int totalIngressos() {
        int total = 0;
        for (ShowDonation sd1 : showDonations) {
            total += sd1.getQtdIngressos();
        }
        return total;
    }

    public double totalRecebido() {
        double total = 0;
        for (ShowDonation sd2 : showDonations) {
            total += sd2.getValorDoacao();
        }
        return total;
    }

    public List<ShowDonation> getShowDonations() {
        return showDonations;
    }

    public void setShowDonations(List<ShowDonation> showDonations) {
        this.showDonations = showDonations;
    }

    public void addShowDonation(ShowDonation showDonation) {
        this.showDonations.add(showDonation);
    }
}
