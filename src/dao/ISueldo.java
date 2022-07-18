/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author CASA
 */
public interface ISueldo {
    public void grabaSueldo(String codemp);
    public void grabaBon(double mbon);
    public void grabaDes(double mdes);
    public void grabaVac(double mvac);
    public void grabaCts(double tsue,String fces,int mlab,double mcts,String fec);
    public void grabaTot(double mtot);
    public void cambiaHhee(String cod,int hhee);
    public void cambiaMvent(String cod,int mvnt);
    
    
}
