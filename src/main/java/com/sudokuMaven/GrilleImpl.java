package com.sudokuMaven;
/**
 * Implémentation de la Classe Grille, GrilleImp.java.
 * @author Frieden, Loic, Ludovic.
 *
 */
public class GrilleImpl implements Grille {
    /**
     * @param grille le tableau représentant la grille du jeu.
     */
    private final char[][]grille;

    
    
    /**
     * Initialisation de la grille de jeu.
     * 
     * @param dimension la taille de la grille.
     */
    public GrilleImpl(final int dimension) {
        
        /* Création de la grille avec la taille entrée en
         * paramètre: 9 ou 16.
         */
        grille = new char[dimension][dimension];
        
        //Remplissage initial des cases de la grille avec la valeur EMPTY.
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                grille[i][j] = EMPTY;
            }
        }
    }

    
    
    public final int getDimension() {
        return grille.length;
    }
    
    

    /**
     * Ecriture de la methode setValue.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     */
    public final void setValue(final int x, final int y, final char value)
        throws IllegalArgumentException {

        if (valeurHorsBornes(x, y)) {
            throw new IllegalArgumentException("L'une des valeurs est"
                    + " hors bornes");
        }

        if (!possible(x, y, value)) {
            throw new IllegalArgumentException("Valeur interdite"
                    + " au vue des autres valeurs de la grille");
        }

        if (!caractereAutorise(value)) {
            throw new IllegalArgumentException("Caractère non autorisé");
        }

        grille[x][y] = value;
    }
    
    
    
    /**
     * Vérifie si le caractère à mettre dans la case est autorisée.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     * @param value valeur à mettre dans la case
     * @return true si le caractère est autorisé
     */
    private boolean caractereAutorise(final char value) {
        for (int i = 0; i < grille.length; i++) {
            if (value == POSSIBLE[i]) {
                return true;
            }
        }
        return false;
    }

    
    
    /**
     * Vérifie si le caractère à entrer est dans les bornes de la grille.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return true si la valeur est hors bornes.
     */
    private boolean valeurHorsBornes(final int x, final int y) {
        if ((x < 0 || x >= grille.length)
                || (y < 0 || y >= grille.length)) {
            return true;
        }
        return false;
    }
    
    
    
    /**
     * Ecriture de la methode getValue.
     * 
     * @author Frieden KODJO (fkodjo@gmail.com)
     * 
     */
    public final char getValue(final int x, final int y)
            throws IllegalArgumentException {

        valeurHorsBornes(x, y);
        return grille[x][y];
    }
    
    
    
    public final boolean complete() {
        //Non encore implémenté
        return true;
    }
    
    
    
    public final boolean possible(final int x, final int y, final char value)
            throws IllegalArgumentException {
        //Non encore implémenté
        return true;
    }

}
