/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import modelo.Usuario;

/**
 *
 * @author CASA
 */
public interface IUsuario {
    public void agrUsuario(Usuario u);
    public void borraUsu(Usuario u);
    public Usuario loginUser(String usr, String pas);
    
}
