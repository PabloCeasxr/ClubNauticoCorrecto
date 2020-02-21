/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capa;

import java.util.List;

/**
 *
 * @author pablo
 */
public interface SocioDAO {
    Socio find(int id) throws Exception;
    List<Socio> getAll() throws Exception;
    void add(Socio socio) throws Exception;
    void update(Socio socio) throws Exception;
    boolean delete(int id) throws Exception;
}

