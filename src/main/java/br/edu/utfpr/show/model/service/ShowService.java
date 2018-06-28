/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.show.model.service;

import br.edu.utfpr.show.model.ShowDonation;
import br.edu.utfpr.show.model.dao.ShowDao;

/**
 *
 * @author tnks
 */
public class ShowService extends AbstractService<Long, ShowDonation> {

    public ShowService() {
        dao = new ShowDao();
    }

}
